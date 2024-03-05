package dev.akinaksoy.tobetobootcampproject.webapi;

import dev.akinaksoy.tobetobootcampproject.business.abstracts.ApplicantService;
import dev.akinaksoy.tobetobootcampproject.business.request.create.CreateApplicantRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/applicants")
@AllArgsConstructor
public class ApplicantController extends BaseController{

    private ApplicantService applicantService;

    @PostMapping
    public ResponseEntity<?> createApplicant(
            @RequestBody @Valid CreateApplicantRequest request
    ){
        return handleDataResult(applicantService.createApplicant(request));
    }
}
