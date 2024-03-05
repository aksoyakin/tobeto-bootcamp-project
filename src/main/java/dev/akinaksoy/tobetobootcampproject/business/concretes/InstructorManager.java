package dev.akinaksoy.tobetobootcampproject.business.concretes;

import dev.akinaksoy.tobetobootcampproject.business.abstracts.InstructorService;
import dev.akinaksoy.tobetobootcampproject.business.request.create.CreateInstructorRequest;
import dev.akinaksoy.tobetobootcampproject.business.response.create.CreateInstructorResponse;
import dev.akinaksoy.tobetobootcampproject.core.utilities.modelmapper.ModelMapperService;
import dev.akinaksoy.tobetobootcampproject.dataaaccess.InstructorRepository;
import dev.akinaksoy.tobetobootcampproject.entities.Instructor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class InstructorManager implements InstructorService {
    private InstructorRepository instructorRepository;
    private ModelMapperService mapperService;
    @Override
    public CreateInstructorResponse createInstructor(
            CreateInstructorRequest request
    ){
        Instructor instructor = mapperService.forRequest()
                .map(request,Instructor.class);

        instructor.setCreatedDate(LocalDateTime.now());

        instructorRepository.save(instructor);

        return mapperService.forResponse()
                .map(instructor, CreateInstructorResponse.class);
    }
}
