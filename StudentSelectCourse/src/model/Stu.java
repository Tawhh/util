package model;

public class Stu {
	private int  id;
	private String name;
	private String tname;
	private String time;
	private int credit;
	private int sum;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public Stu(){}
	public Stu(int id, String name, String tname, String time, int credit,
			int sum) {
		super();
		this.id = id;
		this.name = name;
		this.tname = tname;
		this.time = time;
		this.credit = credit;
		this.sum = sum;
	}
	

}
