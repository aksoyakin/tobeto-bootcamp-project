package dev.akinaksoy.tobetobootcampproject.business.abstracts;

import dev.akinaksoy.tobetobootcampproject.business.request.create.CreateApplicantRequest;
import dev.akinaksoy.tobetobootcampproject.business.response.create.CreateApplicantResponse;
import dev.akinaksoy.tobetobootcampproject.core.utilities.results.DataResult;

public interface ApplicantService {
    DataResult<CreateApplicantResponse> createApplicant(
            CreateApplicantRequest request);
}
