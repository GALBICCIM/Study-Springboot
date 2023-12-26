package com.hansei.demo.service;

import com.hansei.demo.domain.Member;
import com.hansei.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    // private final MemberRepository memberRepository = new MemoryMemberRepository();


    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


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


    public Optional<Member> deleteById(int memberId) {
        return memberRepository.deleteById(memberId);
    }


    public Optional<Member> updateById(String oldName, String newName) {
        return memberRepository.updateByName(oldName, newName);
    }
}
