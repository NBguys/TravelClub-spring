package io.namoosori.travelclub.spring;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import io.namoosori.travelclub.spring.service.ClubService;
import io.namoosori.travelclub.spring.service.sdo.TravelClubCdo;

public class TravelClubApp {
    
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        String[] beanNames = context.getBeanDefinitionNames();
        System.out.println(Arrays.toString(beanNames));

        TravelClubCdo clubCdo = new TravelClubCdo("TravelClub", "test TravelClub");
        ClubService clubService = context.getBean("clubService", ClubService.class);

        String clubId = clubService.registerClub(clubCdo);

        System.out.println("ID" + clubId);

    }

}