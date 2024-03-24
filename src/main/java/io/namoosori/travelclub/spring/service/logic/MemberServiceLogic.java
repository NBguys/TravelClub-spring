package io.namoosori.travelclub.spring.service.logic;

import java.util.List;

import org.springframework.stereotype.Service;

import io.namoosori.travelclub.spring.aggregate.club.CommunityMember;
import io.namoosori.travelclub.spring.service.MemberService;
import io.namoosori.travelclub.spring.service.sdo.MemberCdo;
import io.namoosori.travelclub.spring.shared.NameValueList;
import io.namoosori.travelclub.spring.store.MemberStore;
import io.namoosori.travelclub.spring.util.exception.NoSuchMemberException;

@Service
public class MemberServiceLogic implements MemberService{

    MemberStore memberStore;

    public MemberServiceLogic(MemberStore memberStore) {
        this.memberStore = memberStore;
    }

    @Override
    public String registerMember(MemberCdo member) {
        String email = member.getEmail();
        CommunityMember foundedMember = memberStore.retrieveByEmail(email);
        if(foundedMember != null) {
            throw new NoSuchMemberException("Member already exiss with emial : " + email);
        }

        foundedMember = new CommunityMember(member.getEmail(), member.getName(), member.getPhoneNumber());
        foundedMember.setNickName(member.getNickName());
        foundedMember.setBirthDay(member.getBirthDay());

        foundedMember.checkValidation();

        memberStore.create(foundedMember);

        return foundedMember.getId();
    }

    @Override
    public CommunityMember findMemberById(String memberId) {
        return memberStore.retrieve(memberId);
    }

    @Override
    public CommunityMember findMemberByEmail(String memberEmail) {
        return memberStore.retrieveByEmail(memberEmail);
    }

    @Override
    public List<CommunityMember> findMembersByName(String name) {
        return memberStore.retrieveByName(name);
    }

    @Override
    public void modifyMember(String memberId, NameValueList nameValueList) {
        CommunityMember targetMember = memberStore.retrieve(memberId);

        if(targetMember == null) {
            throw new NoSuchMemberException("No such with memberId : " + memberId );
        }

        targetMember.modifyValues(nameValueList);

        memberStore.update(targetMember);

    }

    @Override
    public void removeMember(String memberId) {
        if(!memberStore.exists(memberId)) {
            throw new NoSuchMemberException("No such with memberId : " + memberId );
        }

        memberStore.delete(memberId);
    }
    
}