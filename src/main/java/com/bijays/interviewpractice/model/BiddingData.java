package com.bijays.interviewpractice.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "biding_data")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BiddingData implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bid_time")
    private LocalDateTime bidTime;

    @ManyToOne
    private Company company;

    @ManyToOne
    private Broker broker;

    private Double bid;

    private Double offer;

    public BiddingData(LocalDateTime bidTime, Company company, Broker broker, Double bid, Double offer) {
        this.bidTime = bidTime;
        this.company = company;
        this.broker = broker;
        this.bid = bid;
        this.offer = offer;
    }
}
