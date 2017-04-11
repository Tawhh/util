package dao.impl;

import java.util.List;

import model.Student;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import dao.StuDao;
import database.DataBase;

@Component("stuDao")
public class StuDaoImpl extends DataBase implements StuDao {

	public int querySize() {

		int x = getSession().createQuery("from Student").list().size();
		return x;
	}

	public List stuAll(int begin, int pageSize) {

		String hql = "from Student";
		Query query = getSession().createQuery(hql);
		query.setFirstResult(begin);
		query.setMaxResults(pageSize);
		List list = query.list();
		return list;
	}

	public Student findone(int sid) {
		String hql = "from Student where sid=?";
		Query query = getSession().createQuery(hql);
		query.setInteger(0, sid);
		Student stu = (Student) query.uniqueResult();
		return stu;
	}

	public int stupdate(int sid, String sname, int sex, String sc,
			String majoer, int hour, int credit) {
		String hql = "update Student set sname='" + sname + "',sex=" + sex
				+ ",sc='" + sc + "',major='" + majoer + "',sumClassHour="
				+ hour + ",sumCredit=" + credit + " where sid=?";
		Query query=getSession().createQuery(hql);
		query.setInteger(0,sid);
		int x=query.executeUpdate();
		return x;
	}

}
