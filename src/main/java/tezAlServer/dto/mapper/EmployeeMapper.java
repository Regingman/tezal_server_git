package tezAlServer.dto.mapper;

import org.mapstruct.Mapper;
import tezAlServer.domain.Employee;
import tezAlServer.dto.model.EmployeeDto;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    EmployeeDto toEmployeeDto(Employee employee);

    List<EmployeeDto> toEmployeeDtos(List<Employee> employees);

    Employee toEmployee(EmployeeDto employeeDto);
}
