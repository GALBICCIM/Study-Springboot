package com.hansei.demo.controller;

import com.hansei.demo.domain.Member;
import com.hansei.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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


    @GetMapping("member/{id}")
    public Member getMember(@PathVariable int id) {
        return memberService.findOne(id).get();
    }


    // 사용자 삭제 API
    @DeleteMapping("/member/{id}")
    public Member deleteMember(@PathVariable int id) {
        return memberService.deleteById(id).get();
    }


//    @PutMapping("/member/{id}")
//    public Member updateMember(@RequestBody Member member) {
//
//    }
}
