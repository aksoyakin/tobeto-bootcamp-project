package dev.akinaksoy.tobetobootcampproject.business.abstracts;

import dev.akinaksoy.tobetobootcampproject.business.request.create.CreateBootcampStateRequest;
import dev.akinaksoy.tobetobootcampproject.business.response.create.CreateBootcampStateResponse;

public interface BootcampStateService {
    CreateBootcampStateResponse createBootcampState(
            CreateBootcampStateRequest request
    );
}
