package dev.akinaksoy.tobetobootcampproject.business.abstracts;

import dev.akinaksoy.tobetobootcampproject.business.request.create.CreateBootcampRequest;
import dev.akinaksoy.tobetobootcampproject.business.response.create.CreateBootcampResponse;
import dev.akinaksoy.tobetobootcampproject.core.utilities.results.DataResult;

public interface BootcampService {
    DataResult<CreateBootcampResponse> createBootcamp(
            CreateBootcampRequest request
    );
}
