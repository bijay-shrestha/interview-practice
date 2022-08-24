package com.bijays.interviewpractice.repository;

import com.bijays.interviewpractice.model.OfferData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Collection;

@Repository
public interface OfferDataRepository extends JpaRepository<OfferData, Integer> {

    Collection<OfferData> findByDateTime(LocalDateTime localDateTime);
}
