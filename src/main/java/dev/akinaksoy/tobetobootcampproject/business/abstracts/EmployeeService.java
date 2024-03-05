package dev.akinaksoy.tobetobootcampproject.business.abstracts;

import dev.akinaksoy.tobetobootcampproject.business.request.create.CreateBootcampRequest;
import dev.akinaksoy.tobetobootcampproject.business.request.create.CreateEmployeeCreateRequest;
import dev.akinaksoy.tobetobootcampproject.business.response.create.CreateEmployeeResponse;

public interface EmployeeService {
    CreateEmployeeResponse createEmployee(
            CreateEmployeeCreateRequest request
    );
}
