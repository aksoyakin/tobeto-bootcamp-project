package dev.akinaksoy.tobetobootcampproject.business.response.get;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllEmployeeResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String position;
    private LocalDateTime dateOfBirth;
}
