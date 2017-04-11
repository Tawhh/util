package service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import model.Student;
import model.Teacher;

import org.hibernate.Query;
import org.springframework.stereotype.Service;

import dao.StuDao;
import database.DataBase;
import service.StuService;

@Service("stuService")
public class StuServiceImpl extends DataBase implements StuService {
	private StuDao stuDao;

	public StuDao getStuDao() {
		return stuDao;
	}

	@Resource
	public void setStuDao(StuDao stuDao) {
		this.stuDao = stuDao;
	}

	public int querySize() {

		return stuDao.querySize();
	}

	public List stuAll(int begin, int pageSize) {

		return stuDao.stuAll(begin, pageSize);
	}

	public List findOne(int sid) {
		Student stu = stuDao.findone(sid);
		List list = new ArrayList();
		if (stu != null) {
			list.add(stu);
			return list;
		} else {
			return list;
		}
	}

	public int delete(int sid) {
		Student stu = stuDao.findone(sid);
		getSession().delete(stu);
		return 1;
	}

	public int stuadd(Student student) {
		Student stu = stuDao.findone(student.getSid());
		if (stu == null) {
			getSession().save(student);
			return 1;
		} else {
			return 0;
		}
	}
	
	public Student find(int sid) {
		Student stu=stuDao.findone(sid);
		
		return stu;
	}
	@Override
	public int stupdate(int sid, String sname, int sex, String sc,
			String majoer, int hour, int credit) {
		
		return stuDao.stupdate(sid, sname, sex, sc, majoer, hour, credit);
	}
}
