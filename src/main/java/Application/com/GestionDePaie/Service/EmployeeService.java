package Application.com.GestionDePaie.Service;

import Application.com.GestionDePaie.Model.Employee;
import Application.com.GestionDePaie.Repository.CivilRepository;
import Application.com.GestionDePaie.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service

public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private CivilRepository civilRepository;

    public Employee addEmployee(Employee employee) {
        employee.setCivil(civilRepository.getById(employee.getCivilId()));
        return employeeRepository.save(employee);
    }

    public List<Employee> addAllEmployees(List<Employee> employees) {
        return  employeeRepository.saveAll(employees);
    }

    public Employee getEmployeeByID(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee getEmployeeByName(String name) {
        return  employeeRepository.findByName(name);
    }

    public Employee updateEmployee(Employee employee) {
        Employee existingEMP = employeeRepository.findById(employee.getId()).orElse(null);
        System.out.println(employee);
        if(existingEMP == null) {
            System.out.println("Emp not found");
            return  employeeRepository.save(employee);
        }else  {
            existingEMP.setEmail(employee.getEmail());
            existingEMP.setMatricule(employee.getMatricule());
            existingEMP.setNumeroCNI(employee.getNumeroCNI());
            existingEMP.setCivil(civilRepository.getById(employee.getCivilId()));


            employeeRepository.save(existingEMP);
        }
        return employee;
    }

    public boolean deleteEmployeeByID(int id) {
        Employee existingEMP = employeeRepository.getById(id);
        if(existingEMP != null) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}