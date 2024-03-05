package dev.akinaksoy.tobetobootcampproject.webapi;

import dev.akinaksoy.tobetobootcampproject.business.abstracts.BootcampStateService;
import dev.akinaksoy.tobetobootcampproject.business.request.create.CreateBootcampStateRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/bootcampstates")
@AllArgsConstructor
public class BootcampStateController extends BaseController {
    private BootcampStateService bootcampStateService;

    @PostMapping
    public ResponseEntity<?> createBootcampState(
             @RequestBody @Valid CreateBootcampStateRequest request
    ) {
        return handleDataResult(bootcampStateService.createBootcampState(request));
    }
}
