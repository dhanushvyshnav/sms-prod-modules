package com.es.sms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "module")
public class Modules {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer moduleId;
    @ManyToMany(mappedBy = "modules")
    private Set<Product> products;
    private String  moduleDesc;
    private String  startdate;
    private String enddate;
}
