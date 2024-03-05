package dev.akinaksoy.tobetobootcampproject.business.concretes;

import dev.akinaksoy.tobetobootcampproject.business.abstracts.BlacklistService;
import dev.akinaksoy.tobetobootcampproject.business.request.create.CreateBlacklistRequest;
import dev.akinaksoy.tobetobootcampproject.business.response.create.CreateBlacklistResponse;
import dev.akinaksoy.tobetobootcampproject.core.utilities.modelmapper.ModelMapperService;
import dev.akinaksoy.tobetobootcampproject.core.utilities.results.DataResult;
import dev.akinaksoy.tobetobootcampproject.core.utilities.results.SuccessDataResult;
import dev.akinaksoy.tobetobootcampproject.dataaaccess.BlacklistRepository;
import dev.akinaksoy.tobetobootcampproject.entities.Blacklist;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class BlacklistManager implements BlacklistService {
    private ModelMapperService mapperService;
    private BlacklistRepository blacklistRepository;
    @Override
    public DataResult<CreateBlacklistResponse> createBlacklist(
            CreateBlacklistRequest request
    ) {
        Blacklist blacklist = mapperService.forRequest()
                .map(request,Blacklist.class);

        blacklist.setCreatedDate(LocalDateTime.now());

        blacklistRepository.save(blacklist);

        CreateBlacklistResponse response = mapperService.forResponse()
                .map(blacklist,CreateBlacklistResponse.class);

        return new SuccessDataResult
                <CreateBlacklistResponse>
                (response,"Blacklist created successfully.");

    }
}
