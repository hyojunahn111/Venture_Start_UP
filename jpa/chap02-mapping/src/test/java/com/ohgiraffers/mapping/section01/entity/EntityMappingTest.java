package com.ohgiraffers.mapping.section01.entity;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.stream.Stream;

@SpringBootTest
public class EntityMappingTest {

    @Autowired
    private MemberRegistService memberRegistService;



    /*
    * [ Entity Mapping 어노테이션 ]
    * 엔티티와 테이블을 정확하게 매핑하는 것이 JPA의 핵심이다.
    * 매핑 어노테이션은 다음과 같이 크게 4가지로 분류할 수 있다.
    * 1. 객체와 테이블 매핑 (@Entity, @Table)
    * 2. 기본키 매핑 (@Id)
    * 3. 필드와 컬럼 매핑 (@Column)
    * 4. 연관관계 매핑 (@ManyToOne, @OneToMany, @ManyToMany, @OneToOne, @JoinColumn, @JoinTable)
    * */

    private static Stream<Arguments> getMember() {
        return Stream.of(
                Arguments.of(
                        1,
                        "user01",
                        "pass01",
                        "다람쥐",
                        "010-1234-5678",
                        "서울시 종로구",
                        LocalDateTime.now(),
                        "ROLE_MEMBER",
                        "Y"
                ),
                Arguments.of(
                        2,
                        "user02",
                        "pass02",
                        "호랑이",
                        "010-8765-4321",
                        "서울시 서초구",
                        LocalDateTime.now(),
                        "ROLE_ADMIN",
                        "Y"
                )
        );
    }

    @DisplayName("테이블 생성 테스트")
    @ParameterizedTest
    @MethodSource("getMember")
    void testCreateTable(int memberNo, String memberId, String memberPwd,
                         String memberName, String phone, String address,
                         LocalDateTime enrollDate, MemberRole memberRole, String status) {
        //given
        MemberRegistDTO newMember = new MemberRegistDTO(
                memberId,
                memberPwd,
                memberName,
                phone,
                address,
                enrollDate,
                memberRole,
                status
        );

        //when

        //then
        Assertions.assertDoesNotThrow(
                () -> memberRegistService.registMember(newMember)
        );

    }



    @DisplayName("프로퍼티 접근 테스트")
    @ParameterizedTest
    @MethodSource("getMember")
    void testAccessProperty(int memberNo, String memberId, String memberPwd,
                         String memberName, String phone, String address,
                         LocalDateTime enrollDate, MemberRole memberRole, String status) {
        //given
        MemberRegistDTO newMember = new MemberRegistDTO(
                memberId,
                memberPwd,
                memberName,
                phone,
                address,
                enrollDate,
                memberRole,
                status
        );

        //when
        String registedName = memberRegistService.registMemberAndFindName(newMember);

        //then
        Assertions.assertEquals(memberName + "님", registedName);
    }

}
