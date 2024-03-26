package io.namoosori.travelclub.web.store.jpastore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import io.namoosori.travelclub.web.store.jpastore.jpo.TravelClubJpo;
import java.util.*;

public interface ClubRepository extends JpaRepository<TravelClubJpo, String> {
    List<TravelClubJpo> findAllByName(String name);
}
