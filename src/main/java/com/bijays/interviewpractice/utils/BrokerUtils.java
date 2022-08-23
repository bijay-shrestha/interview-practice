package com.bijays.interviewpractice.utils;

import com.bijays.interviewpractice.dto.request.BrokerRequestDTO;
import com.bijays.interviewpractice.dto.response.BrokerResponseDTO;
import com.bijays.interviewpractice.model.Broker;

public class BrokerUtils {
    public static BrokerResponseDTO parseBrokerToBrokerResponseDTO(Broker broker){
        BrokerResponseDTO response = new BrokerResponseDTO();
        response.setName(broker.getName());
        response.setCode(broker.getCode());
        response.setMessage("Broker created successfully!");

        return response;
    }

    public static Broker parseBrokerRequestDTOToBroker(BrokerRequestDTO brokerRequestDTO){
        Broker broker = new Broker();
        broker.setName(brokerRequestDTO.getName());
        broker.setCode(brokerRequestDTO.getCode());
        return broker;
    }
}
