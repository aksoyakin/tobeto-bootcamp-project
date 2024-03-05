package dev.akinaksoy.tobetobootcampproject.business.abstracts;

import dev.akinaksoy.tobetobootcampproject.business.request.create.CreateApplicationStateRequest;
import dev.akinaksoy.tobetobootcampproject.business.response.create.CreateApplicationStateResponse;

public interface ApplicationStateService {
    CreateApplicationStateResponse createApplicationState(
            CreateApplicationStateRequest request
    );
}
