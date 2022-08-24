package com.bijays.interviewpractice.repository;

import com.bijays.interviewpractice.model.BiddingData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Collection;

@Repository
public interface BiddingDataRepository extends JpaRepository<BiddingData, Long> {
    @Query(value = "SELECT b FROM BiddingData b WHERE b.offerData.dateTime=:dateTime")
    Collection<BiddingData> getBiddingDataQueryByDateTime(LocalDateTime dateTime);
}
