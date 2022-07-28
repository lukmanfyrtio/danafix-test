package com.id.danafix.codingtest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.id.danafix.codingtest.model.CrudObject;
import com.id.danafix.codingtest.repository.EmployeeRepository;

@Component
public class KafkaListener {

	@Autowired
	private EmployeeRepository employeeRepository;

	@org.springframework.kafka.annotation.KafkaListener(topics = "crud_topics", containerFactory = "kafkaListenerContainerFactory")
	public void crudListener(CrudObject crudObj) {

		System.out.println(String.format(
				"Received Message : " + "\n ACTION : %s " + "\n EMPLOYEE" + "\n NAMA : %s %s" + "\n EMAIL : %s "
						+ "\n NO TLP : %s ",
				crudObj.getAction(), crudObj.getData().getFirstName(), crudObj.getData().getLastName(),
				crudObj.getData().getEmail(), crudObj.getData().getNoTelepon()));
		if (crudObj.getAction().equals("CREATE")) {
			employeeRepository.save(crudObj.getData());
		} else if (crudObj.getAction().equals("UPDATE")) {
			employeeRepository.save(crudObj.getData());
		} else if (crudObj.getAction().equals("DELETE")) {
			employeeRepository.deleteById(crudObj.getData().getId());
		}
	}
}
