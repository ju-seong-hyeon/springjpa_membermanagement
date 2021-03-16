package hello.hellospring;

import hello.hellospring.Service.MemberService;
import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }
    //*
    //@Bean
    //public TimeTraceAop timeTraceAop(){
    //    return new TimeTraceAop();
    //}
    //
    //@Bean
    //public MemberRepository memberRepository(){
        //return new MemoryMemberRepository();
        //return new JpaMemberRepository(em);



}