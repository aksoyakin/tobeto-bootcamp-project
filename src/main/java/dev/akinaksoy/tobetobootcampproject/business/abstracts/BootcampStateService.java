package dev.akinaksoy.tobetobootcampproject.business.abstracts;

import dev.akinaksoy.tobetobootcampproject.business.request.create.CreateBootcampStateRequest;
import dev.akinaksoy.tobetobootcampproject.business.request.update.UpdateBootcampStateRequest;
import dev.akinaksoy.tobetobootcampproject.business.response.create.CreateBootcampStateResponse;
import dev.akinaksoy.tobetobootcampproject.business.response.get.GetAllBootcampStateResponse;
import dev.akinaksoy.tobetobootcampproject.business.response.get.GetBootcampStateByIdResponse;
import dev.akinaksoy.tobetobootcampproject.business.response.update.UpdateBootcampStateResponse;
import dev.akinaksoy.tobetobootcampproject.core.utilities.paging.PageDto;
import dev.akinaksoy.tobetobootcampproject.core.utilities.results.DataResult;
import dev.akinaksoy.tobetobootcampproject.core.utilities.results.Result;

import java.util.List;

public interface BootcampStateService {
    DataResult<CreateBootcampStateResponse> createBootcampState(
            CreateBootcampStateRequest request
    );
    DataResult<List<GetAllBootcampStateResponse>> getAllBootcampStates(

    );

    DataResult<GetBootcampStateByIdResponse> getBootcampState(
            int id
    );

    DataResult<UpdateBootcampStateResponse> updateBootcampState(
            UpdateBootcampStateRequest request
    );

    DataResult<List<GetAllBootcampStateResponse>> getAllSorted(
            PageDto pageDto
    );

    Result deleteBootcampState(
            int id
    );
}
