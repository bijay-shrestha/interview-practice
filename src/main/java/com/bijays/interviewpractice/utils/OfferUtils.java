package com.bijays.interviewpractice.utils;

import com.bijays.interviewpractice.dto.request.BiddingRequestDTO;
import com.bijays.interviewpractice.dto.request.OfferRequestDTO;
import com.bijays.interviewpractice.dto.response.BiddingResponseDTO;
import com.bijays.interviewpractice.dto.response.OfferResponseDTO;
import com.bijays.interviewpractice.model.BiddingData;
import com.bijays.interviewpractice.model.Broker;
import com.bijays.interviewpractice.model.Company;
import com.bijays.interviewpractice.model.OfferData;

public class OfferUtils {

    public static OfferResponseDTO parseOfferDataToOfferResponseDTO(OfferData offerData){
        OfferResponseDTO response = new OfferResponseDTO();
        response.setOfferId(offerData.getId());
        response.setBidTime(offerData.getDateTime());
        response.setOffer(offerData.getOfferPrice());
        response.setMessage("Offer of  "+ offerData.getOfferPrice()+ " placed successful!");

        return response;
    }

    public static OfferData parseOfferRequestDTOToOfferData(OfferRequestDTO offerRequestDTO,
                                                            Company company,
                                                            Broker broker){
        OfferData offer = new OfferData();
        offer.setDateTime(offerRequestDTO.getBidTime());
        offer.setCompany(company);
        offer.setBroker(broker);
        offer.setOfferPrice(offerRequestDTO.getOffer());
        return offer;
    }
}
