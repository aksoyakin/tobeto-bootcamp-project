package dev.akinaksoy.tobetobootcampproject.business.concretes;

import dev.akinaksoy.tobetobootcampproject.business.abstracts.ApplicationService;
import dev.akinaksoy.tobetobootcampproject.business.request.create.CreateApplicationRequest;
import dev.akinaksoy.tobetobootcampproject.business.response.create.CreateApplicantResponse;
import dev.akinaksoy.tobetobootcampproject.business.response.create.CreateApplicationResponse;
import dev.akinaksoy.tobetobootcampproject.business.response.get.GetAllApplicationResponse;
import dev.akinaksoy.tobetobootcampproject.business.response.get.GetApplicationByIdResponse;
import dev.akinaksoy.tobetobootcampproject.core.utilities.modelmapper.ModelMapperService;
import dev.akinaksoy.tobetobootcampproject.core.utilities.results.DataResult;
import dev.akinaksoy.tobetobootcampproject.core.utilities.results.SuccessDataResult;
import dev.akinaksoy.tobetobootcampproject.dataaaccess.ApplicationRepository;
import dev.akinaksoy.tobetobootcampproject.entities.Application;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ApplicationManager implements ApplicationService {
    private ApplicationRepository applicationRepository;
    private ModelMapperService mapperService;

    @Override
    public DataResult<CreateApplicationResponse> createApplication(
            CreateApplicationRequest request
    ) {
        Application application = mapperService.forRequest()
                .map(request,Application.class);

        application.setCreatedDate(LocalDateTime.now());

        applicationRepository.save(application);

        CreateApplicationResponse response = mapperService.forResponse()
                .map(application, CreateApplicationResponse.class);

        return new SuccessDataResult
                <CreateApplicationResponse>
                (response,"Application created successfully.");

    }

    @Override
    public DataResult<GetApplicationByIdResponse> getApplicationById(
            int id
    ) {
        Application application = applicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no application with this ID."));

        GetApplicationByIdResponse response = mapperService.forResponse()
                .map(application,GetApplicationByIdResponse.class);

        return new SuccessDataResult
                <GetApplicationByIdResponse>
                (response,"Application listed successfully.");
    }

    @Override
    public DataResult<List<GetAllApplicationResponse>> getAllApplication(

    ) {
        List <Application> applications = applicationRepository.findAll();

        List <GetAllApplicationResponse> response = applications.stream()
                .map(application -> mapperService.forResponse()
                .map(application, GetAllApplicationResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult
                <List<GetAllApplicationResponse>>
                (response, "All applications listed successfully.");
    }


}
