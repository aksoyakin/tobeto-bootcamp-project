package dev.akinaksoy.tobetobootcampproject.webapi;

import dev.akinaksoy.tobetobootcampproject.business.abstracts.ApplicationStateService;
import dev.akinaksoy.tobetobootcampproject.business.request.create.CreateApplicationStateRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/applicationstates")
@AllArgsConstructor
public class ApplicationStateController extends BaseController{

    private ApplicationStateService applicationStateService;

    @PostMapping
    ResponseEntity<?> createApplicationState(
            @RequestBody @Valid CreateApplicationStateRequest request
    ){
        return handleDataResult(applicationStateService.createApplicationState(request));
    }
}
