package com.alura.java.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alura.java.constant.PageMessage;
import com.alura.java.persistence.dao.CategoryMapper;
import com.alura.java.persistence.model.Category;
import com.alura.java.web.dto.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alura.java.service.CategoryService;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryMapper categoryMapper;

	@Override
	public int save(Category category) {
		return this.categoryMapper.save(category);
	}

	@Override
	public Map<String, Object> getNewPostPageWithCategoryName(String categoryName) {
		Map<String, Object> attributes = new HashMap<>();
		Category category = this.categoryMapper.findByName(categoryName);
		attributes.put("title", PageMessage.MESSAGE_NEW_POST_CN);
		PostDto newPostForm = new PostDto();
		newPostForm.setCategory(category.getName());
		attributes.put("postDto", newPostForm);
		attributes.put("isQuickNewPost", false);
		return attributes;
	}

	@Override
	public Map<String, Object> getNewPostPageWithCategorySelect() {
		List<Category> categories = this.categoryMapper.findAll();
		Map<String, Object> attributes = new HashMap<>();
		attributes.put("title", PageMessage.MESSAGE_NEW_POST_CN);
		attributes.put("categories", categories);
		attributes.put("postDto", new PostDto());
		attributes.put("isQuickNewPost", true);
		return attributes;
	}

	@Override
	public List<Category> findAll() {
		return this.categoryMapper.findAll();
	}

}
