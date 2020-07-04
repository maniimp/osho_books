package com.osho.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osho.repository.ReplyRepository;

@Service
public class ReplyServices {

	@Autowired
	ReplyRepository replyRepository;
	
}
