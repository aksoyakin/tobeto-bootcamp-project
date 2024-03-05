package dev.akinaksoy.tobetobootcampproject.business.abstracts;

import dev.akinaksoy.tobetobootcampproject.business.request.create.CreateInstructorRequest;
import dev.akinaksoy.tobetobootcampproject.business.response.create.CreateInstructorResponse;

public interface InstructorService {
    CreateInstructorResponse createInstructor(
            CreateInstructorRequest request
    );
}
