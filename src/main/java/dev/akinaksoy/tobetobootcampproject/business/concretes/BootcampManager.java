package dev.akinaksoy.tobetobootcampproject.business.concretes;

import dev.akinaksoy.tobetobootcampproject.business.abstracts.BootcampService;
import dev.akinaksoy.tobetobootcampproject.business.request.create.CreateBootcampRequest;
import dev.akinaksoy.tobetobootcampproject.business.request.update.UpdateBootcampRequest;
import dev.akinaksoy.tobetobootcampproject.business.response.create.CreateBootcampResponse;
import dev.akinaksoy.tobetobootcampproject.business.response.get.GetAllBootcampResponse;
import dev.akinaksoy.tobetobootcampproject.business.response.get.GetBootcampByIdResponse;
import dev.akinaksoy.tobetobootcampproject.business.response.update.UpdateBootcampResponse;
import dev.akinaksoy.tobetobootcampproject.core.utilities.modelmapper.ModelMapperService;
import dev.akinaksoy.tobetobootcampproject.core.utilities.paging.PageDto;
import dev.akinaksoy.tobetobootcampproject.core.utilities.results.DataResult;
import dev.akinaksoy.tobetobootcampproject.core.utilities.results.Result;
import dev.akinaksoy.tobetobootcampproject.core.utilities.results.SuccessDataResult;
import dev.akinaksoy.tobetobootcampproject.core.utilities.results.SuccessResult;
import dev.akinaksoy.tobetobootcampproject.dataaaccess.BootcampRepository;
import dev.akinaksoy.tobetobootcampproject.entities.Bootcamp;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BootcampManager implements BootcampService {
    private BootcampRepository bootcampRepository;
    private ModelMapperService mapperService;
    @Override
    public DataResult<CreateBootcampResponse> createBootcamp(
            CreateBootcampRequest request
    ) {
        Bootcamp bootcamp = mapperService.forRequest()
                .map(request,Bootcamp.class);

        bootcamp.setCreatedDate(LocalDateTime.now());

        bootcampRepository.save(bootcamp);

        CreateBootcampResponse response = mapperService.forResponse()
                .map(bootcamp, CreateBootcampResponse.class);

        return new SuccessDataResult
                <CreateBootcampResponse>
                (response,"Bootcamp created successfully.");
    }

    @Override
    public SuccessDataResult<List<GetAllBootcampResponse>> getAllBootcamp() {
        List <Bootcamp> bootcamps = bootcampRepository.findAll();

        List<GetAllBootcampResponse> response = bootcamps.stream()
                .map(bootcamp -> mapperService.forResponse()
                .map(bootcamp, GetAllBootcampResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult
                <List<GetAllBootcampResponse>>
                (response, "All Bootcamps Listed");
    }

    @Override
    public DataResult<GetBootcampByIdResponse> getBootcampById(
            int id
    ) {
        Bootcamp bootcamp = bootcampRepository.findById(id).orElseThrow();

        GetBootcampByIdResponse response = mapperService.forResponse()
                .map(bootcamp, GetBootcampByIdResponse.class);

        return new SuccessDataResult
                <GetBootcampByIdResponse>
                (response, "Bootcamp Listed");
    }

    @Override
    public DataResult<UpdateBootcampResponse> updateBootcamp(
            UpdateBootcampRequest request
    ) {
        Bootcamp bootcamp = mapperService.forRequest().map(request, Bootcamp.class);

        Bootcamp updatedBootcamp = bootcampRepository.save(bootcamp);

        UpdateBootcampResponse response = mapperService.forResponse()
                .map(updatedBootcamp, UpdateBootcampResponse.class);

        return new SuccessDataResult
                <UpdateBootcampResponse>
                (response, "Bootcamp Updated");
    }

    @Override
    public DataResult<List<GetAllBootcampResponse>> getAllSorted(
            PageDto pageDto
    ) {
        Sort sort = Sort.by(Sort.Direction.fromString
                (pageDto.getSortDirection()), pageDto.getSortBy());

        Pageable pageable = PageRequest.of
                (pageDto.getPageNumber(), pageDto.getPageSize(), sort);

        Page<Bootcamp> bootcamps = bootcampRepository.findAll(pageable);

        List <GetAllBootcampResponse> response = bootcamps.stream()
                .map(bootcamp -> mapperService.forResponse()
                .map(bootcamp, GetAllBootcampResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult
                <List<GetAllBootcampResponse>>
                (response, "All Bootcamps Sorted");
    }

    @Override
    public Result deleteBootcamp(
            int id
    ) {
        bootcampRepository.deleteById(id);
        return new SuccessResult("Bootcamp Deleted");
    }

}
