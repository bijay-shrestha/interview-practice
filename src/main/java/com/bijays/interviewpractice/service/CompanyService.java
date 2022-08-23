package com.bijays.interviewpractice.service;


import com.bijays.interviewpractice.dto.request.CompanyRequestDTO;
import com.bijays.interviewpractice.dto.response.CompanyResponseDTO;

public interface CompanyService {
    CompanyResponseDTO addCompany(CompanyRequestDTO companyRequestDTO);
}
