package cn.jiyun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.jiyun.pojo.Department;
import cn.jiyun.pojo.Employee;
import cn.jiyun.service.EmpService;

@Controller
public class EmpController {
	@Autowired
	private EmpService empService;
	
	@RequestMapping("update")
	public String update(Employee employee){
		empService.update(employee);
		return "redirect:findAll.action";
	}
	
	@RequestMapping("findById")
	public String findById(Model model,Employee employee){
		Employee e=empService.findById(employee);
		model.addAttribute("e", e);
		List<Department> dlist=empService.findDept();
		model.addAttribute("dlist", dlist);
		return "update";
	}
	
	@RequestMapping("deleteById")
	public String deleteById(Employee employee){
		empService.deleteById(employee);
		return "redirect:findAll.action";
	}
	@RequestMapping("add")
	public String add(Employee employee){
		empService.add(employee);
		return "redirect:findAll.action";
	}
	
	@RequestMapping("findByName")
	public @ResponseBody String findByName(String ename){
		Employee emp=empService.findByName(ename);
		if (emp!=null) {
			return "1";
		}
		return"0";
	}
	
	@RequestMapping("toadd")
	public String toadd(Model model){
		List<Department> dlist=empService.findDept();
		model.addAttribute("dlist", dlist);
		return "add";
	}
	
	@RequestMapping("findAll")
	public String findAll(Model model,Employee employee,@RequestParam(required=true,defaultValue="1")Integer pageNum){
		PageHelper.startPage(pageNum, 2);
		List<Employee> list=empService.findAll(employee);
		PageInfo<Employee> page=new PageInfo<>(list);
		model.addAttribute("page", page);
		return "elist";
	}
}
