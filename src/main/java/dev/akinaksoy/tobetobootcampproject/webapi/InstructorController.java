package dev.akinaksoy.tobetobootcampproject.webapi;

import dev.akinaksoy.tobetobootcampproject.business.abstracts.InstructorService;
import dev.akinaksoy.tobetobootcampproject.business.request.create.CreateInstructorRequest;
import dev.akinaksoy.tobetobootcampproject.business.response.create.CreateInstructorResponse;
import dev.akinaksoy.tobetobootcampproject.entities.Instructor;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/instructors")
@AllArgsConstructor
public class InstructorController {

    private InstructorService instructorService;

    @PostMapping
    public CreateInstructorResponse createInstructor(
            @RequestBody @Valid CreateInstructorRequest request
    ){
        return instructorService.createInstructor(request);
    }
}
