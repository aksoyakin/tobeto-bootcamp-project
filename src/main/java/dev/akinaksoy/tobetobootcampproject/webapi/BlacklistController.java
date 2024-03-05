package dev.akinaksoy.tobetobootcampproject.webapi;

import dev.akinaksoy.tobetobootcampproject.business.abstracts.BlacklistService;
import dev.akinaksoy.tobetobootcampproject.business.request.create.CreateBlacklistRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/blacklists")
@AllArgsConstructor
public class BlacklistController extends BaseController{

    private BlacklistService blacklistService;

    @PostMapping
    public ResponseEntity<?> createBlacklist(
            @RequestBody @Valid CreateBlacklistRequest request
    ) {
        return handleDataResult(blacklistService.createBlacklist(request));
    }

}
