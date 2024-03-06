package dev.akinaksoy.tobetobootcampproject.business.abstracts;

import dev.akinaksoy.tobetobootcampproject.business.request.create.CreateBlacklistRequest;
import dev.akinaksoy.tobetobootcampproject.business.request.update.UpdateBlacklistRequest;
import dev.akinaksoy.tobetobootcampproject.business.response.create.CreateBlacklistResponse;
import dev.akinaksoy.tobetobootcampproject.business.response.get.GetAllBlackListResponse;
import dev.akinaksoy.tobetobootcampproject.business.response.get.GetBlackListByIdResponse;
import dev.akinaksoy.tobetobootcampproject.business.response.update.UpdateBlacklistResponse;
import dev.akinaksoy.tobetobootcampproject.core.utilities.paging.PageDto;
import dev.akinaksoy.tobetobootcampproject.core.utilities.results.DataResult;
import dev.akinaksoy.tobetobootcampproject.core.utilities.results.Result;

import java.util.List;

public interface BlacklistService {
    DataResult<CreateBlacklistResponse> createBlacklist(
            CreateBlacklistRequest request
    );

    DataResult<List<GetAllBlackListResponse>> getAllBlacklist(

    );

    DataResult<GetBlackListByIdResponse> getBlacklistById(
            int id
    );

    DataResult<UpdateBlacklistResponse> updateBlacklist(
            UpdateBlacklistRequest request
    );

    DataResult<List<GetAllBlackListResponse>> getAllSorted(
            PageDto pageDto
    );

    Result deleteBlacklist(
            int id
    );
}
