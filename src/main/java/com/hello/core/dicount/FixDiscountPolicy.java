package com.hello.core.dicount;

import com.hello.core.member.Grade;
import com.hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            //enum은 == 쓰는게 맞음
            return discountFixAmount;
        }else {
            return 0;
        }
    }
}
