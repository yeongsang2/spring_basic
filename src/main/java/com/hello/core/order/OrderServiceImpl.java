package com.hello.core.order;

import com.hello.core.discount.DiscountPolicy;
import com.hello.core.member.Member;
import com.hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice); //discount에 대한것은 discount에게 넘김 -> 단일 책임 원칙을 잘 지킨 사례

        return new Order(memberId, itemName, itemPrice, discountPrice);

    }
    //test용
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
