package dev.akinaksoy.tobetobootcampproject.webapi;

import dev.akinaksoy.tobetobootcampproject.business.abstracts.ApplicationService;
import dev.akinaksoy.tobetobootcampproject.business.request.create.CreateApplicationRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/applications")
@AllArgsConstructor
public class ApplicationController extends BaseController {

    private ApplicationService applicationService;

    @PostMapping
    public ResponseEntity<?> createApplication(
            @RequestBody @Valid CreateApplicationRequest request
    ){
        return handleDataResult(applicationService.createApplication(request));
    }
}
