package dev.akinaksoy.tobetobootcampproject.business.abstracts;

import dev.akinaksoy.tobetobootcampproject.business.request.create.CreateBootcampStateRequest;
import dev.akinaksoy.tobetobootcampproject.business.response.create.CreateBootcampStateResponse;
import dev.akinaksoy.tobetobootcampproject.core.utilities.results.DataResult;

public interface BootcampStateService {
    DataResult<CreateBootcampStateResponse> createBootcampState(
            CreateBootcampStateRequest request
    );
}
