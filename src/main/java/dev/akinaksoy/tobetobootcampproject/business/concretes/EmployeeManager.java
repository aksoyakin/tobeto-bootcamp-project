package dev.akinaksoy.tobetobootcampproject.business.concretes;

import dev.akinaksoy.tobetobootcampproject.business.abstracts.EmployeeService;
import dev.akinaksoy.tobetobootcampproject.business.request.create.CreateBootcampRequest;
import dev.akinaksoy.tobetobootcampproject.business.request.create.CreateEmployeeCreateRequest;
import dev.akinaksoy.tobetobootcampproject.business.response.create.CreateEmployeeResponse;
import dev.akinaksoy.tobetobootcampproject.core.utilities.modelmapper.ModelMapperService;
import dev.akinaksoy.tobetobootcampproject.core.utilities.results.DataResult;
import dev.akinaksoy.tobetobootcampproject.core.utilities.results.SuccessDataResult;
import dev.akinaksoy.tobetobootcampproject.dataaaccess.EmployeeRepository;
import dev.akinaksoy.tobetobootcampproject.entities.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private ModelMapperService mapperService;
    @Override
    public DataResult<CreateEmployeeResponse> createEmployee(
            CreateEmployeeCreateRequest request)
    {
        Employee employee = mapperService.forRequest()
                .map(request,Employee.class);

        employee.setCreatedDate(LocalDateTime.now());

        employeeRepository.save(employee);

        CreateEmployeeResponse response = mapperService.forResponse()
                .map(employee,CreateEmployeeResponse.class);

        return new SuccessDataResult
                <CreateEmployeeResponse>
                (response,"Employee created successfully.");
    }
}
