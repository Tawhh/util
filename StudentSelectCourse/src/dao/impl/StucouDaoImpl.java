package dao.impl;

import java.util.ArrayList;
import java.util.List;

import model.Stu;
import model.StuCou;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import dao.StucouDao;
import database.DataBase;

@Component("stucouDao")
public class StucouDaoImpl extends DataBase implements StucouDao {
	private Object[] object;

	public int querySize() {
		String hql = "select DISTINCT c.cid,c.cname,t.tname,c.class_time,c.credit,COUNT(s.sid) from course c join teacher t on c.tid=t.tid left join stu_cou s on s.cid=c.cid left join student stu on s.sid=stu.sid GROUP BY c.cid";
		Query query = getSession().createSQLQuery(hql);
		List list = query.list();
		return list.size();
	}

	public List stu(int begin, int pagesize) {
		String hql = "select DISTINCT c.cid,c.cname,t.tname,c.class_time,c.credit,COUNT(s.sid) from course c join teacher t on c.tid=t.tid left join stu_cou s on s.cid=c.cid left join student stu on s.sid=stu.sid GROUP BY c.cid";
		Query query = getSession().createSQLQuery(hql);
		query.setFirstResult(begin);
		query.setMaxResults(pagesize);
		List list = query.list();
		List list1 = new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			Stu stu = new Stu();
			object = (Object[]) list.get(i);
			int id = Integer.parseInt(object[0].toString());
			String name = (String) object[1];
			String tname = (String) object[2];
			String time = (String) object[3];
			int credit = Integer.parseInt(object[4].toString());
			int sum = Integer.parseInt(object[5].toString());
			stu.setId(id);
			stu.setName(name);
			stu.setTname(tname);
			stu.setTime(time);
			stu.setCredit(credit);
			stu.setSum(sum);
			list1.add(stu);
			System.out.println("aaaaaaaa" + name);
		}
		return list1;

	}

	public int stude(int id) {
		
			String hql = "delete from StuCou where cid=?";
			Query query = getSession().createQuery(hql);
			query.setInteger(0, id);
			query.executeUpdate();
			return 1;
	}
	public List stuCou(int cid, int sid) {
		String hql="from StuCou where cid=? and sid="+sid;
		Query query=getSession().createQuery(hql);
		query.setInteger(0, cid);
		
		return query.list();
	}
	public StuCou deleteone(int id) {
		String hql="from StuCou where id=?";
		Query query=getSession().createQuery(hql);
		query.setInteger(0,id);
		query.uniqueResult();
		return (StuCou) query.uniqueResult();
	}

}
