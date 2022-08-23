package com.bijays.interviewpractice.api.v1;

import com.bijays.interviewpractice.dto.request.CompanyRequestDTO;
import com.bijays.interviewpractice.dto.response.CompanyResponseDTO;
import com.bijays.interviewpractice.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class CompanyResource {

    private final CompanyService companyService;

    public CompanyResource(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    public ResponseEntity<CompanyResponseDTO> addCompany(@RequestBody CompanyRequestDTO companyRequestDTO){
        return new ResponseEntity<>(companyService.addCompany(companyRequestDTO), HttpStatus.CREATED);
    }
}
