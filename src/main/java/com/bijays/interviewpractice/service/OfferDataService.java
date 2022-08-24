package com.bijays.interviewpractice.service;

import com.bijays.interviewpractice.dto.request.OfferRequestDTO;
import com.bijays.interviewpractice.dto.response.OfferResponseDTO;

import java.time.LocalDateTime;

public interface OfferDataService {

    Double getBestOffer(LocalDateTime localDateTime);

    OfferResponseDTO addOffer(OfferRequestDTO offerRequestDTO);
}
