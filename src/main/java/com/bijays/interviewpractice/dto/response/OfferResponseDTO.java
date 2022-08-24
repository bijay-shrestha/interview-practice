package com.bijays.interviewpractice.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class OfferResponseDTO implements Serializable {
    private Integer offerId;
    private LocalDateTime bidTime;
    private Double offer;
    private String message;
}
