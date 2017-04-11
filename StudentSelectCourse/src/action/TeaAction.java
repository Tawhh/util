package action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import service.TeaService;
import model.Teacher;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import database.DataBase;

@Controller
@Scope("prototype")
public class TeaAction extends ActionSupport implements ModelDriven<Teacher> {
	private Teacher teacher;
	private String message;
	private TeaService teaService;
	private int pageSize = 5; // 每页显示记录数
	private int pageCount = 0; // 总页数
	private int page = 1; // 当前页数
	private int begin = 0;// 从第几条记录开始
	private String findone;

	public String getFindone() {
		return findone;
	}

	public void setFindone(String findone) {
		this.findone = findone;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public TeaService getTeaService() {
		return teaService;
	}

	@Resource
	public void setTeaService(TeaService teaService) {
		this.teaService = teaService;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		pageCount = (teaService.querySize() % 5 == 0) ? (teaService.querySize() / 5)
				: (teaService.querySize() / 5 + 1);
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

	@Override
	public Teacher getModel() {
		if (teacher == null) {
			teacher = new Teacher();
		}
		return teacher;
	}

	public String teaAll() {
		List list = teaService.teaAll(getBegin(), getPageSize());
		Map map = new DataBase().getSession1();
		map.put("listtea", list);
		map.put("count", teaService.querySize());
		map.put("curPage", getPage());
		map.put("pageCount", getPageCount());
		return "allsuccess";
	}

	public String teaadd() {
		int x = teaService.teaAdd(teacher);
		if (x == 1) {
			message = "添加成功";
			return teaAll();
		} else {
			message = "添加失败";
			return "addfail";
		}
	}

	public String delete() {
		int x = teaService.delete(teacher.getTid());
		if (x == 1) {
			message = "删除成功";
			return teaAll();
		} else {
			return "defail";
		}
	}

	public String findid() {
		List list = teaService.teaone(Integer.parseInt(findone));
		if (list.size() > 0) {
			Map map = new DataBase().getSession1();
			map.put("listid", list);
			return "onesuccess";
		} else {
			message = "查无此人";
			return "onefail";
		}
	}

	public String update() {
		int x = teaService.teaUpdate(teacher.getTid(), teacher.getTname(),
				teacher.getSex(), teacher.getSc(), teacher.getMajor());
		message = "修改成功";
		return teaAll();
	}
}