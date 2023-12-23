package com.hansei.demo.service;

import com.hansei.demo.domain.Member;
import com.hansei.demo.repository.MemberRepository;
import com.hansei.demo.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();


    public int join(Member member) {
        validateDuplicateMember(member);  // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }


    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()).ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }


    public List<Member> findMembers() {
        return memberRepository.findAll();
    }


    public Optional<Member> findOne(int memberId) {
        return memberRepository.findById(memberId);
    }
}
