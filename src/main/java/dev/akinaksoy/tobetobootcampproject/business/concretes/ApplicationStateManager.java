package dev.akinaksoy.tobetobootcampproject.business.concretes;

import dev.akinaksoy.tobetobootcampproject.business.abstracts.ApplicationStateService;
import dev.akinaksoy.tobetobootcampproject.business.request.create.CreateApplicationStateRequest;
import dev.akinaksoy.tobetobootcampproject.business.response.create.CreateApplicationStateResponse;
import dev.akinaksoy.tobetobootcampproject.core.utilities.modelmapper.ModelMapperService;
import dev.akinaksoy.tobetobootcampproject.core.utilities.results.DataResult;
import dev.akinaksoy.tobetobootcampproject.core.utilities.results.SuccessDataResult;
import dev.akinaksoy.tobetobootcampproject.dataaaccess.ApplicationStateRepository;
import dev.akinaksoy.tobetobootcampproject.entities.ApplicationState;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class ApplicationStateManager implements ApplicationStateService {
    private ApplicationStateRepository applicationStateRepository;
    private ModelMapperService mapperService;
    @Override
    public DataResult<CreateApplicationStateResponse> createApplicationState(
            CreateApplicationStateRequest request
    ) {
        ApplicationState applicationState = mapperService.forRequest()
                .map(request,ApplicationState.class);

        applicationState.setCreatedDate(LocalDateTime.now());

        applicationStateRepository.save(applicationState);

        CreateApplicationStateResponse response = mapperService.forResponse()
                .map(applicationState,CreateApplicationStateResponse.class);

        return new SuccessDataResult
                <CreateApplicationStateResponse>
                (response,"Application State created successfully.");

    }
}
