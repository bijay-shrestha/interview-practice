package com.bijays.interviewpractice.api.v1;

import com.bijays.interviewpractice.dto.request.BrokerRequestDTO;
import com.bijays.interviewpractice.dto.response.BrokerResponseDTO;
import com.bijays.interviewpractice.service.BrokerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/broker")
public class BrokerResource {

    private final BrokerService brokerService;

    public BrokerResource(BrokerService brokerService) {
        this.brokerService = brokerService;
    }

    @PostMapping
    private ResponseEntity<BrokerResponseDTO> addBroker(@RequestBody BrokerRequestDTO brokerRequestDTO){
        return new ResponseEntity<>(brokerService.addBroker(brokerRequestDTO), HttpStatus.CREATED);
    }
}
