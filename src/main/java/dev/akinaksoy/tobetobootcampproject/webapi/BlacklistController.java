package dev.akinaksoy.tobetobootcampproject.webapi;

import dev.akinaksoy.tobetobootcampproject.business.abstracts.BlacklistService;
import dev.akinaksoy.tobetobootcampproject.business.request.create.CreateBlacklistRequest;
import dev.akinaksoy.tobetobootcampproject.business.response.create.CreateBlacklistResponse;
import dev.akinaksoy.tobetobootcampproject.entities.Blacklist;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/blacklists")
@AllArgsConstructor
public class BlacklistController {

    private BlacklistService blacklistService;

    @PostMapping
    public CreateBlacklistResponse createBlacklist(
            @RequestBody @Valid CreateBlacklistRequest request
    ) {
        return blacklistService.createBlacklist(request);
    }

}
