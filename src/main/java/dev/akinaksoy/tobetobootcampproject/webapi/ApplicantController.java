package dev.akinaksoy.tobetobootcampproject.webapi;

import dev.akinaksoy.tobetobootcampproject.business.abstracts.ApplicantService;
import dev.akinaksoy.tobetobootcampproject.business.request.create.CreateApplicantRequest;
import dev.akinaksoy.tobetobootcampproject.business.response.create.CreateApplicantResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/applicants")
@AllArgsConstructor
public class ApplicantController {

    private ApplicantService applicantService;

    @PostMapping
    public CreateApplicantResponse createApplicant(
            @RequestBody @Valid CreateApplicantRequest request
    ){
        return applicantService.createApplicant(request);
    }
}
