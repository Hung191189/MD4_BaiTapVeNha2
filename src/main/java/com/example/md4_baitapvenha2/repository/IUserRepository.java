package com.example.md4_baitapvenha2.repository;

import com.example.md4_baitapvenha2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
}
