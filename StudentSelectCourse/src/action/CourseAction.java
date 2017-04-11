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
	private int pageSize = 5; // ÿҳ��ʾ��¼��
	private int pageCount = 0; // ��ҳ��
	private int page = 1; // ��ǰҳ��
	private int begin = 0;// �ӵڼ�����¼��ʼ
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
			message = "ɾ���ɹ�";
			return courseAll();
		} else {
			message = "������ɾ��";
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
				message = "��ӳɹ�";
				return courseAll();
			} else {
				message = "�������� ";
				return "addfail";
			}
		} else {
			message = "�γ̱�Ŵ���";
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
			message = "��IDΪ" + findcourse + "����";
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
			message = "��������";
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
			message="�޸ĳɹ�";
			return courseAll();
		}else{
			message="�޸��쳣";
			return "Refail";
		}
	}

}
