package dev.akinaksoy.tobetobootcampproject.business.abstracts;

import dev.akinaksoy.tobetobootcampproject.business.request.create.CreateBlacklistRequest;
import dev.akinaksoy.tobetobootcampproject.business.response.create.CreateBlacklistResponse;
import dev.akinaksoy.tobetobootcampproject.core.utilities.results.DataResult;

public interface BlacklistService {
    DataResult<CreateBlacklistResponse> createBlacklist(
            CreateBlacklistRequest request
    );
}
