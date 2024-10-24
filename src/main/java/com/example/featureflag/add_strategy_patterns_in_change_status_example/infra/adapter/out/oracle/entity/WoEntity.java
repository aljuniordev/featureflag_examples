package com.example.featureflag.add_strategy_patterns_in_change_status_example.infra.adapter.out.oracle.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TABLE_NAME", schema = "TABLE_SCHEMA")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class WoEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR_WO")
    @SequenceGenerator(allocationSize = 1, name = "SEQ_GENERATOR_WO", sequenceName = "SEQ_WO")
    private Integer id;

    @Column(name = "BUSINESS_ID")
    private String businessId;
}
