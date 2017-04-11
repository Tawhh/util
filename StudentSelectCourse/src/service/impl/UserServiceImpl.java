package service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import model.Role;
import model.User;

import org.hibernate.Query;
import org.springframework.stereotype.Service;

import dao.UserDao;
import database.DataBase;

import service.UserService;

@Service("userService")
public class UserServiceImpl extends DataBase implements UserService {
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public int userLogin(User user) {
		User use = userDao.userLogin(user.getUsername());
		if (use != null) {
			if (user.getPassword().equals(use.getPassword())) {

				return 1;
			} else {
				return 0;
			}
		} else {
			return 2;
		}
	}

	public User userFind(String username) {
		User use = userDao.userLogin(username);
		return use;
	}

	public int userRegister(User user) {
		User use = userDao.userLogin(user.getUsername());
		if (use != null) {
			return 0;
		} else {
			int x = userDao.userRegister(user);
			return 1;
		}
	}

	public int usersAll() {

		return userDao.querySize();
	}

	public List userssAll(int begin, int page) {
		// TODO Auto-generated method stub
		return userDao.userAll(begin, page);
	}

	public int pwdupdate(String username, String password, String password1,
			String password2, String password3) {
		if (password1.equals(password)) {
			if (password2.equals(password3)) {
				int x = userDao.pwdupdate(username, password2);
				if (x == 1) {
					return 1;
				} else {
					return 0;
				}
			} else {
				return 3;
			}
		} else {
			return 2;
		}
	}

	public int userDelete(String username) {
		try {
			User use = userDao.userLogin(username);
			getSession().delete(use);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	public int userupdate(int uid, int rid, String username, String password,
			String password1, String password2, String password3) {
		User use = userDao.userLogin(username);
		if (use != null) {
			return 1;// 用户名存在
		} else {
			if (password.equals(password1)) {
				if (password2.equals(password3)) {
					userDao.userupdate(uid, rid, username, password2);
					return 3;// 成功
				} else {
					return 4;// 两次新密码不一致
				}
			} else {
				return 2;// 原密码输入错误
			}
		}
	}

	public List findid(int uid) {
		List list = new ArrayList();
		String hql = "from User where uid=?";
		Query query = getSession().createQuery(hql);
		query.setInteger(0, uid);
		User user = (User) query.uniqueResult();
		if (user != null) {
			list.add(user);
			return list;
		} else {
			return list;
		}
	}
	public List findname(String username) {
		List list = new ArrayList();
		String hql = "from User where username=?";
		Query query = getSession().createQuery(hql);
		query.setString(0, username);
		User user = (User) query.uniqueResult();
		if (user != null) {
			list.add(user);
			return list;
		} else {
			return list;
		}
	}
	public List findrole(String rname) {
		
		String hql = "from User where rid=(select rid from Role where rname=?)";
		Query query = getSession().createQuery(hql);
		query.setString(0, rname);
		List list=query.list();
		if (list.size()>0) {
			return list;
		} else {
			List list1=new ArrayList();
			return list1;
		}
	}
	public int noadmin(int uid, String username, String password,
			String password1, String password2, String password3) {
		User use = userDao.userLogin(username);
		if (use != null) {
			return 1;// 用户名存在
		} else {
			if (password.equals(password1)) {
				if (password2.equals(password3)) {
					userDao.noadminupdate(uid, username, password3);
					return 3;// 成功
				} else {
					return 4;// 两次新密码不一致
				}
			} else {
				return 2;// 原密码输入错误
			}
		}
	}
}
