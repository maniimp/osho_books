package com.osho.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.Reference;

@Entity
@Table(name="reply")
public class Reply {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long reply_id;
	@Reference
	private Long feedback_id;
	private String reply_string;
	@Reference
	private Long reply_user_id;
	private Integer reply_number;
	private Date reply_time;
	
	public Reply() {
		
	}
	
	public Reply(Long reply_id, Long feedback_id, String reply_string, Long reply_user_id, Integer reply_number,
			Date reply_time) {
		super();
		this.reply_id = reply_id;
		this.feedback_id = feedback_id;
		this.reply_string = reply_string;
		this.reply_user_id = reply_user_id;
		this.reply_number = reply_number;
		this.reply_time = reply_time;
	}

	public Long getReply_id() {
		return reply_id;
	}

	public void setReply_id(Long reply_id) {
		this.reply_id = reply_id;
	}

	public Long getFeedback_id() {
		return feedback_id;
	}

	public void setFeedback_id(Long feedback_id) {
		this.feedback_id = feedback_id;
	}

	public String getReply_string() {
		return reply_string;
	}

	public void setReply_string(String reply_string) {
		this.reply_string = reply_string;
	}

	public Long getReply_user_id() {
		return reply_user_id;
	}

	public void setReply_user_id(Long reply_user_id) {
		this.reply_user_id = reply_user_id;
	}

	public Integer getReply_number() {
		return reply_number;
	}

	public void setReply_number(Integer reply_number) {
		this.reply_number = reply_number;
	}

	public Date getReply_time() {
		return reply_time;
	}

	public void setReply_time(Date reply_time) {
		this.reply_time = reply_time;
	}
}
