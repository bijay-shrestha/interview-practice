package com.bijays.interviewpractice.utils;

import com.bijays.interviewpractice.dto.request.BiddingRequestDTO;
import com.bijays.interviewpractice.dto.response.BiddingResponseDTO;
import com.bijays.interviewpractice.model.BiddingData;
import com.bijays.interviewpractice.model.Broker;
import com.bijays.interviewpractice.model.Company;

import java.util.Optional;

public class BiddingUtils {

    public static BiddingResponseDTO parseBiddingDataToBiddingResponseDTO(BiddingData biddingData){
        BiddingResponseDTO response = new BiddingResponseDTO();
        response.setBidTime(biddingData.getBidTime());
        response.setCompanyId(biddingData.getCompany().getId());
        response.setBrokerId(biddingData.getBroker().getId());
        response.setBid(biddingData.getBid());
        response.setOffer(biddingData.getOffer());
        response.setMessage("Bid successful!");

        return response;
    }

    public static BiddingData parseBiddingRequestDTOToBidding(BiddingRequestDTO biddingRequestDTO,
                                                         Company company,
                                                         Broker broker){
        BiddingData biddingData = new BiddingData();
        biddingData.setBidTime(biddingRequestDTO.getBidTime());
        biddingData.setCompany(company);
        biddingData.setBroker(broker);
        biddingData.setBid(biddingRequestDTO.getBid());
        biddingData.setOffer(biddingRequestDTO.getOffer());
        return biddingData;
    }
}
