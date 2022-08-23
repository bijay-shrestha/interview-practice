package com.bijays.interviewpractice.service;

import com.bijays.interviewpractice.dto.request.BrokerRequestDTO;
import com.bijays.interviewpractice.dto.response.BrokerResponseDTO;

public interface BrokerService {
    BrokerResponseDTO addBroker(BrokerRequestDTO brokerRequestDTO);
}
