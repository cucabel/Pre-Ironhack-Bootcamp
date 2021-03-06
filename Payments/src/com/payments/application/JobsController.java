package com.payments.application;

import java.util.List;

import com.jpayments.persistence.EmployeeRepository;
import com.payments.domain.AbsStaffMember;
import com.payments.domain.Employee;
import com.payments.domain.Volunteer;

public class JobsController {
	
	private EmployeeRepository employeeRepository;
	
	public JobsController() {								
		employeeRepository = new EmployeeRepository();
	}
	
	public void createManagerEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception {
		Employee manager = new Employee(name, address, phone, salaryPerMonth, PaymentFactory.createPaymentRateManager());
		employeeRepository.addMember(manager);	
	}
	
	public void createBossEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception {		
		Employee boss = new Employee(name, address, phone, salaryPerMonth, PaymentFactory.createPaymentRateBoss());
		employeeRepository.addMember(boss);
	}	
	
	public void createEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception {		
		Employee employee = new Employee(name, address, phone, salaryPerMonth, PaymentFactory.createPaymentRateEmployee());
		employeeRepository.addMember(employee);
	}

	public void payAllEmployeers() {		
		for(AbsStaffMember member : employeeRepository.getAllMembers()) {
			member.pay();
		}	
	}

	public String getAllEmployeers() {		
		List<AbsStaffMember> absStaffMemberList = employeeRepository.getAllMembers();
		
		return absStaffMemberList.toString();
	}
	
	public void createVolunteer(String name, String address, String phone, String description) throws Exception {
		Volunteer volunteer = new Volunteer(name, address, phone, description);
		employeeRepository.addMember(volunteer);
	}

}
