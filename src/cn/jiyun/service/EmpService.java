package cn.jiyun.service;

import java.util.List;

import cn.jiyun.pojo.Department;
import cn.jiyun.pojo.Employee;

public interface EmpService {

	List<Employee> findAll(Employee employee);

	List<Department> findDept();

	Employee findByName(String ename);

	void add(Employee employee);

	void deleteById(Employee employee);

	Employee findById(Employee employee);

	void update(Employee employee);

}
