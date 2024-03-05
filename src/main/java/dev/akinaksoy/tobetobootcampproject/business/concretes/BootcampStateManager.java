package dev.akinaksoy.tobetobootcampproject.business.concretes;

import dev.akinaksoy.tobetobootcampproject.business.abstracts.BootcampStateService;
import dev.akinaksoy.tobetobootcampproject.business.request.create.CreateBootcampStateRequest;
import dev.akinaksoy.tobetobootcampproject.business.response.create.CreateBootcampStateResponse;
import dev.akinaksoy.tobetobootcampproject.core.utilities.modelmapper.ModelMapperService;
import dev.akinaksoy.tobetobootcampproject.dataaaccess.BootcampStateRepository;
import dev.akinaksoy.tobetobootcampproject.entities.BootcampState;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class BootcampStateManager implements BootcampStateService {
    private BootcampStateRepository bootcampStateRepository;
    private ModelMapperService mapperService;
    @Override
    public CreateBootcampStateResponse createBootcampState(
            CreateBootcampStateRequest request
    ) {
        BootcampState bootcampState = mapperService.forRequest()
                .map(request,BootcampState.class);

        bootcampState.setCreatedDate(LocalDateTime.now());

        bootcampStateRepository.save(bootcampState);

        return mapperService.forResponse()
                .map(bootcampState, CreateBootcampStateResponse.class);
    }
}
