package service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import model.Course;

import org.hibernate.Query;
import org.springframework.stereotype.Service;

import dao.CourseDao;
import database.DataBase;

import service.CourseService;

@Service("courseService")
public class CourseServiceImpl extends DataBase implements CourseService {
	public CourseDao courseDao;

	public CourseDao getCourseDao() {
		return courseDao;
	}
   @Resource
	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}

	public int courseAll() {
		return courseDao.querySize();
	}

	public List courseall(int begin, int pageSize) {

		return courseDao.Course(begin, pageSize);
	}

	public int courseDelete(int cid) {
		try {
			getSession().delete(courseDao.courseDelete(cid));
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	public List courseTea() {
		String hql = "from Teacher";
		Query query = getSession().createQuery(hql);
		List list = query.list();
		return list;
	}

	public int courseadd(Course course) {
		getSession().save(course);
		return 1;
	}

	public List coursefindid(int cid) {
		Course course = courseDao.coursefindid(cid);
		List list = new ArrayList();
		if (course != null) {
			list.add(course);
			return list;
		} else {
			return list;
		}
	}

	public List coursefindtype( String text) {
		List list = new ArrayList();
		if ("øº ‘".equals(text)) {
			List list2 = courseDao.coursefindProperty(2);
			return list2;
		} else if ("øº≤È".equals(text)) {
			List list1 = courseDao.coursefindProperty(1);
			return list1;
		} else {
			return list;
		}
	}
	public List updateTea(int cid) {
		Course course=courseDao.courseDelete(cid);
		getSession1().put("course", course);
		String hql = "from Teacher";
		Query query = getSession().createQuery(hql);
		List list = query.list();
		return list;
	}
	public int courseupdate(int cid, int tid, String cname, String classname,
			int credit, int hour, int type, String addr, int proper) {
		String hql = "update Course set tid=" + tid + ",cname='" + cname
				+ "',classTime='" + classname + "',credit=" + credit
				+ ",classHour=" + hour + ",classType=" + type + ",classAddr='"
				+ addr + "',classProperty=" + proper + " where cid=?";
		Query query = getSession().createQuery(hql);
		query.setInteger(0, cid);
		int x = query.executeUpdate();
		return x;
	}

}
