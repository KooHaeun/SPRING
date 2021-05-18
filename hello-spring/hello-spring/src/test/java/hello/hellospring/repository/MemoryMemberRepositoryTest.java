package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();


    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }
    @Test
    public void save(){
        Member mem = new Member();
        mem.setName("Koo");

        repository.save(mem);
        Member result = repository.findById(mem.getId()).get();
        assertThat(result).isEqualTo(mem);
    }

    @Test
    public void findByName(){
        Member mem1 = new Member();
        mem1.setName("Koo1");
        repository.save(mem1);

        Member mem2 = new Member();
        mem2.setName("Koo2");
        repository.save(mem2);

        Member result = repository.findByName("Koo1").get();
        assertThat(result).isEqualTo(mem1);
    }
    @Test
    public void findAll(){
        Member mem1 = new Member();
        mem1.setName("Koo1");
        repository.save(mem1);

        Member mem2 = new Member();
        mem2.setName("Koo2");
        repository.save(mem2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }

}
