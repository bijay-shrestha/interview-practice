package com.bijays.interviewpractice.repository;

import com.bijays.interviewpractice.model.Broker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrokerRepository extends JpaRepository<Broker, Integer> {
}
