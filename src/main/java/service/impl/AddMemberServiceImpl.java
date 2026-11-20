package service.impl;

import db.dbConnection;
import jakarta.transaction.Transaction;
import javafx.scene.control.Alert;
import model.dto.MemberDTO;
import model.entity.MemberEntity;
import repository.MemberRepository;
import service.AddMemberService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddMemberServiceImpl implements AddMemberService {


    MemberRepository memberRepository = new MemberRepository();

    public boolean addMembers(MemberDTO memberDTO) {
        return memberRepository.addMember(memberDTO);
    }
}
