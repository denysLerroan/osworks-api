package com.dlerroan.osworks.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dlerroan.osworks.domain.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
