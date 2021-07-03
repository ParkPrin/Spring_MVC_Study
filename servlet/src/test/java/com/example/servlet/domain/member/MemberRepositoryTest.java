package com.example.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberRepositoryTest {

    MemberReponsitory memberReponsitory = MemberReponsitory.getInstance();

    @AfterEach
    void afterEach(){
        memberReponsitory.clearStore();
    }

    @Test
    void save(){
        // given
        Member member = new Member("park", 34);

        // when
        Member savedMember = memberReponsitory.save(member);

        // then
        Member findMember = memberReponsitory.findById(savedMember.getId());
        assertThat(findMember.getId()).isEqualTo(savedMember.getId());
    }

    @Test
    void findAll() {
        // given
        Member member = new Member("park", 34);
        Member member2 = new Member("kim", 31);

        memberReponsitory.save(member);
        memberReponsitory.save(member2);

        // when
        List<Member> members = memberReponsitory.findAll();

        // then
        assertThat(members.size()).isEqualTo(2);
        assertThat(members).contains(member, member2);
    }
}
