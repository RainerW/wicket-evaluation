package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.model.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    
//    public final static String FIND_BY_ADDRESS_QUERY = "SELECT p " + 
//                                                       "FROM Person p LEFT JOIN p.addresses a " +
//                                                       "WHERE a.address = :address";
//
//    /**
//     * Find persons like first name.
//     */
//    public List<Player> findByFirstNameLike(String firstName);
//
//    /**
//     * Find persons by last name.
//     */
//    public List<Player> findByLastName(String lastName);
//
//    /**
//     * Find persons by address.
//     */
//    @Query(FIND_BY_ADDRESS_QUERY)
//    public List<Player> findByAddress(@Param("address") String address);

    
}
