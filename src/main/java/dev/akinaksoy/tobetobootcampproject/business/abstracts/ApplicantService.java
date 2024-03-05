package dev.akinaksoy.tobetobootcampproject.business.abstracts;

import dev.akinaksoy.tobetobootcampproject.business.request.create.CreateApplicantRequest;
import dev.akinaksoy.tobetobootcampproject.business.response.create.CreateApplicantResponse;

public interface ApplicantService {
    CreateApplicantResponse createApplicant(
            CreateApplicantRequest request);
}