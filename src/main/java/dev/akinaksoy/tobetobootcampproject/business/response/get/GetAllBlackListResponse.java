package dev.akinaksoy.tobetobootcampproject.business.response.get;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllBlackListResponse {
    private int id;
    private String reason;
    private LocalDateTime date;
    private int applicantId;
}
