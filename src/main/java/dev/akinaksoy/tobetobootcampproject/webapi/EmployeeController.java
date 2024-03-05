package dev.akinaksoy.tobetobootcampproject.webapi;

import dev.akinaksoy.tobetobootcampproject.business.abstracts.EmployeeService;
import dev.akinaksoy.tobetobootcampproject.business.request.create.CreateEmployeeCreateRequest;
import dev.akinaksoy.tobetobootcampproject.business.response.create.CreateEmployeeResponse;
import dev.akinaksoy.tobetobootcampproject.entities.Employee;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController extends BaseController {
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<?> createEmployee(
            @RequestBody @Valid CreateEmployeeCreateRequest request)
    {
        return handleDataResult(employeeService.createEmployee(request));
    }
}
