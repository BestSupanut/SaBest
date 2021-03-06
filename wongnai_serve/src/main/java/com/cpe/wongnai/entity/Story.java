package com.cpe.wongnai.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
@Table(name = "story")
public class Story {
    @Id 
        @SequenceGenerator(name = "story_seq",sequenceName = "story_seq")
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "story_seq")
    @Column(name = "Sid")
    private @NonNull Long Sid;
    @Column(length=1024)
    private String  stext;
	
}