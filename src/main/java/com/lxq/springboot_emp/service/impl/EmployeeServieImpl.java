package com.lxq.springboot_emp.service.impl;


import com.lxq.springboot_emp.dao.EmployeeDao;
import com.lxq.springboot_emp.entity.Employee;
import com.lxq.springboot_emp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
//@Transactional
public class EmployeeServieImpl implements EmployeeService {

	// 数据访问层对象
	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public void addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		// 添加前，先判断是否有同名的员工，如果有，不能添加
		Employee employee = employeeDao.findByName(emp.getName());
		if(employee != null){
			throw new RuntimeException("存在同名员工，不能添加");
		}
		// 添加数据
		employeeDao.add(emp);
	}

	@Override
	public List<Employee> findAllEemployee() {
		// TODO Auto-generated method stub
		List<Employee> list = null;
		try {
			list = employeeDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new RuntimeException("查询所用用户数据异常");
		}
		return list;
	}

	@Override
	public void deleteEmpById(Integer id) {
		// TODO Auto-generated method stub
		
		// 判断删除的数据是否存在
		
		// 删除
		employeeDao.deleteById(id);
		
	}

	@Override
	public Employee findEmpById(Integer id) {
		// TODO Auto-generated method stub
		return employeeDao.findById(id);
	}

	@Override
	public void updateEmp(Employee emp) {
		// TODO Auto-generated method stub
		
		// 判断是否是否存在
		
		// 更新
		employeeDao.update(emp);
		
	}

}
