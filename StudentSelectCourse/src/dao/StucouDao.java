package dao;

import java.util.List;

import model.StuCou;

public interface StucouDao {
	public int querySize();

	public List stu(int begin, int pagesize);
	public int stude(int id);
	public List stuCou(int cid,int sid);
	public StuCou deleteone(int id);

}
