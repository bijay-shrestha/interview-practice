package com.bijays.interviewpractice.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class BrokerResponseDTO implements Serializable {
    private String name;
    private String code;
    private String message;
}
