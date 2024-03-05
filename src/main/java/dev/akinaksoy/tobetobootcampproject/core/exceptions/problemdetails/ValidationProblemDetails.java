package dev.akinaksoy.tobetobootcampproject.core.exceptions.problemdetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Data
//@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)

public class ValidationProblemDetails extends ProblemDetails{
    private Map<String, String> errors;
    public ValidationProblemDetails() {
        setTitle("Validation Rule Violation");
        setDetail("Validation Problems");
        setType("https://lms.tobeto.com/exceptions/validation");
        setStatus(HttpStatus.BAD_REQUEST.toString());
    }
}
