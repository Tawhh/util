package action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import service.CourseService;

import model.Course;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import database.DataBase;

@Controller
@Scope("prototype")
public class CourseAction extends ActionSupport implements ModelDriven<Course> {
	private String message;
	private int pageSize = 5; // 每页显示记录数
	private int pageCount = 0; // 总页数
	private int page = 1; // 当前页数
	private int begin = 0;// 从第几条记录开始
	private Course course;
	private String findcourse;
	public CourseService courseService;
	
	public CourseService getCourseService() {
		return courseService;
	}
	@Resource
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}

	public String getFindcourse() {
		return findcourse;
	}

	public void setFindcourse(String findcourse) {
		this.findcourse = findcourse;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		pageCount = (courseService.courseAll() % 5 == 0) ? (courseService
				.courseAll() / 5) : (courseService.courseAll() / 5 + 1);
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getBegin() {
		begin = (page - 1) * pageSize;
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public Course getModel() {
		if (course == null) {
			course = new Course();
		}
		return course;
	}

	public String courseAll() {
		List list = courseService.courseall(getBegin(), getPageSize());
		Map map = new DataBase().getSession1();
		map.put("listcourse", list);
		map.put("count", courseService.courseAll());
		map.put("curPage", getPage());
		map.put("pageCount", getPageCount());
		return "coursesuccess";
	}

	public String coursedelete() {
		int x = courseService.courseDelete(course.getCid());
		if (x == 1) {
			message = "删除成功";
			return courseAll();
		} else {
			message = "不允许删除";
			return "defail";
		}
	}

	public String courseaddq() {
		List listtea = courseService.courseTea();
		Map map = new DataBase().getSession1();
		map.put("listtea", listtea);
		return "courseaddqsuccess";
	}

	public String courseadd() {
		List list = courseService.coursefindid(course.getCid());
		if (list.size() == 0) {
			int x = courseService.courseadd(course);
			if (x == 1) {
				message = "添加成功";
				return courseAll();
			} else {
				message = "输入有误 ";
				return "addfail";
			}
		} else {
			message = "课程编号存在";
			return "addfail";
		}
	}

	public String coursefindid() {
		List listone = courseService.coursefindid(Integer.parseInt(findcourse));
		if (listone.size() > 0) {
			Map map = new DataBase().getSession1();
			map.put("listone", listone);
			return "idsuccess";
		} else {
			message = "无ID为" + findcourse + "的人";
			return "idfail";
		}
	}

	public String coursefindtype() {
		System.out.println(findcourse);
		List listone = courseService.coursefindtype(findcourse);
		if (listone.size() > 0) {
			Map map = new DataBase().getSession1();
			map.put("listone", listone);
			return "typesuccess";
		} else {
			message = "输入有误！";
			return "typefail";
		}
	}

	public String courseupdate() {
		List list = courseService.updateTea(course.getCid());
		Map map = new DataBase().getSession1();
		map.put("listtea", list);
		return "upqsuccess";
	}

	public String Reupdate() {
		int x = courseService.courseupdate(course.getCid(), course.getTeacher()
				.getTid(), course.getCname(), course.getClassTime(), course
				.getCredit(), course.getClassHour(), course.getClassType(),
				course.getClassAddr(), course.getClassProperty());
		if(x==1){
			message="修改成功";
			return courseAll();
		}else{
			message="修改异常";
			return "Refail";
		}
	}

}
