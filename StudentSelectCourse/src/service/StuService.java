package service;

import java.util.List;

import model.Student;

public interface StuService {
	public int querySize();
	public List stuAll(int begin,int pageSize);
	public List findOne(int sid);
	public int delete(int sid);
	public int stuadd(Student student);
	public Student find(int sid);
	public int stupdate(int sid,String sname,int sex,String sc,String majoer,int hour,int credit);
}
