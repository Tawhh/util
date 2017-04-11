package dao;

import java.util.List;

import model.Role;
import model.User;

public interface UserDao {
	public User userLogin(String username);
	public int userRegister(User user);
	public List userAll(int begin,int pagesize);
	public int querySize();
	public int pwdupdate(String username,String pwd);
	public int userupdate(int uid,int rid,String username,String password);
	public int noadminupdate(int uid,String username,String password);

}
