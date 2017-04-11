package service;

import java.util.List;

import model.Course;

public interface CourseService {
	public int courseAll();
	public List courseall(int begin,int pageSize);
	public int courseDelete(int cid);
	public List courseTea();
	public int courseadd(Course course);
	public List coursefindid(int cid);
	public List coursefindtype(String text);
	public List updateTea(int cid);
	public int courseupdate(int cid, int tid, String cname, String classname,
			int credit, int hour, int type, String addr, int proper);
}
