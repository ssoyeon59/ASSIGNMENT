package com.sparta.post.repository;

import com.sparta.post.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefreshTokenRepositroy extends JpaRepository<RefreshToken, String> {
}
