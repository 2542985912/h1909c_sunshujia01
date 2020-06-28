package cn.jiyun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.jiyun.mapper.EmpMapper;
import cn.jiyun.pojo.Department;
import cn.jiyun.pojo.Employee;

@Service
@Transactional
public class EmpServiceimpl implements EmpService {
	@Autowired
	private EmpMapper empMapper;

	@Override
	public List<Employee> findAll(Employee employee) {
		// TODO Auto-generated method stub
		return empMapper.findAll(employee);
	}

	@Override
	public List<Department> findDept() {
		// TODO Auto-generated method stub
		return empMapper.findDept();
	}

	@Override
	public Employee findByName(String ename) {
		// TODO Auto-generated method stub
		return empMapper.findByName(ename);
	}

	@Override
	public void add(Employee employee) {
		// TODO Auto-generated method stub
		empMapper.add(employee);
	}

	@Override
	public void deleteById(Employee employee) {
		// TODO Auto-generated method stub
		empMapper.deleteById(employee);
	}

	@Override
	public Employee findById(Employee employee) {
		// TODO Auto-generated method stub
		return empMapper.findById(employee);
	}

	@Override
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		empMapper.update(employee);
	}
}
