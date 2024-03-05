package dev.akinaksoy.tobetobootcampproject.business.abstracts;

import dev.akinaksoy.tobetobootcampproject.business.request.create.CreateBlacklistRequest;
import dev.akinaksoy.tobetobootcampproject.business.response.create.CreateBlacklistResponse;

public interface BlacklistService {
    CreateBlacklistResponse createBlacklist(
            CreateBlacklistRequest request
    );
}
