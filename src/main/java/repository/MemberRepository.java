package repository;

import db.HibernateUtill;
import model.dto.MemberDTO;
import model.entity.MemberEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class MemberRepository {

    Session session = HibernateUtill.getSession();
    MemberEntity memberEntity = new MemberEntity();

    public boolean addMember(MemberDTO memberDTO) {

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

    public List<MemberEntity> getAllBooks() {

        String HQL = "FROM MemberEntity";

        List<MemberEntity> list = session.createQuery(HQL, MemberEntity.class).list();

        return list;

    }
}
