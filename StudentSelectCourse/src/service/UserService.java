package service;

import java.util.List;

import model.Role;
import model.User;

public interface UserService {
	public int userLogin(User user);

	public User userFind(String username);

	public int userRegister(User user);

	public int usersAll();

	public List userssAll(int begin, int page);

	public int pwdupdate(String username, String password, String password1,
			String password2, String password3);

	public int userDelete(String username);

	public int userupdate(int uid, int rid, String username, String password,
			String password1, String password2, String password3);
    public List findid(int uid);
    public List findname(String username);
    public List findrole(String rname);
    public int noadmin(int uid, String username, String password,
			String password1, String password2, String password3);
}
