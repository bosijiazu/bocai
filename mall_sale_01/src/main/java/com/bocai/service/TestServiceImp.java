package com.bocai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bocai.mapper.TestMapper;

@Service
public class TestServiceImp implements TestService {

	@Autowired
	TestMapper testMapper;

	@Override
	public int selectCount() {
		int count = testMapper.selectCount();
		return count;
	}
	
	
}
