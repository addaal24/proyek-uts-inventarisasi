package com.polstat.inventarisasi.repository;

import com.polstat.inventarisasi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long> {
    public User findByEmail(String email);
}
