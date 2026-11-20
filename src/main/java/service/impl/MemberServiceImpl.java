package service.impl;

import model.entity.MemberEntity;
import repository.MemberRepository;
import service.MemberService;
import java.util.List;

public class MemberServiceImpl implements MemberService {

    MemberRepository memberRepository = new MemberRepository();

    public List<MemberEntity> getAllMembers(){
        return memberRepository.getAllBooks();
    }
}
