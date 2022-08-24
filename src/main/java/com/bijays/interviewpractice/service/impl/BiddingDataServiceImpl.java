package com.bijays.interviewpractice.service.impl;

import com.bijays.interviewpractice.dto.request.BiddingRequestDTO;
import com.bijays.interviewpractice.dto.response.BiddingResponseDTO;
import com.bijays.interviewpractice.exception.DataNotFoundException;
import com.bijays.interviewpractice.model.BiddingData;
import com.bijays.interviewpractice.model.Broker;
import com.bijays.interviewpractice.model.Company;
import com.bijays.interviewpractice.repository.BiddingDataRepository;
import com.bijays.interviewpractice.repository.BrokerRepository;
import com.bijays.interviewpractice.repository.CompanyRepository;
import com.bijays.interviewpractice.service.BiddingDataService;
import com.bijays.interviewpractice.utils.BiddingUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class BiddingDataServiceImpl implements BiddingDataService {

    private final BiddingDataRepository biddingDataRepository;
    private final CompanyRepository companyRepository;
    private final BrokerRepository brokerRepository;

    public BiddingDataServiceImpl(BiddingDataRepository biddingDataRepository,
                                  CompanyRepository companyRepository,
                                  BrokerRepository brokerRepository) {
        this.biddingDataRepository = biddingDataRepository;
        this.companyRepository = companyRepository;
        this.brokerRepository = brokerRepository;
    }

    @Override
    public BiddingResponseDTO bid(BiddingRequestDTO biddingRequestDTO) throws DataNotFoundException {
        Optional<Company> company = Optional.of(
                companyRepository.findById(biddingRequestDTO.getCompanyId())
                        .orElseThrow(() -> new DataNotFoundException("Company Data Not Found")));

        Optional<Broker> broker = Optional.of(
                brokerRepository.findById(biddingRequestDTO.getBrokerId())
                        .orElseThrow(() -> new DataNotFoundException("Broker Data Not Found")));

        BiddingData biddingData = BiddingUtils.parseBiddingRequestDTOToBidding(
                biddingRequestDTO,
                company.get(),
                broker.get());
        biddingData = biddingDataRepository.save(biddingData);
        return BiddingUtils.parseBiddingDataToBiddingResponseDTO(biddingData);
    }

    @Override
    public Double getBestBid(LocalDateTime localDateTime) {
        Collection<BiddingData> biddingDataList = biddingDataRepository.getBiddingDataQueryByDateTime(localDateTime);
        List<Double> bids = new ArrayList<>();
        biddingDataList.stream().map(bid->bids.add(bid.getBidPrice())).collect(Collectors.toList());
        return bids.stream().max(Comparator.naturalOrder()).get();
    }

}
