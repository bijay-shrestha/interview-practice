package com.bijays.interviewpractice.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CompanyRequestDTO implements Serializable {
    private String name;
    private String address;
}
