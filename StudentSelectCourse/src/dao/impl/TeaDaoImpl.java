package dao.impl;

import java.util.List;

import model.Teacher;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import dao.TeaDao;
import database.DataBase;

@Component("teaDao")
public class TeaDaoImpl extends DataBase implements TeaDao {
	public int querySize() {
		int x = getSession().createQuery("from Teacher").list().size();
		return x;
	}

	public List teaAll(int begin, int pageSize) {
		String hql = "from Teacher";
		Query query = getSession().createQuery(hql);
		query.setFirstResult(begin);
		query.setMaxResults(pageSize);
		List list = query.list();
		return list;
	}

	public Teacher findde(int tid) {
		String hql = "from Teacher where tid=?";
		Query query = getSession().createQuery(hql);
		query.setInteger(0, tid);
		Teacher tea = (Teacher) query.uniqueResult();
		return tea;
	}

	public int teaUpdate(int tid, String tname, String sex, String sc, String major) {
		String hql = "update Teacher set tname='" + tname + "',sex='" + sex
				+ "',sc='" + sc + "',major='" + major + "' where tid=?";
		Query query = getSession().createQuery(hql);
		query.setInteger(0, tid);
		int x = query.executeUpdate();
		return x;
	}

}
