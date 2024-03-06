package dev.akinaksoy.tobetobootcampproject.business.abstracts;

import dev.akinaksoy.tobetobootcampproject.business.request.create.CreateApplicationStateRequest;
import dev.akinaksoy.tobetobootcampproject.business.request.update.UpdateApplicationStateRequest;
import dev.akinaksoy.tobetobootcampproject.business.response.create.CreateApplicationStateResponse;
import dev.akinaksoy.tobetobootcampproject.business.response.get.GetAllApplicationStateResponse;
import dev.akinaksoy.tobetobootcampproject.business.response.get.GetApplicationStateByIdResponse;
import dev.akinaksoy.tobetobootcampproject.business.response.update.UpdateApplicationStateResponse;
import dev.akinaksoy.tobetobootcampproject.core.utilities.paging.PageDto;
import dev.akinaksoy.tobetobootcampproject.core.utilities.results.DataResult;
import dev.akinaksoy.tobetobootcampproject.core.utilities.results.Result;

import java.util.List;

public interface ApplicationStateService {
    DataResult<CreateApplicationStateResponse> createApplicationState(
            CreateApplicationStateRequest request
    );
    DataResult<List<GetAllApplicationStateResponse>> getAllStates(

    );
    DataResult<GetApplicationStateByIdResponse> getApplicationStateById(
            int id
    );
    DataResult<UpdateApplicationStateResponse> updateApplicationState(
            UpdateApplicationStateRequest request
    );

    DataResult<List<GetAllApplicationStateResponse>> getAllSorted(
            PageDto pageDto
    );
    Result deleteApplicationState(
            int id
    );


}
