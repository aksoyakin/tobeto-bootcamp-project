package dev.akinaksoy.tobetobootcampproject.webapi;

import dev.akinaksoy.tobetobootcampproject.business.abstracts.BootcampStateService;
import dev.akinaksoy.tobetobootcampproject.business.request.create.CreateBootcampStateRequest;
import dev.akinaksoy.tobetobootcampproject.business.response.create.CreateBootcampStateResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/bootcampstates")
@AllArgsConstructor
public class BootcampStateController {
    private BootcampStateService bootcampStateService;

    @PostMapping
    public CreateBootcampStateResponse createBootcampState(
             @RequestBody @Valid CreateBootcampStateRequest request
    ) {
        return bootcampStateService.createBootcampState(request);
    }
}
