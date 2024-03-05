package dev.akinaksoy.tobetobootcampproject.webapi;

import dev.akinaksoy.tobetobootcampproject.business.abstracts.InstructorService;
import dev.akinaksoy.tobetobootcampproject.business.request.create.CreateInstructorRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/instructors")
@AllArgsConstructor
public class InstructorController extends BaseController {

    private InstructorService instructorService;

    @PostMapping
    public ResponseEntity<?> createInstructor(
            @RequestBody @Valid CreateInstructorRequest request
    ){
        return handleDataResult(instructorService.createInstructor(request));
    }
}
