package com.cpe.wongnai.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
@Table(name = "nutrition")
public class Nutrition {
    @Id @GeneratedValue
    private Long Nid;
    private String protein;
    private String carbohydrate;
    private String vitamin;
    private String fruit;
    private String fat;
}