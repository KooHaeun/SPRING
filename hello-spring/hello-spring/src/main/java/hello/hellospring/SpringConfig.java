package hello.hellospring;

import hello.hellospring.aop.TimeTraceApp;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

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

   // @Bean
    //public TimeTraceApp timeTraceApp(){
      //  return new TimeTraceApp();
    //}

    //@Bean
    //public MemberRepository memberRepository(){
        //return new JdbcMemberRepository(dataSource);
        //return new JpaMemberRepository(em);
    //    return
   // }
}
