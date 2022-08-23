package com.bijays.interviewpractice.api.v1;

import com.bijays.interviewpractice.dto.request.BiddingRequestDTO;
import com.bijays.interviewpractice.dto.response.BiddingResponseDTO;
import com.bijays.interviewpractice.service.BiddingDataService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/bid")
public class BiddingResource {
    private final BiddingDataService biddingDataService;

    public BiddingResource(BiddingDataService biddingDataService) {
        this.biddingDataService = biddingDataService;
    }

    @PostMapping
    public ResponseEntity<BiddingResponseDTO> bid(@RequestBody BiddingRequestDTO biddingRequestDTO){
        return new ResponseEntity<>(biddingDataService.bid(biddingRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping("/best")
    public ResponseEntity<Double> getBestBid(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @RequestParam LocalDateTime dateTime){
        return ResponseEntity.ok(biddingDataService.getBestBid(dateTime));
    }
}
