package com.example.featureflag.change_repository_example.adapter.out.oracle.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "TABLE_NAME", schema = "TABLE_SCHEMA")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class WoEntityFTFPTIXXX1 {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR_WO")
    @SequenceGenerator(allocationSize = 1, name = "SEQ_GENERATOR_WO", sequenceName = "SEQ_WO")
    private Integer id;

    @Column(name = "BUSINESS_ID")
    private String businessId;

    @Column(name = "NEW_PROP")
    private String newProp;
}