package dev.akinaksoy.tobetobootcampproject.business.abstracts;

import dev.akinaksoy.tobetobootcampproject.business.request.create.CreateInstructorRequest;
import dev.akinaksoy.tobetobootcampproject.business.response.create.CreateInstructorResponse;
import dev.akinaksoy.tobetobootcampproject.core.utilities.results.DataResult;

public interface InstructorService {
     DataResult<CreateInstructorResponse> createInstructor(
            CreateInstructorRequest request
    );
}
