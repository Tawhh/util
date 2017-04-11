package action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import service.StuService;

import model.Student;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import database.DataBase;

@Controller
@Scope("prototype")
public class StuAction extends ActionSupport implements ModelDriven<Student> {
	private Student student;
	private StuService stuService;
	private String message;
	private int pageSize = 5; // ÿҳ��ʾ��¼��
	private int pageCount = 0; // ��ҳ��
	private int page = 1; // ��ǰҳ��
	private int begin = 0;// �ӵڼ�����¼��ʼ
	private String findone;

	public StuService getStuService() {
		return stuService;
	}

	@Resource
	public void setStuService(StuService stuService) {
		this.stuService = stuService;
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
		pageCount = (stuService.querySize() % 5 == 0) ? (stuService.querySize() / 5)
				: (stuService.querySize() / 5 + 1);
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

	public String getFindone() {
		return findone;
	}

	public void setFindone(String findone) {
		this.findone = findone;
	}

	public Student getModel() {
		if (student == null) {
			student = new Student();
		}
		return student;
	}

	public String stuAll() {
		List list = stuService.stuAll(getBegin(), getPageSize());
		Map map = new DataBase().getSession1();
		map.put("liststu", list);
		map.put("count", stuService.querySize());
		map.put("curPage", getPage());
		map.put("pageCount", getPageCount());
		return "allsuccess";
	}

	public String findid() {
		List list = stuService.findOne(Integer.parseInt(findone));
		if (list.size() > 0) {
			Map map = new DataBase().getSession1();
			map.put("listone", list);
			return "onesuccess";
		} else {
			message = "���޴���";
			return "onefail";
		}
	}

	public String delete() {
		int x = stuService.delete(student.getSid());
		if (x == 1) {
			message = "ɾ���ɹ�";
			return stuAll();
		} else {
			message = "������ɾ��";
			return "defail";
		}
	}

	public String stuadd() {
		int x = stuService.stuadd(student);
		if (x == 1) {
			message = "��ӳɹ�";
			return stuAll();
		} else {
			message = "�Դ���ID";
			return "addfail";
		}
	}

	public String update1() {
		Student stu = stuService.find(student.getSid());
		Map map = new DataBase().getSession1();
		map.put("stu", stu);
		return "update1";

	}

	public String update() {
		int x = stuService.stupdate(student.getSid(), student.getSname(),
				student.getSex(), student.getSc(), student.getMajor(), student
						.getSumClassHour(), student.getSumCredit());
		if (x == 1) {
			message = "�޸ĳɹ�";
			return stuAll();
		} else {
			message = "�޸��쳣";
			return "upfail";
		}
	}
}
