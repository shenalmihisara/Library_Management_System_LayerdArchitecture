package service.impl;

import repository.MemberRepository;
import service.DeleteMemberService;

public class DeleteMemberServiceImpl implements DeleteMemberService {

    MemberRepository memberRepository = new MemberRepository();

    @Override
    public boolean deleteMember(String memberName, Long memberId) {
        return memberRepository.deleteMember(memberName, memberId);
    }
}
