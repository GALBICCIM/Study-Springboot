package com.hansei.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "member")  // postgresql에선 테이블 이름을 user로 지을 수 없음.
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId; // user_id
    private String name;
    private String email;

    @ManyToOne
    @JoinColumn(name = "teamId")
    private Team team;


    public User() {

    }


    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
