package dev.akinaksoy.tobetobootcampproject.business.abstracts;

import dev.akinaksoy.tobetobootcampproject.business.request.create.CreateInstructorRequest;
import dev.akinaksoy.tobetobootcampproject.business.request.update.UpdateInstructorRequest;
import dev.akinaksoy.tobetobootcampproject.business.response.create.CreateInstructorResponse;
import dev.akinaksoy.tobetobootcampproject.business.response.get.GetAllInstructorResponse;
import dev.akinaksoy.tobetobootcampproject.business.response.get.GetInstructorByIdResponse;
import dev.akinaksoy.tobetobootcampproject.business.response.update.UpdateInstructorResponse;
import dev.akinaksoy.tobetobootcampproject.core.utilities.paging.PageDto;
import dev.akinaksoy.tobetobootcampproject.core.utilities.results.DataResult;
import dev.akinaksoy.tobetobootcampproject.core.utilities.results.Result;

import java.util.List;

public interface InstructorService {
     DataResult<CreateInstructorResponse> createInstructor(
            CreateInstructorRequest request
    );

    DataResult<List<GetAllInstructorResponse>> getAllInstructor(

    );

    DataResult<GetInstructorByIdResponse> getInstructor(
            int id
    );

    DataResult<UpdateInstructorResponse> updateInstructorById(
            UpdateInstructorRequest request,
            int id
    );

    DataResult<List<GetAllInstructorResponse>> getAllSorted(
            PageDto pageDto
    );

    Result deleteInstructorById(
            int id
    );
}
