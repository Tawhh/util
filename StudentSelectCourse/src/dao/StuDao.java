package dao;

import java.util.List;

import model.Student;

public interface StuDao {
	public int querySize();
	public List stuAll(int begin,int pageSize);
	public Student findone(int sid);
	public int stupdate(int sid,String sname,int sex,String sc,String majoer,int hour,int credit);

}
