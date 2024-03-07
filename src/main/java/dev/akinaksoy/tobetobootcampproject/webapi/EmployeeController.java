package dev.akinaksoy.tobetobootcampproject.webapi;

import dev.akinaksoy.tobetobootcampproject.business.abstracts.EmployeeService;
import dev.akinaksoy.tobetobootcampproject.business.request.create.CreateEmployeeCreateRequest;
import dev.akinaksoy.tobetobootcampproject.business.request.update.UpdateEmployeeRequest;
import dev.akinaksoy.tobetobootcampproject.business.response.create.CreateEmployeeResponse;
import dev.akinaksoy.tobetobootcampproject.core.utilities.paging.PageDto;
import dev.akinaksoy.tobetobootcampproject.entities.Employee;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public ResponseEntity<?> getAllEmployee(){
        return handleDataResult(employeeService.getAllEmployee());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(
            @PathVariable int id
    ){
        return handleDataResult(employeeService.getEmployeeById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(
            @RequestBody @Valid UpdateEmployeeRequest request,
            @PathVariable int id
    ){
        return handleDataResult(employeeService.updateEmployee(request, id));
    }

    @GetMapping("/position/{position}")
    public ResponseEntity<?> getEmployeesByPosition(
            @PathVariable String position
    ){
        return handleDataResult(employeeService.getEmployeeByPosition(position));
    }

    @GetMapping("/sort")
    public ResponseEntity<?> getAllEmployee(
            @RequestBody PageDto pageDto
    ){
        return handleDataResult(employeeService.getAllSorted(pageDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(
            @PathVariable int id
    ){
        return handleResult(employeeService.deleteEmployeeById(id));
    }
}
