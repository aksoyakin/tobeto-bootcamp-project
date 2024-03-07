package dev.akinaksoy.tobetobootcampproject.business.response.get;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserByIdResponse {
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
}