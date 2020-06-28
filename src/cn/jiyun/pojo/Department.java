package cn.jiyun.pojo;

public class Department {
	private Integer deid;
	private String dname;
	@Override
	public String toString() {
		return "Department [deid=" + deid + ", dname=" + dname + "]";
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
