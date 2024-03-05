package dev.akinaksoy.tobetobootcampproject.business.concretes;

import dev.akinaksoy.tobetobootcampproject.business.abstracts.ApplicationService;
import dev.akinaksoy.tobetobootcampproject.business.request.create.CreateApplicationRequest;
import dev.akinaksoy.tobetobootcampproject.business.response.create.CreateApplicantResponse;
import dev.akinaksoy.tobetobootcampproject.business.response.create.CreateApplicationResponse;
import dev.akinaksoy.tobetobootcampproject.core.utilities.modelmapper.ModelMapperService;
import dev.akinaksoy.tobetobootcampproject.dataaaccess.ApplicationRepository;
import dev.akinaksoy.tobetobootcampproject.entities.Application;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class ApplicationManager implements ApplicationService {
    private ApplicationRepository applicationRepository;
    private ModelMapperService mapperService;

    @Override
    public CreateApplicationResponse createApplication(
            CreateApplicationRequest request
    ) {
        Application application = mapperService.forRequest()
                .map(request,Application.class);

        application.setCreatedDate(LocalDateTime.now());

        applicationRepository.save(application);

        return mapperService.forResponse()
                .map(application, CreateApplicationResponse.class);
    }
}
