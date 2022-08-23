package com.bijays.interviewpractice.service;

import com.bijays.interviewpractice.dto.request.BiddingRequestDTO;
import com.bijays.interviewpractice.dto.response.BiddingResponseDTO;

import java.time.LocalDateTime;

public interface BiddingDataService {
    BiddingResponseDTO bid(BiddingRequestDTO biddingRequestDTO);

    Double getBestBid(LocalDateTime localDateTime);

    Double getBestOffer(LocalDateTime localDateTime);

    String getNBBO(LocalDateTime localDateTime);
}
