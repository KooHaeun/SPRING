package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {

    private final MemberRepository memRe;

    public MemberService(MemberRepository memRe) {
        this.memRe = memRe;
    }

    //회원 가입
    public Long join(Member mem) {
        //같은 이름 회원x
        //중복회원 검증
        validateDuplicateMember(mem);
        memRe.save(mem);
        return mem.getId();
    }

    private void validateDuplicateMember(Member mem) {
        memRe.findByName(mem.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    //전체회원조회
    public List<Member> findMembers() {
        return memRe.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memRe.findById(memberId);
    }


}
