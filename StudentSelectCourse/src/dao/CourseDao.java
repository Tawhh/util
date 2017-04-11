package dao;

import java.util.List;

import model.Course;

public interface CourseDao {
	public int querySize();

	public List Course(int begin, int pagesize);

	public Course courseDelete(int cid);

	public Course coursefindid(int cid);

	public List coursefindProperty(int type);

	
}
