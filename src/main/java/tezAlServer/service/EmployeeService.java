package tezAlServer.service;

import org.springframework.stereotype.Service;
import tezAlServer.domain.Employee;

import java.util.List;
import java.util.Optional;

@Service
public interface EmployeeService {
    List<Employee> findAll();

    Optional<Employee> findById(Long id);

    Employee save(Employee employee);

    void deleteById(Long id);
}
