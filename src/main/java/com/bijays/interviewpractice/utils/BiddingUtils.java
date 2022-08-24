package com.bijays.interviewpractice.utils;

import com.bijays.interviewpractice.dto.request.BiddingRequestDTO;
import com.bijays.interviewpractice.dto.response.BiddingResponseDTO;
import com.bijays.interviewpractice.model.BiddingData;
import com.bijays.interviewpractice.model.Broker;
import com.bijays.interviewpractice.model.Company;
import com.bijays.interviewpractice.model.OfferData;

public class BiddingUtils {

    public static BiddingResponseDTO parseBiddingDataToBiddingResponseDTO(BiddingData biddingData){
        BiddingResponseDTO response = new BiddingResponseDTO();
        response.setBidTime(biddingData.getOfferData().getDateTime());
        response.setCompanyId(biddingData.getOfferData().getCompany().getId());
        response.setBrokerId(biddingData.getOfferData().getBroker().getId());
        response.setBid(biddingData.getBidPrice());
        response.setOffer(biddingData.getOfferData().getOfferPrice());
        response.setMessage("Bid successful!");

        return response;
    }

    public static BiddingData parseBiddingRequestDTOToBidding(BiddingRequestDTO biddingRequestDTO, OfferData offerData){
        BiddingData biddingData = new BiddingData();
        biddingData.setBidPrice(biddingRequestDTO.getBid());
        biddingData.setOfferData(offerData);
        return biddingData;
    }
}
