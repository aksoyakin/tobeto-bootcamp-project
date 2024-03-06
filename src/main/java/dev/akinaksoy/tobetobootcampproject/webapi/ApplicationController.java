package dev.akinaksoy.tobetobootcampproject.webapi;

import dev.akinaksoy.tobetobootcampproject.business.abstracts.ApplicationService;
import dev.akinaksoy.tobetobootcampproject.business.request.create.CreateApplicationRequest;
import dev.akinaksoy.tobetobootcampproject.business.request.update.UpdateApplicantRequest;
import dev.akinaksoy.tobetobootcampproject.business.request.update.UpdateApplicationRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<?> getApplicationById(
            @PathVariable int id
    ){
        return handleDataResult(applicationService.getApplicationById(id));
    }
    @GetMapping("/get-all")
    public ResponseEntity<?> getAllApplication(

    ){
        return handleDataResult(applicationService.getAllApplication());
    }

    @PutMapping
    public ResponseEntity<?> updateApplication(
            @RequestBody @Valid UpdateApplicationRequest request
    ){
        return handleDataResult(applicationService.updateApplication(request));
    }
}
