package com.bijays.interviewpractice.service.impl;

import com.bijays.interviewpractice.dto.request.BiddingRequestDTO;
import com.bijays.interviewpractice.dto.response.BiddingResponseDTO;
import com.bijays.interviewpractice.exception.DataNotFoundException;
import com.bijays.interviewpractice.model.BiddingData;
import com.bijays.interviewpractice.model.Broker;
import com.bijays.interviewpractice.model.Company;
import com.bijays.interviewpractice.model.OfferData;
import com.bijays.interviewpractice.repository.BiddingDataRepository;
import com.bijays.interviewpractice.repository.OfferDataRepository;
import com.bijays.interviewpractice.service.BiddingDataService;
import com.bijays.interviewpractice.utils.BiddingUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class BiddingDataServiceImpl implements BiddingDataService {

    private final BiddingDataRepository biddingDataRepository;
    private final OfferDataRepository offerDataRepository;

    public BiddingDataServiceImpl(BiddingDataRepository biddingDataRepository,
                                  OfferDataRepository offerDataRepository) {
        this.biddingDataRepository = biddingDataRepository;
        this.offerDataRepository = offerDataRepository;
    }

    @Override
    public BiddingResponseDTO bid(BiddingRequestDTO biddingRequestDTO) throws DataNotFoundException {
        Optional<OfferData> offerData = Optional.of(
                offerDataRepository.findById(biddingRequestDTO.getOfferId())
                        .orElseThrow(() -> new DataNotFoundException("Offer Data Not Found")));

        BiddingData biddingData = BiddingUtils.parseBiddingRequestDTOToBidding(
                biddingRequestDTO,
                offerData.get());
        biddingData = biddingDataRepository.save(biddingData);
        return BiddingUtils.parseBiddingDataToBiddingResponseDTO(biddingData);
    }

    @Override
    public Double getBestBid(LocalDateTime localDateTime) {
        Collection<BiddingData> biddingDataList =
                biddingDataRepository.getBiddingDataQueryByDateTime(localDateTime);
        List<Double> bids = new ArrayList<>();
        biddingDataList.stream().map(bid->bids.add(bid.getBidPrice())).collect(Collectors.toList());
        return bids.stream().max(Comparator.naturalOrder()).get();
    }

}
