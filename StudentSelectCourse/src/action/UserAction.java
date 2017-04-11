package action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import service.UserService;

import model.User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import database.DataBase;

@Controller
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven<User> {
	private User user;
	private String message;
	private UserService userService;
	private int pageSize = 5; // 每页显示记录数
	private int pageCount = 0; // 总页数
	private int page = 1; // 当前页数
	private int begin = 0;// 从第几条记录开始
	private String password1;
	private String password2;
	private String password3;
	private String findone;

	public String getFindone() {
		return findone;
	}

	public void setFindone(String findone) {
		this.findone = findone;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getPassword3() {
		return password3;
	}

	public void setPassword3(String password3) {
		this.password3 = password3;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		pageCount = (userService.usersAll() % 5 == 0) ? (userService.usersAll() / 5)
				: (userService.usersAll() / 5 + 1);
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public UserService getUserService() {
		return userService;
	}

	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getModel() {
		if (user == null) {
			user = new User();
		}
		return user;
	}

	public String login() {
		int x = userService.userLogin(user);
		User use = userService.userFind(user.getUsername());
		if (x == 1) {
			new DataBase().getSession1().put("user", use);
			List list = new ArrayList();
			list.add(use);
			new DataBase().getSession1().put("list", list);
			if (use.getRole().getRid() == 3) {
				return "3success";
			} else if (use.getRole().getRid() == 2) {
				return "2success";
			} else
				return "1success";
		} else if (x == 2) {
			message = "用户名不存在";
			return "loginfail";
		} else {
			message = "密码错误";
			return "loginfail";
		}
	}

	public String userRegister() {
		int x = userService.userRegister(user);
		if (x == 1) {
			message = "注册成功";
			return "Resuccess";
		} else {
			message = "用户名存在";
			return "Refail";

		}
	}

	@SuppressWarnings("unchecked")
	public String userAll() {
		List list = userService.userssAll(getBegin(), getPageSize());
		Map map = new DataBase().getSession1();
		map.put("list", list);
		map.put("count", userService.usersAll());
		map.put("curPage", getPage());
		map.put("pageCount", getPageCount());
		return "fensuccess";
	}

	public String pwdupdate() {
		int x = userService.pwdupdate(user.getUsername(), user.getPassword(),
				password1, password2, password3);
		if (x == 1) {
			message = "请重新登陆";
			return "pwdsuccess";
		} else if (x == 0) {
			message = "修改异常";
			return "pwdfail";
		} else if (x == 2) {
			message = "原密码输入错误";
			return "pwdfail";
		} else {
			message = "两次新密码不一致";
			return "pwdfail";
		}
	}

	public String userDelete() {
		int x = userService.userDelete(user.getUsername());
		if (x == 1) {
			userService.userssAll(getBegin(), getPageSize());
			message = "删除成功";
			return userAll();
		} else {
			message = "不能删除";
			return "defail";
		}
	}

	public String useradd() {
		int x = userService.userRegister(user);
		if (x == 1) {
			message = "新增用户成功";
			return userAll();
		} else {
			message = "用户名存在";
			return "addfail";

		}
	}

	public String userupdate() {
		int x = userService.userupdate(user.getUid(), user.getRole().getRid(),
				user.getUsername(), user.getPassword(), password1, password2,
				password3);
		if (x == 1) {
			message = "用户名存在";
			return "uufail";
		} else if (x == 2) {
			message = "原密码输入错误";
			return "uufail";
		} else if (x == 3) {
			message = "修改成功";
			return userAll();
		} else {
			message = "两次新密码不一致";
			return "uufail";
		}
	}

	public String findid() {
		if (findone.equals("")) {
			message = "请输入正确的ID";
			return "findfail";
		} else {
			List list = userService.findid(Integer.parseInt(findone));
			if (list.size() == 0) {
				message = "没有ID为" + findone + "的用户";
				return "findfail";
			} else {
				new DataBase().getSession1().put("list1", list);
				return "findsuccess";
			}

		}
	}

	public String findname() {
		List list = userService.findname(findone);
		if (list.size() == 0) {
			message = "没有用户名为" + findone + "的用户";
			return "findnamefail";
		} else {
			new DataBase().getSession1().put("list1", list);
			return "findnamesuccess";
		}
	}

	public String findrole() {
		List list = userService.findrole(findone);
		if (list.size() == 0) {
			message = "没有角色为" + findone + "的用户";
			return "findnamefail";
		} else {
			new DataBase().getSession1().put("list1", list);
			return "findnamesuccess";
		}
	}

	public String noadmin() {
		int x = userService.noadmin(user.getUid(), user.getUsername(), user
				.getPassword(), password1, password2, password3);
		if (x == 1) {
			message = "用户名存在";
			return "noadminfail";
		} else if (x == 2) {
			message = "原密码输入错误";
			return "noadminfail";
		} else if (x == 3) {
			message = "修改成功";
			return "noadminsuccess";
		} else {
			message = "两次新密码不一致";
			return "noadminfail";
		}
	}

}
