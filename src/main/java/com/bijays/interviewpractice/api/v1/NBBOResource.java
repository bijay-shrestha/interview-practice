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
@RequestMapping(value = "/nbbo")
public class NBBOResource {

    private final BiddingDataService biddingDataService;

    public NBBOResource(BiddingDataService biddingDataService) {
        this.biddingDataService = biddingDataService;
    }

    @GetMapping
    public ResponseEntity<String> getNBBO(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                               @RequestParam LocalDateTime dateTime){
        return ResponseEntity.ok(biddingDataService.getNBBO(dateTime));
    }

}
