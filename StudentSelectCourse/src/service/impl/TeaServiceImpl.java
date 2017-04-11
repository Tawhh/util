package service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import model.Teacher;

import org.springframework.stereotype.Service;

import dao.TeaDao;
import database.DataBase;
import service.TeaService;

@Service("teaService")
public class TeaServiceImpl extends DataBase implements TeaService {
	private TeaDao teaDao;

	public TeaDao getTeaDao() {
		return teaDao;
	}

	@Resource
	public void setTeaDao(TeaDao teaDao) {
		this.teaDao = teaDao;
	}

	public int querySize() {

		return teaDao.querySize();
	}

	public List teaAll(int begin, int pageSize) {

		return teaDao.teaAll(begin, pageSize);
	}

	public int teaAdd(Teacher teacher) {
		getSession().save(teacher);
		return 1;
	}

	public int delete(int tid) {
		Teacher tea = teaDao.findde(tid);
		getSession().delete(tea);
		return 1;
	}

	public List teaone(int tid) {
		Teacher tea = teaDao.findde(tid);
		List list = new ArrayList();
		if (tea == null) {
			return list;
		} else {
			list.add(tea);
			return list;
		}
	}

	public int teaUpdate(int tid, String tname, String sex, String sc, String major) {
		int x = teaDao.teaUpdate(tid, tname, sex, sc, major);
		if (x == 1) {
			return 1;
		}
		return 0;
	}

}
