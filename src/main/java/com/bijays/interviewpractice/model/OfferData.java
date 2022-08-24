package com.bijays.interviewpractice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "offer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OfferData implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Company company;

    @ManyToOne
    private Broker broker;

    private LocalDateTime dateTime;

    private Double offerPrice;

    public OfferData(Company company, Broker broker, LocalDateTime dateTime, Double offerPrice) {
        this.company = company;
        this.broker = broker;
        this.dateTime = dateTime;
        this.offerPrice = offerPrice;
    }
}
