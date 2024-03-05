package dev.akinaksoy.tobetobootcampproject.business.concretes;

import dev.akinaksoy.tobetobootcampproject.business.abstracts.ApplicantService;
import dev.akinaksoy.tobetobootcampproject.business.request.create.CreateApplicantRequest;
import dev.akinaksoy.tobetobootcampproject.business.request.update.UpdateApplicantRequest;
import dev.akinaksoy.tobetobootcampproject.business.response.create.CreateApplicantResponse;
import dev.akinaksoy.tobetobootcampproject.business.response.get.GetAllApplicantResponse;
import dev.akinaksoy.tobetobootcampproject.business.response.get.GetApplicantByIdResponse;
import dev.akinaksoy.tobetobootcampproject.business.response.update.UpdateApplicantResponse;
import dev.akinaksoy.tobetobootcampproject.core.utilities.modelmapper.ModelMapperService;
import dev.akinaksoy.tobetobootcampproject.core.utilities.paging.PageDto;
import dev.akinaksoy.tobetobootcampproject.core.utilities.results.DataResult;
import dev.akinaksoy.tobetobootcampproject.core.utilities.results.Result;
import dev.akinaksoy.tobetobootcampproject.core.utilities.results.SuccessDataResult;
import dev.akinaksoy.tobetobootcampproject.core.utilities.results.SuccessResult;
import dev.akinaksoy.tobetobootcampproject.dataaaccess.ApplicantRepository;
import dev.akinaksoy.tobetobootcampproject.entities.Applicant;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ApplicantManager implements ApplicantService {
    private ApplicantRepository applicantRepository;
    private ModelMapperService mapperService;

    @Override
    public DataResult<CreateApplicantResponse> createApplicant(
            CreateApplicantRequest request
    ){
        Applicant applicant = mapperService.forRequest()
                .map(request,Applicant.class);

        applicant.setCreatedDate(LocalDateTime.now());

        applicantRepository.save(applicant);

        CreateApplicantResponse response = mapperService.forResponse()
                .map(applicant,CreateApplicantResponse.class);

        return new SuccessDataResult
                <CreateApplicantResponse>
                (response, "Applicant created successfully.");
    }

    @Override
    public DataResult<GetApplicantByIdResponse> getApplicantById(
            int id
    ) {
        Applicant applicant = applicantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no applicant with this ID."));

        GetApplicantByIdResponse response = mapperService.forResponse()
                .map(applicant,GetApplicantByIdResponse.class);

        return new SuccessDataResult
                <GetApplicantByIdResponse>
                (response,"Applicant listed successfully.");
    }

    @Override
    public DataResult<List<GetAllApplicantResponse>> getAllApplicant(

    ) {
        List<Applicant> applicants = applicantRepository.findAll();

        List <GetAllApplicantResponse> response = applicants.stream()
                .map(applicant -> mapperService.forResponse()
                .map(applicant, GetAllApplicantResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult
                <List<GetAllApplicantResponse>>
                (response, "All applicants listed successfully.");
    }

    @Override
    public DataResult<List<GetAllApplicantResponse>> getAllSorted(
            PageDto pageDto
    ) {
        Sort sort = Sort.by(Sort.Direction.fromString
                (pageDto.getSortDirection()), pageDto.getSortBy());

        Pageable pageable = PageRequest.of
                (pageDto.getPageNumber(), pageDto.getPageSize(), sort);

        Page<Applicant> applicants = applicantRepository.findAll(pageable);

        List <GetAllApplicantResponse> response = applicants.stream()
                .map(applicant -> mapperService.forResponse()
                .map(applicant, GetAllApplicantResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult
                <List<GetAllApplicantResponse>>
                (response, "All applicants sorted successfully.");
    }

    @Override
    public DataResult<UpdateApplicantResponse> updateApplicantById(
            UpdateApplicantRequest request,
            int id
    ) {
        Applicant applicant = applicantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no applicant with this ID."));

        Applicant updatedApplicant = mapperService.forRequest()
                .map(request,Applicant.class);

        applicant.setId(id);
        applicant.setUpdatedDate(LocalDateTime.now());

        applicant.setFirstName(updatedApplicant.getFirstName() != null ? updatedApplicant.getFirstName() : applicant.getFirstName());
        applicant.setLastName(updatedApplicant.getLastName() != null ? updatedApplicant.getLastName() : applicant.getLastName());
        applicant.setAbout(updatedApplicant.getAbout() != null ? updatedApplicant.getAbout() : applicant.getAbout());
        applicant.setUserName(updatedApplicant.getUserName() != null ? updatedApplicant.getUserName() : applicant.getUserName());
        applicant.setNationalIdentity(updatedApplicant.getNationalIdentity() != null ? updatedApplicant.getNationalIdentity() : applicant.getNationalIdentity());
        applicant.setDateOfBirth((updatedApplicant.getDateOfBirth() != null ? updatedApplicant.getDateOfBirth() : applicant.getDateOfBirth()));

        applicantRepository.save(applicant);
        UpdateApplicantResponse response = mapperService.forResponse().map(applicant, UpdateApplicantResponse.class);

        return new SuccessDataResult
                <UpdateApplicantResponse>
                (response, "Applicant updated successfully.");

    }

    @Override
    public Result deleteApplicantById(
            int id
    ) {
        applicantRepository.deleteById(id);
        return new SuccessResult
                ("Applicant deleted successfully");
    }


}
