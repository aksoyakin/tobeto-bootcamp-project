package dev.akinaksoy.tobetobootcampproject.business.abstracts;


import dev.akinaksoy.tobetobootcampproject.business.request.create.CreateApplicationRequest;
import dev.akinaksoy.tobetobootcampproject.business.request.update.UpdateApplicationRequest;
import dev.akinaksoy.tobetobootcampproject.business.response.create.CreateApplicationResponse;
import dev.akinaksoy.tobetobootcampproject.business.response.get.GetAllApplicationResponse;
import dev.akinaksoy.tobetobootcampproject.business.response.get.GetApplicationByIdResponse;
import dev.akinaksoy.tobetobootcampproject.business.response.update.UpdateApplicationResponse;
import dev.akinaksoy.tobetobootcampproject.core.utilities.results.DataResult;

import java.util.List;

public interface ApplicationService {
    DataResult<CreateApplicationResponse> createApplication(
            CreateApplicationRequest request
    );

    DataResult<GetApplicationByIdResponse> getApplicationById(
            int id
    );

    DataResult<List<GetAllApplicationResponse>> getAllApplication(

    );

    DataResult<UpdateApplicationResponse> updateApplication(
            UpdateApplicationRequest request
    );


}
