package com.hansei.demo.repository;

import com.hansei.demo.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);

    Optional<Member> findById(int id);

    Optional<Member> findByName(String name);

    Optional<Member> deleteById(int id);

    Optional<Member> updateByName(String oldName, String newName);

    List<Member> findAll();
}
