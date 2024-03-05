package dev.akinaksoy.tobetobootcampproject.business.concretes;

import dev.akinaksoy.tobetobootcampproject.business.abstracts.BootcampService;
import dev.akinaksoy.tobetobootcampproject.business.request.create.CreateBootcampRequest;
import dev.akinaksoy.tobetobootcampproject.business.response.create.CreateBootcampResponse;
import dev.akinaksoy.tobetobootcampproject.core.utilities.modelmapper.ModelMapperService;
import dev.akinaksoy.tobetobootcampproject.core.utilities.results.DataResult;
import dev.akinaksoy.tobetobootcampproject.core.utilities.results.SuccessDataResult;
import dev.akinaksoy.tobetobootcampproject.dataaaccess.BootcampRepository;
import dev.akinaksoy.tobetobootcampproject.entities.Bootcamp;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class BootcampManager implements BootcampService {
    private BootcampRepository bootcampRepository;
    private ModelMapperService mapperService;
    @Override
    public DataResult<CreateBootcampResponse> createBootcamp(
            CreateBootcampRequest request
    ) {
        Bootcamp bootcamp = mapperService.forRequest()
                .map(request,Bootcamp.class);

        bootcamp.setCreatedDate(LocalDateTime.now());

        bootcampRepository.save(bootcamp);

        CreateBootcampResponse response = mapperService.forResponse()
                .map(bootcamp, CreateBootcampResponse.class);

        return new SuccessDataResult
                <CreateBootcampResponse>
                (response,"Bootcamp created successfully.");
    }
}
