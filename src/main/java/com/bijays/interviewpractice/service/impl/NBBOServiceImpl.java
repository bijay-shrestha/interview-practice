package com.bijays.interviewpractice.service.impl;

import com.bijays.interviewpractice.service.BiddingDataService;
import com.bijays.interviewpractice.service.NBBOService;
import com.bijays.interviewpractice.service.OfferDataService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NBBOServiceImpl implements NBBOService {

    private final BiddingDataService biddingDataService;
    private final OfferDataService offerDataService;

    public NBBOServiceImpl(BiddingDataService biddingDataService,
                           OfferDataService offerDataService) {
        this.biddingDataService = biddingDataService;
        this.offerDataService = offerDataService;
    }

    @Override
    public String getNBBO(LocalDateTime localDateTime) {
        Double bestBid = biddingDataService.getBestBid(localDateTime);
        Double bestOffer = offerDataService.getBestOffer(localDateTime);
        return bestBid + " @ " + bestOffer;
    }
}
