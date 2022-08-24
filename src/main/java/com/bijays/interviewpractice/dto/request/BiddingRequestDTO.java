package com.bijays.interviewpractice.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class BiddingRequestDTO implements Serializable {
    private Integer offerId;
    private Double bid;
}
