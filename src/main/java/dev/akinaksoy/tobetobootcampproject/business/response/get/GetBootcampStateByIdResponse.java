package dev.akinaksoy.tobetobootcampproject.business.response.get;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetBootcampStateByIdResponse {
    private int id;
    private String name;
}
