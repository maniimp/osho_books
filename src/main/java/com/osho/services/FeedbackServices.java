package com.osho.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osho.repository.FeedbackRepository;

@Service
public class FeedbackServices {

	@Autowired
	FeedbackRepository feedbackRepository;
	
	
}
