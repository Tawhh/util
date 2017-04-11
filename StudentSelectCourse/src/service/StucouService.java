package service;

import java.util.List;

import model.StuCou;

public interface StucouService {
//	public List stucouall();
	public List Stu(int begin,int pageSize);
	public int querySize();
	public int stucoude(int id);
	public List stucouall(int id);
	public List stucou();
    public int stuCou(int cid,int sid,StuCou stu);
    public List stucouone(int sid);
    public int deleteone(int id);
}
