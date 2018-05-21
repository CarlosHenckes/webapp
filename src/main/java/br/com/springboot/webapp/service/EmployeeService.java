package br.com.springboot.webapp.service;

import br.com.springboot.webapp.model.Employee;
import br.com.springboot.webapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> employees(){
        return employeeRepository.findAll();
    }

    public boolean save(Employee employee){
        try {
            employeeRepository.save(employee);
            return true;
        } catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public Optional<Employee> employee(String id){
        return employeeRepository.findById(id);
    }
}