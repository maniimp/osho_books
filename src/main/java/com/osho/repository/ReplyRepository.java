package com.osho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.osho.model.Reply;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long>{

}
