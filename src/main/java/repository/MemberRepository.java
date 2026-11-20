package repository;

import db.HibernateUtill;
import model.dto.MemberDTO;
import model.entity.MemberEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MemberRepository {

    Session session = HibernateUtill.getSession();

    public boolean addMember(MemberDTO memberDTO) {
        MemberEntity memberEntity = new MemberEntity();

        Transaction transaction = session.beginTransaction();

        memberEntity.setName(memberDTO.getFullName());
        memberEntity.setEmail(memberDTO.getEmail());
        memberEntity.setPhoneNumber(memberDTO.getPhoneNumber());
        memberEntity.setAddress(memberDTO.getAddress());

        session.persist(memberEntity);
        transaction.commit();

        System.out.println("id" + memberEntity.getMemberId());

        return true;
    }
}
