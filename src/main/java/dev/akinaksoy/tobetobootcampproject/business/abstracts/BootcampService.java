package dev.akinaksoy.tobetobootcampproject.business.abstracts;

import dev.akinaksoy.tobetobootcampproject.business.request.create.CreateBootcampRequest;
import dev.akinaksoy.tobetobootcampproject.business.request.update.UpdateBootcampRequest;
import dev.akinaksoy.tobetobootcampproject.business.response.create.CreateBootcampResponse;
import dev.akinaksoy.tobetobootcampproject.business.response.get.GetAllBootcampResponse;
import dev.akinaksoy.tobetobootcampproject.business.response.get.GetBootcampByIdResponse;
import dev.akinaksoy.tobetobootcampproject.business.response.update.UpdateBootcampResponse;
import dev.akinaksoy.tobetobootcampproject.core.utilities.paging.PageDto;
import dev.akinaksoy.tobetobootcampproject.core.utilities.results.DataResult;
import dev.akinaksoy.tobetobootcampproject.core.utilities.results.Result;
import dev.akinaksoy.tobetobootcampproject.core.utilities.results.SuccessDataResult;

import java.util.List;

public interface BootcampService {
    DataResult<CreateBootcampResponse> createBootcamp(
            CreateBootcampRequest request
    );

    SuccessDataResult<List<GetAllBootcampResponse>> getAllBootcamp(

    );

    DataResult<GetBootcampByIdResponse> getBootcampById(
            int id
    );
    DataResult<UpdateBootcampResponse> updateBootcamp(
            UpdateBootcampRequest request
    );

    DataResult<List<GetAllBootcampResponse>> getAllSorted(
            PageDto pageDto
    );

    Result deleteBootcamp(
            int id
    );

}
