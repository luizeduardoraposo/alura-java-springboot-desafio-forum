package com.alura.java.persistence.dao;

import com.alura.java.persistence.model.VerificationToken;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VerificationTokenMapper {

	int save(VerificationToken token);

	VerificationToken findByToken(String token);

	VerificationToken findByUserId(Long userId);

}