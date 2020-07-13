package tezAlServer.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tezAlServer.domain.Container;
import tezAlServer.domain.Employee;
import tezAlServer.repo.ContainersRepo;
import tezAlServer.repo.EmployeesRepo;
import tezAlServer.service.EmployeeService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeesRepo employeesRepo;
    @Autowired
    ContainersRepo containersRepo;

    @Override
    public List<Employee> findAll() {
        return employeesRepo.findAll();
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return employeesRepo.findById(id);
    }

    @Override
    public Employee save(Employee employee) {
        Container container = containersRepo.findById(employee.getContainerId()).orElse(null);
        employee.setContainer(container);
        employee.setCreateDate(LocalDateTime.now());
        employee.setUpdateDate(LocalDateTime.now());
        return employeesRepo.save(employee);
    }

    @Override
    public void deleteById(Long id) {
        employeesRepo.deleteById(id);
    }
}
