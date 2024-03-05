package dev.akinaksoy.tobetobootcampproject.webapi;

import dev.akinaksoy.tobetobootcampproject.business.abstracts.BootcampStateService;
import dev.akinaksoy.tobetobootcampproject.business.request.create.CreateBootcampRequest;
import dev.akinaksoy.tobetobootcampproject.business.request.create.CreateBootcampStateRequest;
import dev.akinaksoy.tobetobootcampproject.business.response.create.CreateBootcampResponse;
import dev.akinaksoy.tobetobootcampproject.business.response.create.CreateBootcampStateResponse;
import dev.akinaksoy.tobetobootcampproject.entities.Bootcamp;
import dev.akinaksoy.tobetobootcampproject.entities.BootcampState;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
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
            CreateBootcampStateRequest request
    ) {
        return bootcampStateService.createBootcampState(request);
    }
}
