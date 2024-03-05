package dev.akinaksoy.tobetobootcampproject.business.abstracts;

import dev.akinaksoy.tobetobootcampproject.business.request.create.CreateBootcampRequest;
import dev.akinaksoy.tobetobootcampproject.business.request.create.CreateEmployeeCreateRequest;
import dev.akinaksoy.tobetobootcampproject.business.response.create.CreateEmployeeResponse;
import dev.akinaksoy.tobetobootcampproject.core.utilities.results.DataResult;

public interface EmployeeService {
    DataResult<CreateEmployeeResponse> createEmployee(
            CreateEmployeeCreateRequest request
    );
}
