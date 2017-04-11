package service.impl;

import java.util.List;

import javax.annotation.Resource;

import model.Stu;
import model.StuCou;

import org.hibernate.Query;
import org.springframework.stereotype.Service;

import service.StucouService;

import dao.impl.StucouDaoImpl;
import database.DataBase;

@Service("stucouService")
public class stucouServiceImpl extends DataBase implements StucouService {
	private StucouDaoImpl stucouDao;
	private Object[] object;

	public StucouDaoImpl getStucouDao() {
		return stucouDao;
	}

	@Resource
	public void setStucouDao(StucouDaoImpl stucouDao) {
		this.stucouDao = stucouDao;
	}

	public int querySize() {

		return stucouDao.querySize();
	}

	public List Stu(int begin, int pageSize) {
		return stucouDao.stu(begin, pageSize);
	}

	public int stucoude(int id) {

		return stucouDao.stude(id);
	}

	public List stucouall(int id) {
		String hql = "from StuCou where cid=?";
		Query query = getSession().createQuery(hql);
		query.setInteger(0, id);
		query.list();
		return query.list();
	}

	public List stucou() {
		String hql = "from Course";
		Query query = getSession().createQuery(hql);
		query.list();
		return query.list();
	}

	public int stuCou(int cid, int sid,StuCou stu) {
		List stucou = stucouDao.stuCou(cid, sid);
		if (stucou.size()>0) {
			return 0;
		} else {
			 getSession().save(stu);
				return 1;
			
		}
	}
	public List stucouone( int sid) {
		String hql="from StuCou where sid=?";
		Query query=getSession().createQuery(hql);
		query.setInteger(0,sid);
		query.list();
		return query.list();
	}
	public int deleteone(int id) {
		StuCou stu=stucouDao.deleteone(id);
		getSession().delete(stu);
		return 1;
	}
}
