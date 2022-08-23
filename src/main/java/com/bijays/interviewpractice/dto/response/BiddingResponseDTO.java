package com.bijays.interviewpractice.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class BiddingResponseDTO implements Serializable {
    private LocalDateTime bidTime;
    private Integer companyId;
    private Integer brokerId;
    private Double bid;
    private Double offer;
    private String message;
}

