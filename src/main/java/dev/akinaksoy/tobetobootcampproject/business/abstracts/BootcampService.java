package dev.akinaksoy.tobetobootcampproject.business.abstracts;

import dev.akinaksoy.tobetobootcampproject.business.request.create.CreateBootcampRequest;
import dev.akinaksoy.tobetobootcampproject.business.response.create.CreateBootcampResponse;

public interface BootcampService {
    CreateBootcampResponse createBootcamp(
            CreateBootcampRequest request
    );
}
