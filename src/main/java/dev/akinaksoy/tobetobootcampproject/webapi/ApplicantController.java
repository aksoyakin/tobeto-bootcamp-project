package dev.akinaksoy.tobetobootcampproject.webapi;

import dev.akinaksoy.tobetobootcampproject.business.abstracts.ApplicantService;
import dev.akinaksoy.tobetobootcampproject.business.request.create.CreateApplicantRequest;
import dev.akinaksoy.tobetobootcampproject.business.request.update.UpdateApplicantRequest;
import dev.akinaksoy.tobetobootcampproject.business.response.update.UpdateApplicantResponse;
import dev.akinaksoy.tobetobootcampproject.core.utilities.paging.PageDto;
import dev.akinaksoy.tobetobootcampproject.core.utilities.results.DataResult;
import dev.akinaksoy.tobetobootcampproject.core.utilities.results.Result;
import dev.akinaksoy.tobetobootcampproject.core.utilities.results.SuccessResult;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/applicants")
@AllArgsConstructor
public class ApplicantController extends BaseController{

    private ApplicantService applicantService;

    @PostMapping
    public ResponseEntity<?> createApplicant(
            @RequestBody @Valid CreateApplicantRequest request
    ) {
        return handleDataResult(applicantService.createApplicant(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getApplicantById(
            @PathVariable int id
    ) {
        return handleDataResult(applicantService.getApplicantById(id));
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> gatAllApplicant(

    ) {
        return handleDataResult(applicantService.getAllApplicant());
    }

    @GetMapping("/sort")
    public ResponseEntity<?> getAllSorted(
            @RequestBody PageDto pageDto
    ) {
        return handleDataResult(applicantService.getAllSorted(pageDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateApplicantById(
            @RequestBody @Valid UpdateApplicantRequest request,
            @PathVariable int id
    ) {
        return handleDataResult(applicantService.updateApplicantById(request, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteApplicantById(
            @PathVariable int id
    ) {
        return handleResult(applicantService.deleteApplicantById(id));
    }
}
