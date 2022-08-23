package com.bijays.interviewpractice.service.impl;

import com.bijays.interviewpractice.dto.request.CompanyRequestDTO;
import com.bijays.interviewpractice.dto.response.CompanyResponseDTO;
import com.bijays.interviewpractice.model.Company;
import com.bijays.interviewpractice.repository.CompanyRepository;
import com.bijays.interviewpractice.service.CompanyService;
import com.bijays.interviewpractice.utils.CompanyUtils;
import org.springframework.stereotype.Service;

import static com.bijays.interviewpractice.utils.CompanyUtils.parseCompanyToCompanyResponseDTO;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public CompanyResponseDTO addCompany(CompanyRequestDTO companyRequestDTO) {
        Company company = companyRepository.save(CompanyUtils.parseCompanyRequestDTOToCompany(companyRequestDTO));
        return parseCompanyToCompanyResponseDTO(company);
    }
}
