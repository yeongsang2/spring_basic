package com.hello.core;

import com.hello.core.member.Grade;
import com.hello.core.member.Member;
import com.hello.core.member.MemberService;
import com.hello.core.member.MemberServiceImpl;
import com.hello.core.order.Order;
import com.hello.core.order.OrderService;
import com.hello.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {

        AppConfig appConfig= new AppConfig();
        OrderService orderService = appConfig.orderService();
        MemberService memberService = appConfig.memberService();

        Long memberId = 1l;
        Member member = new Member(memberId,"memberA", Grade.VIP );

        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 100000);

        System.out.println("order = " + order);
        //System.out.println(order.calculatePrice());
    }
}
