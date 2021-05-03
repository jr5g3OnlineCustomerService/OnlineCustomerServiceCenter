package com.cg.onlinecustomerservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.onlinecustomerservice.entity.Chat;
@Repository
public interface ChatDao extends JpaRepository<Chat , Integer>{

}
