package com.example.testspringredis;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserdetailRepository extends JpaRepository<Userdetail, String> {
}