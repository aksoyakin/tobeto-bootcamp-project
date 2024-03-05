package dev.akinaksoy.tobetobootcampproject.business.abstracts;


import dev.akinaksoy.tobetobootcampproject.business.request.create.CreateApplicationRequest;
import dev.akinaksoy.tobetobootcampproject.business.response.create.CreateApplicationResponse;

public interface ApplicationService {
    CreateApplicationResponse createApplication(
            CreateApplicationRequest request
    );
}
