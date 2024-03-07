package dev.akinaksoy.tobetobootcampproject.business.abstracts;

import dev.akinaksoy.tobetobootcampproject.business.request.create.CreateBootcampRequest;
import dev.akinaksoy.tobetobootcampproject.business.request.create.CreateEmployeeCreateRequest;
import dev.akinaksoy.tobetobootcampproject.business.request.update.UpdateEmployeeRequest;
import dev.akinaksoy.tobetobootcampproject.business.response.create.CreateEmployeeResponse;
import dev.akinaksoy.tobetobootcampproject.business.response.get.GetAllEmployeeResponse;
import dev.akinaksoy.tobetobootcampproject.business.response.get.GetEmployeeByIdResponse;
import dev.akinaksoy.tobetobootcampproject.business.response.get.GetEmployeeByPositionResponse;
import dev.akinaksoy.tobetobootcampproject.business.response.update.UpdateEmployeeResponse;
import dev.akinaksoy.tobetobootcampproject.core.utilities.paging.PageDto;
import dev.akinaksoy.tobetobootcampproject.core.utilities.results.DataResult;
import dev.akinaksoy.tobetobootcampproject.core.utilities.results.Result;

import java.util.List;

public interface EmployeeService {
    DataResult<CreateEmployeeResponse> createEmployee(
            CreateEmployeeCreateRequest request
    );

    DataResult<List<GetAllEmployeeResponse>> getAllEmployee(

    );

    DataResult<GetEmployeeByIdResponse> getEmployeeById(
            int id
    );

    DataResult<UpdateEmployeeResponse> updateEmployee(
            UpdateEmployeeRequest request,
            int id
    );

    DataResult<List<GetEmployeeByPositionResponse>> getEmployeeByPosition(
            String position
    );

    DataResult<List<GetAllEmployeeResponse>> getAllSorted(
            PageDto pageDto
    );

    Result deleteEmployeeById(
            int id
    );
}
