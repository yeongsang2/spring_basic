package com.hello.core.order;

import com.hello.core.member.Grade;
import com.hello.core.member.Member;
import com.hello.core.member.MemberService;
import com.hello.core.member.MemberServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1l;
        Member member = new Member(memberId,"memberA", Grade.VIP );

        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 100000);

        System.out.println("order = " + order);
        //System.out.println(order.calculatePrice());
    }
}
