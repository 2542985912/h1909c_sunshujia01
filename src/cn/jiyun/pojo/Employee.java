package cn.jiyun.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Employee {
	private Integer eid;
	private String ename;
	private String hobby;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthday;
	private Integer deid;
	private String dname;
	@Override
	public String toString() {
		return "employee [eid=" + eid + ", ename=" + ename + ", hobby=" + hobby + ", birthday=" + birthday + ", deid="
				+ deid + ", dname=" + dname + "]";
	}
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Integer getDeid() {
		return deid;
	}
	public void setDeid(Integer deid) {
		this.deid = deid;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	
	
}
