package com.bijays.interviewpractice.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class OfferRequestDTO implements Serializable {
    private LocalDateTime bidTime;
    private Integer companyId;
    private Integer brokerId;
    private Double offer;
}
