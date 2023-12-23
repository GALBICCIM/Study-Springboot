package com.hansei.demo.service;

import com.hansei.demo.domain.Member;
import com.hansei.demo.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRepository memberRepository;;


    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService();
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }


    @Test
    public void 회원가입() {
        Member member = new Member();
        member.setName("hello");

        int saveId = memberService.join(member);

        Member findMember = memberRepository.findById(saveId).get();
        assertEquals(member.getName(), findMember.getName());
    }


    @Test
    public void 중복_회원_예외() {
        Member member1 = new Member();
        member1.setName("hello");

        Member member2 = new Member();
        member2.setName("hello");

        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertEquals("이미 존재하는 회원입니다.", e.getMessage());
    }
}
