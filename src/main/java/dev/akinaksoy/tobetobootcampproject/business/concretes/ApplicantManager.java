package dev.akinaksoy.tobetobootcampproject.business.concretes;

import dev.akinaksoy.tobetobootcampproject.business.abstracts.ApplicantService;
import dev.akinaksoy.tobetobootcampproject.business.request.create.CreateApplicantRequest;
import dev.akinaksoy.tobetobootcampproject.business.response.create.CreateApplicantResponse;
import dev.akinaksoy.tobetobootcampproject.core.utilities.modelmapper.ModelMapperService;
import dev.akinaksoy.tobetobootcampproject.core.utilities.results.DataResult;
import dev.akinaksoy.tobetobootcampproject.core.utilities.results.SuccessDataResult;
import dev.akinaksoy.tobetobootcampproject.dataaaccess.ApplicantRepository;
import dev.akinaksoy.tobetobootcampproject.entities.Applicant;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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

        return new SuccessDataResult<CreateApplicantResponse>(response, "Applicant created successfully.");
    }
}
