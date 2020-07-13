package tezAlServer.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tezAlServer.domain.Employee;
import tezAlServer.dto.mapper.EmployeeMapper;
import tezAlServer.dto.model.EmployeeDto;
import tezAlServer.service.EmployeeService;

import java.util.List;
import java.util.Optional;

@Api(description = "Операции по взаимодействию с сотрудниками контейнера")
@RestController
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeMapper employeeMapper;

    @ApiOperation(value = "Получения списка всех сотрудников контейнера")
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> List(){
        return ResponseEntity.ok(employeeMapper.toEmployeeDtos(employeeService.findAll()));
    }

    @ApiOperation(value = "Получение информации о clients")
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> findById(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.findById(id);
        return (employee.isPresent()) ?
                ResponseEntity.ok(employeeMapper.toEmployeeDto(employee.get())) :
                ResponseEntity.notFound().build();
    }

    @ApiOperation(value = "Создание сотрудника контейнера")
    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody EmployeeDto  employeeDto){
        Employee employee = employeeMapper.toEmployee(employeeDto);
        employeeService.save(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }

    @ApiOperation(value = "Обновление сотрудника контейнера")
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> update(@PathVariable("id") Long id,
            @RequestBody EmployeeDto employeeDto) {
        Employee employee = employeeMapper.toEmployee(employeeDto);
        employee.setId(id);
        employeeService.save(employee);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(employeeDto);
    }

    @ApiOperation(value = "Удаление сотрудника контейнера")
    @DeleteMapping("{id}")
    public  ResponseEntity<Employee> delete(@PathVariable("id") Long id){
        employeeService.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
