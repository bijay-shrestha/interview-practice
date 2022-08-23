package com.bijays.interviewpractice.utils;

import com.bijays.interviewpractice.dto.request.CompanyRequestDTO;
import com.bijays.interviewpractice.dto.response.CompanyResponseDTO;
import com.bijays.interviewpractice.model.Company;

public class CompanyUtils {

    public static CompanyResponseDTO parseCompanyToCompanyResponseDTO(Company company){
        CompanyResponseDTO response = new CompanyResponseDTO();
        response.setName(company.getName());
        response.setAddress(company.getAddress());
        response.setMessage("Company created successfully!");

        return response;
    }

    public static Company parseCompanyRequestDTOToCompany(CompanyRequestDTO companyRequestDTO){
        Company company = new Company();
        company.setName(companyRequestDTO.getName());
        company.setAddress(companyRequestDTO.getAddress());
        return company;
    }
}
