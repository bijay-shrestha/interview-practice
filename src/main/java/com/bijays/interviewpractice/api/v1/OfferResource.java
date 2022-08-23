package com.bijays.interviewpractice.api.v1;

import com.bijays.interviewpractice.service.BiddingDataService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/offer")
public class OfferResource {

    private final BiddingDataService biddingDataService;

    public OfferResource(BiddingDataService biddingDataService) {
        this.biddingDataService = biddingDataService;
    }

    @GetMapping("/best")
    public ResponseEntity<Double> getBestOffer(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                                   @RequestParam LocalDateTime dateTime){
        return ResponseEntity.ok(biddingDataService.getBestOffer(dateTime));
    }
}
