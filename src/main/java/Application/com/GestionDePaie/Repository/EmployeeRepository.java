package Application.com.GestionDePaie.Repository;

import Application.com.GestionDePaie.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findByName(String name);


}
