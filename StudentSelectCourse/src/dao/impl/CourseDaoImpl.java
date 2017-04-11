package dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import model.Course;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import dao.CourseDao;
import database.DataBase;

@Component("courseDao")
public class CourseDaoImpl extends DataBase implements CourseDao {
	public List Course(int begin, int pagesize) {
		String hql = "from Course";
		Query query = getSession().createQuery(hql);
		query.setFirstResult(begin);
		query.setMaxResults(pagesize);
		List list = query.list();
		return list;
	}

	public int querySize() {
		int x = getSession().createQuery("from Course").list().size();
		return x;
	}

	public Course courseDelete(int cid) {
		String hql = "from Course where cid=?";
		Query query = getSession().createQuery(hql);
		query.setInteger(0, cid);
		Course course = (Course) query.uniqueResult();
		return course;
	}

	public Course coursefindid(int cid) {
		String hql = "from Course where cid=?";
		Query query = getSession().createQuery(hql);
		query.setInteger(0, cid);
		Course course = (Course) query.uniqueResult();
		return course;
	}

	public List coursefindProperty(int type) {
		String hql = "from Course where classProperty=?";
		Query query = getSession().createQuery(hql);
		query.setInteger(0, type);
		List list = query.list();
		return list;
	}

	
}
