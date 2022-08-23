package com.bijays.interviewpractice.service.impl;

import com.bijays.interviewpractice.dto.request.BrokerRequestDTO;
import com.bijays.interviewpractice.dto.response.BrokerResponseDTO;
import com.bijays.interviewpractice.model.Broker;
import com.bijays.interviewpractice.repository.BrokerRepository;
import com.bijays.interviewpractice.service.BrokerService;
import com.bijays.interviewpractice.utils.BrokerUtils;
import org.springframework.stereotype.Service;

import static com.bijays.interviewpractice.utils.BrokerUtils.parseBrokerToBrokerResponseDTO;

@Service
public class BrokerServiceImpl implements BrokerService {

    private final BrokerRepository brokerRepository;

    public BrokerServiceImpl(BrokerRepository brokerRepository) {
        this.brokerRepository = brokerRepository;
    }

    @Override
    public BrokerResponseDTO addBroker(BrokerRequestDTO brokerRequestDTO) {
        Broker broker = BrokerUtils.parseBrokerRequestDTOToBroker(brokerRequestDTO);
        return parseBrokerToBrokerResponseDTO(brokerRepository.save(broker));
    }
}
