package com.hello.core.discount;

import com.hello.core.member.Grade;
import com.hello.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();


    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 함")
    void vip_o(){

        //given
        Member vip = new Member(1l ,"memberVIP", Grade.VIP);

        //when
        int discount = discountPolicy.discount(vip, 10000);
        //then

        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인 적용x")
    void vip_x(){

        //given
        Member member = new Member(1l ,"memberBASIC", Grade.BASIC);

        //when
        int discount = discountPolicy.discount(member, 10000);
        //then

        assertThat(discount).isEqualTo(1000);
    }

}