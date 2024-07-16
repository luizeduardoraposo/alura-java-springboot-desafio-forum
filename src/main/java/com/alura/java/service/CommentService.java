package com.alura.java.service;

import com.alura.java.persistence.model.Comment;
import com.alura.java.web.dto.CommentDto;

public interface CommentService {

	void save(Comment comment);

	int countNumCommentsByPostId(Long postId);

	Comment createNewCommentOnPost(Long postId, CommentDto newCommentForm);

}
