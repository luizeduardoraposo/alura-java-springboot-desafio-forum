package com.alura.java.persistence.dao;

import java.util.List;

import com.alura.java.persistence.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

	int save(User user);

	int update(User user);

	List<User> findAll();

	User findById(Long id);

	User findByUsername(String username);

	User findByEmail(String email);

}
