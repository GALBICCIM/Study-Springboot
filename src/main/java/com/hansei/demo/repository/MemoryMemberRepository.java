package com.hansei.demo.repository;

import com.hansei.demo.domain.Member;
import com.hansei.demo.service.MemberService;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {
    private static Map<Integer, Member> store = new HashMap<>();
    private static int sequence = 0;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(int id) {
        /*
        Optional은 java 8부터 도입된 클래스로, 값의 부재를 더 안전하게 처리할 수 있게 함.
        Optional을 사용하면 null을 반환하는 대신 Optional.empty()를 반환함.
         */
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream().filter(member -> member.getName().equals(name)).findAny();
    }

    @Override
    public Optional<Member> deleteById(int id) {
        store.remove(id);
        return Optional.empty();
    }

    @Override
    public Optional<Member> updateByName(String oldName, String newName) {
        Optional<Member> optionalMember = store.values().stream().filter(member -> member.getName().equals(oldName)).findFirst();

        optionalMember.ifPresent(member -> {
            member.setName(newName);
            store.put(member.getId(), member);
        });

        return optionalMember;
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }


    public void clearStore() {
        store.clear();
    }
}
