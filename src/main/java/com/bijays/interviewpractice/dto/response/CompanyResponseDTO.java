package com.bijays.interviewpractice.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CompanyResponseDTO implements Serializable {
    private String name;
    private String address;
    private String message;
}
