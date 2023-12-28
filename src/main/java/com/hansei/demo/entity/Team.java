package com.hansei.demo.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "team")
@Getter
@Setter
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teamId;  // team_id
    private String name;
    private String category;


    public Team() {
    }


    public Team(String name, String category) {
        this.name = name;
        this.category = category;
    }
}
