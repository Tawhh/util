package dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import model.Role;
import model.User;
import dao.UserDao;
import database.DataBase;

@Component("userDao")
public class UserDaoImpl extends DataBase implements UserDao {

	public User userLogin(String username) {
		String hql = "from User where username=?";
		Query query = getSession().createQuery(hql);
		query.setString(0, username);
		User user = (User) query.uniqueResult();
		return user;
	}

	public int userRegister(User user) {
		getSession().save(user);
		return 1;
	}

	public List userAll(int begin, int PageSize) {
		String hql = "from User";
		Query query = getSession().createQuery(hql);
		query.setFirstResult(begin);
		query.setMaxResults(PageSize);
		List list = query.list();
		return list;
	}

	public int querySize() {
		int x = getSession().createQuery("from User").list().size();
		return x;
	}

	public int pwdupdate(String username, String pwd) {
		String hql = "update User set password='" + username
				+ "' where username=?";
		Query query = getSession().createQuery(hql);
		query.setString(0, username);
		int x = query.executeUpdate();
		return x;
	}

	public int userupdate(int uid, int rid, String username, String password) {
		String hql = "update User set rid=" + rid + ",username='" + username
				+ "',password='" + password + "' where uid=?";
		Query query = getSession().createQuery(hql);
		query.setInteger(0, uid);
		int x = query.executeUpdate();
		return x;
	}

	public int noadminupdate(int uid, String username, String password) {
		String hql = "update User set username='" + username
				+ "',password='" + password + "' where uid=?";
		Query query = getSession().createQuery(hql);
		query.setInteger(0, uid);
		int x = query.executeUpdate();
		return x;
	}
}
