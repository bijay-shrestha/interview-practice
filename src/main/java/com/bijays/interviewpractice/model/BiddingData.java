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

    private Double bidPrice;

    @OneToOne
    @JoinColumn(name = "offer_data", nullable = false)
    private OfferData offerData;

}
