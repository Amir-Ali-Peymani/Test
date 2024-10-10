package com.example.test.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;


@Entity
@Table(name = "body")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Body {
    @Id
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @JsonProperty("BodyId")
    private UUID BodyId;

    @JsonProperty("BodyIdNumber")
    @Column(name = "body_id_number")
    private int BodyIdNumber;

    @Column(name = "name")
    private String name;

}