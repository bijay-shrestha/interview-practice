package com.bijays.interviewpractice.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "company")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Company implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Company name cannot be null")
    @NotBlank(message = "Company name cannot be left blank")
    @NotEmpty(message = "Company name cannot be empty")
    private String name;

    @Column(nullable = true)
    private String address;

    public Company(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
