package service;

import java.util.List;

import model.Teacher;

public interface TeaService {
	public int querySize();
	public List teaAll(int begin,int pageSize);
	public int teaAdd(Teacher teacher);
	public int delete(int tid);
	public List teaone(int tid);
	public int teaUpdate(int tid,String tname,String sex,String sc,String major);

}
