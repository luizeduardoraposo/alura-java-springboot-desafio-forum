package com.alura.java.persistence.dao;

import java.util.List;

import com.alura.java.persistence.model.Category;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper {

	Category findByName(String categoryName);

	int save(Category category);

	List<Category> findAll();

}
