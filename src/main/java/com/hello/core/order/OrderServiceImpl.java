package com.hello.core.order;

import com.hello.core.dicount.DiscountPolicy;
import com.hello.core.dicount.FixDiscountPolicy;
import com.hello.core.member.Member;
import com.hello.core.member.MemberRepository;
import com.hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice); //discount에 대한것은 discount에게 넘김 -> 단일 책임 원칙을 잘 지킨 사례

        return new Order(memberId, itemName, itemPrice, discountPrice);

    }
}
