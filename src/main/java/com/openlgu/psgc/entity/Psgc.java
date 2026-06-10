package com.openlgu.psgc.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("psgc")
public class Psgc {
    @Id
    private String id;



}
