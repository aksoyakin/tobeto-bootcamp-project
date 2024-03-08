package dev.akinaksoy.tobetobootcampproject.business.concretes;

import dev.akinaksoy.tobetobootcampproject.business.abstracts.InstructorService;
import dev.akinaksoy.tobetobootcampproject.business.request.create.CreateInstructorRequest;
import dev.akinaksoy.tobetobootcampproject.business.request.update.UpdateInstructorRequest;
import dev.akinaksoy.tobetobootcampproject.business.response.create.CreateInstructorResponse;
import dev.akinaksoy.tobetobootcampproject.business.response.get.GetAllInstructorResponse;
import dev.akinaksoy.tobetobootcampproject.business.response.get.GetInstructorByIdResponse;
import dev.akinaksoy.tobetobootcampproject.business.response.update.UpdateInstructorResponse;
import dev.akinaksoy.tobetobootcampproject.business.rules.UserBusinessRules;
import dev.akinaksoy.tobetobootcampproject.core.aspects.logging.Loggable;
import dev.akinaksoy.tobetobootcampproject.core.utilities.modelmapper.ModelMapperService;
import dev.akinaksoy.tobetobootcampproject.core.utilities.paging.PageDto;
import dev.akinaksoy.tobetobootcampproject.core.utilities.results.DataResult;
import dev.akinaksoy.tobetobootcampproject.core.utilities.results.Result;
import dev.akinaksoy.tobetobootcampproject.core.utilities.results.SuccessDataResult;
import dev.akinaksoy.tobetobootcampproject.core.utilities.results.SuccessResult;
import dev.akinaksoy.tobetobootcampproject.dataaaccess.InstructorRepository;
import dev.akinaksoy.tobetobootcampproject.entities.Instructor;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InstructorManager implements InstructorService {
    private InstructorRepository instructorRepository;
    private ModelMapperService mapperService;
    private UserBusinessRules userBusinessRules;
    @Override
    @Loggable
    public DataResult<CreateInstructorResponse> createInstructor(
            CreateInstructorRequest request
    ){
        userBusinessRules.checkIfEmailExist(request.getEmail());
        userBusinessRules.checkIfUsernameExist(request.getUserName());
        userBusinessRules.checkIfNationalIdentityExist(request.getNationalIdentity());

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

    @Override
    public DataResult<List<GetAllInstructorResponse>> getAllInstructor(

    ) {
        List<Instructor> instructors = instructorRepository.findAll();

        List<GetAllInstructorResponse> response = instructors.stream()
                .map(instructor -> mapperService.forResponse()
                .map(instructor, GetAllInstructorResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult
                <List<GetAllInstructorResponse>>
                (response, "All Instructors Listed");
    }

    @Override
    public DataResult<GetInstructorByIdResponse> getInstructor(
            int id
    ) {
        Instructor instructor = instructorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no instructor with this ID."));

        GetInstructorByIdResponse response = mapperService.forResponse()
                .map(instructor, GetInstructorByIdResponse.class);

        return new SuccessDataResult
                <GetInstructorByIdResponse>
                (response, "Instructor Listed");
    }

    @Override
    public DataResult<UpdateInstructorResponse> updateInstructorById(
            UpdateInstructorRequest request,
            int id
    ) {
        Instructor instructor = instructorRepository.findById(id).orElseThrow();

        Instructor updatedInstructor = mapperService.forRequest()
                .map(request, Instructor.class);

        instructor.setId(id);
        instructor.setUpdatedDate(LocalDateTime.now());
        instructor.setFirstName(updatedInstructor.getFirstName() != null ? updatedInstructor.getFirstName() : instructor.getFirstName());
        instructor.setLastName(updatedInstructor.getLastName() != null ? updatedInstructor.getLastName() : instructor.getLastName());
        instructor.setUserName(updatedInstructor.getUserName() != null ? updatedInstructor.getUserName() : instructor.getUserName());
        instructor.setNationalIdentity(updatedInstructor.getNationalIdentity() != null ? updatedInstructor.getNationalIdentity() : instructor.getNationalIdentity());
        instructor.setDateOfBirth((updatedInstructor.getDateOfBirth() != null ? updatedInstructor.getDateOfBirth() : instructor.getDateOfBirth()));
        instructor.setCompanyName(updatedInstructor.getCompanyName() != null ? updatedInstructor.getCompanyName() : instructor.getCompanyName());

        instructorRepository.save(instructor);

        UpdateInstructorResponse response = mapperService.forResponse()
                .map(instructor, UpdateInstructorResponse.class);

        return new SuccessDataResult
                <UpdateInstructorResponse>
                (response, "Instructor Updated");
    }

    @Override
    public DataResult<List<GetAllInstructorResponse>> getAllSorted(
            PageDto pageDto
    ) {
        Sort sort = Sort.by(Sort.Direction.fromString
                (pageDto.getSortDirection()), pageDto.getSortBy());


        Pageable pageable = PageRequest.of
                (pageDto.getPageNumber(), pageDto.getPageSize(), sort);

        Page<Instructor> instructors = instructorRepository.findAll(pageable);

        List <GetAllInstructorResponse> response = instructors.stream()
                .map(instructor -> mapperService.forResponse()
                .map(instructor, GetAllInstructorResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult
                <List<GetAllInstructorResponse>>
                (response, "All Instructors Sorted");
    }

    @Override
    public Result deleteInstructorById(
            int id
    ) {
        instructorRepository.deleteById(id);
        return new SuccessResult("Instructor Deleted!");
    }
}
