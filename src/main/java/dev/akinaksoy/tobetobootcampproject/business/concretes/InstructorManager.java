package dev.akinaksoy.tobetobootcampproject.business.concretes;

import dev.akinaksoy.tobetobootcampproject.business.abstracts.InstructorService;
import dev.akinaksoy.tobetobootcampproject.business.request.create.CreateInstructorRequest;
import dev.akinaksoy.tobetobootcampproject.business.response.create.CreateInstructorResponse;
import dev.akinaksoy.tobetobootcampproject.core.utilities.modelmapper.ModelMapperService;
import dev.akinaksoy.tobetobootcampproject.core.utilities.results.DataResult;
import dev.akinaksoy.tobetobootcampproject.core.utilities.results.SuccessDataResult;
import dev.akinaksoy.tobetobootcampproject.dataaaccess.InstructorRepository;
import dev.akinaksoy.tobetobootcampproject.entities.Instructor;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class InstructorManager implements InstructorService {
    private InstructorRepository instructorRepository;
    private ModelMapperService mapperService;
    @Override
    public DataResult<CreateInstructorResponse> createInstructor(
            CreateInstructorRequest request
    ){
        Instructor instructor = mapperService.forRequest()
                .map(request,Instructor.class);

        instructor.setCreatedDate(LocalDateTime.now());

        instructorRepository.save(instructor);

        CreateInstructorResponse response = mapperService.forResponse()
                .map(instructor, CreateInstructorResponse.class);

        return new SuccessDataResult
                <CreateInstructorResponse>
                (response,"Instructor created successfully.");
    }
}
