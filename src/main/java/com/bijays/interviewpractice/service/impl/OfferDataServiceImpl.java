package com.bijays.interviewpractice.service.impl;

import com.bijays.interviewpractice.dto.request.OfferRequestDTO;
import com.bijays.interviewpractice.dto.response.OfferResponseDTO;
import com.bijays.interviewpractice.exception.DataNotFoundException;
import com.bijays.interviewpractice.model.Broker;
import com.bijays.interviewpractice.model.Company;
import com.bijays.interviewpractice.model.OfferData;
import com.bijays.interviewpractice.repository.BrokerRepository;
import com.bijays.interviewpractice.repository.CompanyRepository;
import com.bijays.interviewpractice.repository.OfferDataRepository;
import com.bijays.interviewpractice.service.OfferDataService;
import com.bijays.interviewpractice.utils.OfferUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class OfferDataServiceImpl implements OfferDataService {

    private final OfferDataRepository offerDataRepository;
    private final CompanyRepository companyRepository;
    private final BrokerRepository brokerRepository;

    public OfferDataServiceImpl(OfferDataRepository offerDataRepository,
                                CompanyRepository companyRepository,
                                BrokerRepository brokerRepository) {
        this.offerDataRepository = offerDataRepository;
        this.companyRepository = companyRepository;
        this.brokerRepository = brokerRepository;
    }

    @Override
    public Double getBestOffer(LocalDateTime localDateTime) {
        Collection<OfferData> offerDataList = offerDataRepository.findByDateTime(localDateTime);
        List<Double> offers = new ArrayList<>();
        offerDataList.stream().map(offer->offers.add(offer.getOfferPrice())).collect(Collectors.toList());
        return offers.stream().max(Comparator.naturalOrder()).get();
    }

    @Override
    public OfferResponseDTO addOffer(OfferRequestDTO offerRequestDTO) {
        Optional<Company> company = Optional.of(
                companyRepository.findById(offerRequestDTO.getCompanyId())
                        .orElseThrow(() -> new DataNotFoundException("Company Data Not Found")));

        Optional<Broker> broker = Optional.of(
                brokerRepository.findById(offerRequestDTO.getBrokerId())
                        .orElseThrow(() -> new DataNotFoundException("Broker Data Not Found")));
        Optional<OfferData> offerData = Optional.of(
                offerDataRepository.save(
                        OfferUtils.parseOfferRequestDTOToOfferData(
                                offerRequestDTO, company.get(), broker.get())));
        return OfferUtils.parseOfferDataToOfferResponseDTO(offerData.get());
    }


}
