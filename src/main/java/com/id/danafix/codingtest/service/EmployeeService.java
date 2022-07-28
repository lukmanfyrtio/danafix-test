package com.id.danafix.codingtest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.id.danafix.codingtest.model.CrudObject;
import com.id.danafix.codingtest.model.Employee;
import com.id.danafix.codingtest.model.ResponseModel;
import com.id.danafix.codingtest.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private KafkaTemplate<String, CrudObject> kafkaTemplate;
	
	public ResponseModel<Employee>addEmployee(Employee employee){
		ResponseModel<Employee>model=new ResponseModel<>();
		Employee getData = employeeRepository.findByEmail1(employee.getEmail());
		
		if(getData!=null) {
			model.setMessage("Email sudah terdaftar");
			return model;
		}
		
		CrudObject crudObj=new CrudObject();
		crudObj.setData(employee);
		crudObj.setAction("CREATE");
		kafkaTemplate.send("crud_topics", crudObj);
		model.setData(employee);
		return model;
	}
	public ResponseModel<Employee>editEmployee(Employee employee,Integer id){
		ResponseModel<Employee>model=new ResponseModel<>();
		Optional<Employee> getData = employeeRepository.findById(Long.valueOf(id));
		
		if(getData.isPresent()) {
			model.setMessage("Data not found");
			return model;
		}
		CrudObject crudObj=new CrudObject();
		crudObj.setAction("UPDATE");
		employee.setId(getData.get().getId());
		crudObj.setData(employee);
		kafkaTemplate.send("crud_topics", crudObj);
		model.setData(employee);
		return model;
	}
	public ResponseModel<Employee>removeEmployee(Integer id){
		Optional<Employee> getData = employeeRepository.findById(Long.valueOf(id));
		ResponseModel<Employee>model=new ResponseModel<>();
		if(getData.isPresent()) {
			model.setMessage("Data not found");
			return model;
		}
		
		CrudObject crudObj=new CrudObject();
		crudObj.setAction("DELETE");
		crudObj.setData(getData.get());
		kafkaTemplate.send("crud_topics", crudObj);
		model.setData(getData.get());
		return model;
	}
	public ResponseModel<Employee>getEmployee(){
		ResponseModel<Employee>model=new ResponseModel<>();
		model.setData(employeeRepository.findAll());
		return model;
	}
	

}
