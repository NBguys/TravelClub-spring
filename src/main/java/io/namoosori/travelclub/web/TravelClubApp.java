package io.namoosori.travelclub.web;

import java.util.Arrays;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import io.namoosori.travelclub.web.aggregate.club.CommunityMember;
import io.namoosori.travelclub.web.aggregate.club.TravelClub;
import io.namoosori.travelclub.web.service.ClubService;
import io.namoosori.travelclub.web.service.MemberService;
import io.namoosori.travelclub.web.service.logic.MemberServiceLogic;
import io.namoosori.travelclub.web.service.sdo.MemberCdo;
import io.namoosori.travelclub.web.service.sdo.TravelClubCdo;

@SpringBootApplication
public class TravelClubApp {
    

    public static void main(String[] args) {

        SpringApplication.run(TravelClubApp.class);

        // ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // String[] beanNames = context.getBeanDefinitionNames();
        // System.out.println(Arrays.toString(beanNames));

        // MemberService memberService = context.getBean("memberServiceLogic", MemberServiceLogic.class);

        // MemberCdo memberCdo = new MemberCdo(
        //     "gudwns520@gmail.com",
        //     "Lee",
        //     "NBguys",
        //     "01050151370",
        //     "19900520");

        // String memberId = memberService.registerMember(memberCdo);

        // CommunityMember foundedMember = memberService.findMemberById(memberId);
        // System.out.println(foundedMember.toString());

        // TravelClubCdo clubCdo = new TravelClubCdo("TravelClub", "test TravelClub");
        // ClubService clubService = context.getBean("clubService", ClubService.class);

        // String clubId = clubService.registerClub(clubCdo);

        // System.out.println("ID" + clubId);

        // TravelClub foundedClub = clubService.findClubById(clubId);
        // System.out.println("Club Name :" + foundedClub.getName());
        // System.out.println("Club Intro : " + foundedClub.getIntro());
        // System.out.println("Club FoundationTime : " + new Date(foundedClub.getFoundationTime()));

    }

}
