package tezAlServer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tezAlServer.domain.Employee;

public interface EmployeesRepo extends JpaRepository<Employee, Long> {
}
