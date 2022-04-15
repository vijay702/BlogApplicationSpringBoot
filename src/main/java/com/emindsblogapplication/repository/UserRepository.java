package com.emindsblogapplication.repository;

import com.emindsblogapplication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query("select u.id from User u where u.email = ?1")
    Optional<User> findByEmail(String email);

    @Query("select u from User u where u.username = ?1 or u.email = ?2 ")
    Optional<User> findByUserNameOrEmail(String username, String email);

    @Query("select u.id from User u where u.username = ?1")
    Optional<User> findByUserName(String username);

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);
}
