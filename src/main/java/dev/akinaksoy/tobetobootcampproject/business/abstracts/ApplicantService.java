package dev.akinaksoy.tobetobootcampproject.business.abstracts;

import dev.akinaksoy.tobetobootcampproject.business.request.create.CreateApplicantRequest;
import dev.akinaksoy.tobetobootcampproject.business.request.update.UpdateApplicantRequest;
import dev.akinaksoy.tobetobootcampproject.business.response.create.CreateApplicantResponse;
import dev.akinaksoy.tobetobootcampproject.business.response.get.GetAllApplicantResponse;
import dev.akinaksoy.tobetobootcampproject.business.response.get.GetApplicantByIdResponse;
import dev.akinaksoy.tobetobootcampproject.business.response.update.UpdateApplicantResponse;
import dev.akinaksoy.tobetobootcampproject.core.utilities.paging.PageDto;
import dev.akinaksoy.tobetobootcampproject.core.utilities.results.DataResult;
import dev.akinaksoy.tobetobootcampproject.core.utilities.results.Result;

import java.util.List;


public interface ApplicantService {
    DataResult<CreateApplicantResponse> createApplicant(
            CreateApplicantRequest request);

    DataResult<GetApplicantByIdResponse> getApplicantById(
            int id
    );

    DataResult<List<GetAllApplicantResponse>> getAllApplicant(

    );

    DataResult<List<GetAllApplicantResponse>> getAllSorted(
            PageDto pageDto
    );

    DataResult<UpdateApplicantResponse> updateApplicantById(
            UpdateApplicantRequest request,
            int id
    );

    Result deleteApplicantById(
            int id
    );
}
