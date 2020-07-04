package com.osho.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long user_id;
	private String first_name;
	private String lastName;
	private String loginid;
	private String password;
	private boolean actv_flag;
	private String sso_login;
	private boolean consumer_flag;
	private boolean producer_flag;
	private Timestamp created_date;
	private Timestamp modified_date;
	private boolean has_transaction;
	private boolean has_pending_transaction;
	 
	public Users()
	{
		
	}

	public Users(Long user_id, String first_name, String lastName, String loginid, String password, boolean actv_flag,
			String sso_login, boolean consumer_flag, boolean producer_flag, Timestamp created_date,
			Timestamp modified_date, boolean has_transaction, boolean has_pending_transaction) {
		super();
		this.user_id = user_id;
		this.first_name = first_name;
		this.lastName = lastName;
		this.loginid = loginid;
		this.password = password;
		this.actv_flag = actv_flag;
		this.sso_login = sso_login;
		this.consumer_flag = consumer_flag;
		this.producer_flag = producer_flag;
		this.created_date = created_date;
		this.modified_date = modified_date;
		this.has_transaction = has_transaction;
		this.has_pending_transaction = has_pending_transaction;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActv_flag() {
		return actv_flag;
	}

	public void setActv_flag(boolean actv_flag) {
		this.actv_flag = actv_flag;
	}

	public String getSso_login() {
		return sso_login;
	}

	public void setSso_login(String sso_login) {
		this.sso_login = sso_login;
	}

	public boolean isConsumer_flag() {
		return consumer_flag;
	}

	public void setConsumer_flag(boolean consumer_flag) {
		this.consumer_flag = consumer_flag;
	}

	public boolean isProducer_flag() {
		return producer_flag;
	}

	public void setProducer_flag(boolean producer_flag) {
		this.producer_flag = producer_flag;
	}

	public Timestamp getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Timestamp created_date) {
		this.created_date = created_date;
	}

	public Timestamp getModified_date() {
		return modified_date;
	}

	public void setModified_date(Timestamp modified_date) {
		this.modified_date = modified_date;
	}

	public boolean isHas_transaction() {
		return has_transaction;
	}

	public void setHas_transaction(boolean has_transaction) {
		this.has_transaction = has_transaction;
	}

	public boolean isHas_pending_transaction() {
		return has_pending_transaction;
	}

	public void setHas_pending_transaction(boolean has_pending_transaction) {
		this.has_pending_transaction = has_pending_transaction;
	}
}
