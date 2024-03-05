package dev.akinaksoy.tobetobootcampproject.business.abstracts;


import dev.akinaksoy.tobetobootcampproject.business.request.create.CreateApplicationRequest;
import dev.akinaksoy.tobetobootcampproject.business.response.create.CreateApplicationResponse;
import dev.akinaksoy.tobetobootcampproject.core.utilities.results.DataResult;

public interface ApplicationService {
    DataResult<CreateApplicationResponse> createApplication(
            CreateApplicationRequest request
    );
}
