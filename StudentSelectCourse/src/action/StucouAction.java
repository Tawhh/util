package action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import model.StuCou;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import service.StucouService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import database.DataBase;

@Controller
@Scope("prototype")
public class StucouAction extends ActionSupport implements ModelDriven<StuCou> {
	private int name;

	private StuCou stucou;
	private String message;
	private StucouService stucouService;
	private int pageSize = 7; // 每页显示记录数
	private int pageCount = 0; // 总页数
	private int page = 1; // 当前页数
	private int begin = 0;// 从第几条记录开始
	// private int uid;
	//	
	//
	// public int getUid() {
	// return uid;
	// }
	//
	// public void setUid(int uid) {
	// this.uid = uid;
	// }

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		pageCount = (stucouService.querySize() % 7 == 0) ? (stucouService
				.querySize() / 7) : (stucouService.querySize() / 7 + 1);
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

	public StucouService getStucouService() {
		return stucouService;
	}

	@Resource
	public void setStucouService(StucouService stucouService) {
		this.stucouService = stucouService;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public StuCou getModel() {
		if (stucou == null) {
			stucou = new StuCou();
		}
		return stucou;
	}

	public String stucouall() {
		List list = stucouService.Stu(getBegin(), getPageSize());
		Map map = new DataBase().getSession1();
		map.put("list", list);
		map.put("count", stucouService.querySize());
		map.put("curPage", getPage());
		map.put("pageCount", getPageCount());
		return "success";
	}

	public String delete() {
		if (name != 0) {
			int x = stucouService.stucoude(name);
			if (x == 1) {

				return stucouall();
			} else {
				message = "不需要退课";
				return "fail";
			}
		} else {
			message = "不需要退课";
			return "fail";
		}
	}

	public String find() {
		List list = stucouService.stucouall(name);
		Map map = new DataBase().getSession1();
		map.put("list", list);
		return "allsuccess";

	}

	public String stucou() {
		List<StuCou> list=new ArrayList<StuCou>();
		list= stucouService.stucou();
//		Map map = new DataBase().getSession1();
//		map.put("list", list);
		ActionContext.getContext().put("list", list);
		return "stucou";

	}

	public String select() {
		int x = stucouService.stuCou(stucou.getCourse().getCid(), stucou
				.getStudent().getSid(), stucou);
		if (x == 1) {
			return already();
		} else {
			message = "无需重复选课";
			return stucou();
		}
	}

	public String already() {
		List list = stucouService.stucouone(stucou.getStudent().getSid());
		if (list.size() > 0) {
			ActionContext.getContext().put("listone", list);
			return "alsuccess";
		} else {
			message="无选课信息";
			return "alfail";
		}
	}

	public String deleteone() {
		int x = stucouService.deleteone(stucou.getId());
		return already();

	}
}
