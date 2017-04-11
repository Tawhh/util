package dao;

import java.util.List;

import model.Teacher;

public interface TeaDao {
	public int querySize();
	public List teaAll(int begin,int pageSize);
	public Teacher findde(int tid);
    public int teaUpdate(int tid,String tname,String sex,String sc,String major);
}
