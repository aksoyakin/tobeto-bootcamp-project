package dev.akinaksoy.tobetobootcampproject.business.abstracts;

import dev.akinaksoy.tobetobootcampproject.business.response.get.GetAllUserResponse;
import dev.akinaksoy.tobetobootcampproject.business.response.get.GetUserByEmailResponse;
import dev.akinaksoy.tobetobootcampproject.core.utilities.paging.PageDto;
import dev.akinaksoy.tobetobootcampproject.core.utilities.results.DataResult;

import java.util.List;

public interface UserService {
    DataResult<List<GetAllUserResponse>> getAll(

    );

    DataResult<GetUserByEmailResponse> getUserByEmail(
            String email
    );

    DataResult<List<GetAllUserResponse>> getAllSorted(
            PageDto pageDto
    );
}
