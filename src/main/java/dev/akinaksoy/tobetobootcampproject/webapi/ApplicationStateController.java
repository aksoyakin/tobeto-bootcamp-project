package dev.akinaksoy.tobetobootcampproject.webapi;

import dev.akinaksoy.tobetobootcampproject.business.abstracts.ApplicationStateService;
import dev.akinaksoy.tobetobootcampproject.business.request.create.CreateApplicationStateRequest;
import dev.akinaksoy.tobetobootcampproject.business.response.create.CreateApplicationStateResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/applicationstates")
@AllArgsConstructor
public class ApplicationStateController {

    private ApplicationStateService applicationStateService;

    @PostMapping
    CreateApplicationStateResponse createApplicationStater(
            @RequestBody @Valid CreateApplicationStateRequest request
    ){
        return applicationStateService.createApplicationState(request);
    }
}
