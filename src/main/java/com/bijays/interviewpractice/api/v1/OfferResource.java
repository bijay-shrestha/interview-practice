package com.bijays.interviewpractice.api.v1;

import com.bijays.interviewpractice.dto.request.OfferRequestDTO;
import com.bijays.interviewpractice.dto.response.OfferResponseDTO;
import com.bijays.interviewpractice.service.OfferDataService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/offer")
public class OfferResource {

    private final OfferDataService offerDataService;

    public OfferResource(OfferDataService offerDataService) {
        this.offerDataService = offerDataService;
    }

    @PostMapping
    public ResponseEntity<OfferResponseDTO> addOffer(@RequestBody OfferRequestDTO offerRequestDTO){
        return new ResponseEntity<OfferResponseDTO>(offerDataService.addOffer(offerRequestDTO), HttpStatus.CREATED);
    }


    @GetMapping("/best")
    public ResponseEntity<Double> getBestOffer(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                                   @RequestParam LocalDateTime dateTime){
        return ResponseEntity.ok(offerDataService.getBestOffer(dateTime));
    }
}
