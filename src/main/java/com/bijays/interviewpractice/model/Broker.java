package com.bijays.interviewpractice.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "broker")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Broker implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Broker name cannot be null")
    @NotBlank(message = "Broker name cannot be left blank")
    @NotEmpty(message = "Broker name cannot be empty")
    private String name;

    @NotNull(message = "Broker code cannot be null")
    @NotBlank(message = "Broker code cannot be left blank")
    @NotEmpty(message = "Broker code cannot be empty")
    private String code;

    public Broker(String name, String code) {
        this.name = name;
        this.code = code;
    }
}
