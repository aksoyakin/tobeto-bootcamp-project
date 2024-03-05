package dev.akinaksoy.tobetobootcampproject.webapi;

import dev.akinaksoy.tobetobootcampproject.business.abstracts.BootcampService;
import dev.akinaksoy.tobetobootcampproject.business.request.create.CreateBootcampRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/bootcamps")
@AllArgsConstructor
public class BootcampController extends BaseController {

    private BootcampService bootcampService;

    @PostMapping
    public ResponseEntity<?> createBootcamp(
            @RequestBody @Valid CreateBootcampRequest request
    ) {
        return handleDataResult(bootcampService.createBootcamp(request));
    }
}
