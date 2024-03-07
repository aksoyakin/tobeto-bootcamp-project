package dev.akinaksoy.tobetobootcampproject.business.response.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBootcampStateResponse {
    private int id;
    private String name;
}