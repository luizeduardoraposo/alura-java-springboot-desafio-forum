package com.alura.java.service.impl;

import java.sql.Timestamp;

import com.alura.java.persistence.dao.CommentMapper;
import com.alura.java.persistence.dao.PostMapper;
import com.alura.java.persistence.dao.UserMapper;
import com.alura.java.persistence.model.Comment;
import com.alura.java.persistence.model.Post;
import com.alura.java.persistence.model.User;
import com.alura.java.web.dto.CommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.alura.java.service.CommentService;

@Service("commentService")
public class CommentServiceImpl implements CommentService {

	@Autowired
	private PostMapper postMapper;

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private CommentMapper commentMapper;

	@Override
	public void save(Comment comment) {
		Post post = this.postMapper.findById(comment.getPostId());
		post.setCommentCount(post.getCommentCount() == null ? 1 : post.getCommentCount() + 1);
		this.postMapper.update(post);
		this.commentMapper.save(comment);
	}

	@Override
	public int countNumCommentsByPostId(Long postId) {
		return this.commentMapper.countNumCommentsByPostId(postId);
	}

	@Override
	public Comment createNewCommentOnPost(Long postId, CommentDto newCommentForm) {
		// find authenticated user
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		User user = this.userMapper.findByUsername(username);
		// construct new comment
		Comment comment = new Comment();
		comment.setPostId(postId);
		comment.setBody(newCommentForm.getComment());
		comment.setUser(user);
		comment.setDateCreated(new Timestamp(System.currentTimeMillis()));
		return comment;
	}

}
