package dev.akinaksoy.tobetobootcampproject.business.abstracts;

import dev.akinaksoy.tobetobootcampproject.business.request.create.CreateApplicationStateRequest;
import dev.akinaksoy.tobetobootcampproject.business.response.create.CreateApplicationStateResponse;
import dev.akinaksoy.tobetobootcampproject.core.utilities.results.DataResult;

public interface ApplicationStateService {
    DataResult<CreateApplicationStateResponse> createApplicationState(
            CreateApplicationStateRequest request
    );
}
