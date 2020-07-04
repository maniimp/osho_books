package com.osho.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.Reference;

@Entity
@Table(name="feedback")
public class Feedback 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long feedback_id;
	@Reference
	private Integer item_id;
	private String feedback_string;
	private boolean feedback_reply_available;
	@Reference
	private Integer feedback_reply_id;
	private String feedback_ip_address;
	@Reference
	private Integer feedback_user_id;
	private Integer feedback_number;
	private Date timestamp;
	
	
	public Feedback() {
		
	}
	
	
	public Feedback(Long feedback_id, Integer item_id, String feedback_string, boolean feedback_reply_available,
			Integer feedback_reply_id, String feedback_ip_address, Integer feedback_user_id, Integer feedback_number,
			Date timestamp) {
		super();
		this.feedback_id = feedback_id;
		this.item_id = item_id;
		this.feedback_string = feedback_string;
		this.feedback_reply_available = feedback_reply_available;
		this.feedback_reply_id = feedback_reply_id;
		this.feedback_ip_address = feedback_ip_address;
		this.feedback_user_id = feedback_user_id;
		this.feedback_number = feedback_number;
		this.timestamp = timestamp;
	}


	public Long getFeedback_id() {
		return feedback_id;
	}


	public void setFeedback_id(Long feedback_id) {
		this.feedback_id = feedback_id;
	}


	public Integer getItem_id() {
		return item_id;
	}


	public void setItem_id(Integer item_id) {
		this.item_id = item_id;
	}


	public String getFeedback_string() {
		return feedback_string;
	}


	public void setFeedback_string(String feedback_string) {
		this.feedback_string = feedback_string;
	}


	public boolean isFeedback_reply_available() {
		return feedback_reply_available;
	}


	public void setFeedback_reply_available(boolean feedback_reply_available) {
		this.feedback_reply_available = feedback_reply_available;
	}


	public Integer getFeedback_reply_id() {
		return feedback_reply_id;
	}


	public void setFeedback_reply_id(Integer feedback_reply_id) {
		this.feedback_reply_id = feedback_reply_id;
	}


	public String getFeedback_ip_address() {
		return feedback_ip_address;
	}


	public void setFeedback_ip_address(String feedback_ip_address) {
		this.feedback_ip_address = feedback_ip_address;
	}


	public Integer getFeedback_user_id() {
		return feedback_user_id;
	}


	public void setFeedback_user_id(Integer feedback_user_id) {
		this.feedback_user_id = feedback_user_id;
	}


	public Integer getFeedback_number() {
		return feedback_number;
	}


	public void setFeedback_number(Integer feedback_number) {
		this.feedback_number = feedback_number;
	}


	public Date getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
}
