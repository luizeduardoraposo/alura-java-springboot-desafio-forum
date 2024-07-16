package com.alura.java.persistence.dao;

import java.util.List;

import com.alura.java.persistence.model.Comment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper {

	int save(Comment comment);

	int deleteCommentsByPostId(Long postId);

	int countNumCommentsByPostId(Long postId);

	List<Comment> findCommentsByPostId(Long postId);

	List<Comment> findCommentsByUserId(Long userId);

}
