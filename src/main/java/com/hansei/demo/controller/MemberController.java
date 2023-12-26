package com.hansei.demo.controller;

import com.hansei.demo.domain.Member;
import com.hansei.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    @PostMapping("/member")
    @ResponseBody
    public Member create(@RequestBody Member member) {
        memberService.join(member);
        return member;
    }


    @GetMapping("/members")
    @ResponseBody
    public List<Member> list() {
        return memberService.findMembers();
    }
}
