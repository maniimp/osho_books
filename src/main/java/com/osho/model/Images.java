package com.osho.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="images")
public class Images {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long image_id;
	private String image_name;
	private Long image_size;
	private String image_dimensions;
	private String image_description;
	@Lob
	@Basic(fetch = FetchType.LAZY)
	private byte[] image_bytes;
	
	public Images() {
		
	}
	
	
	public Images(Long image_id, String image_name, Long image_size, String image_dimensions,
			String image_description) {
		super();
		this.image_id = image_id;
		this.image_name = image_name;
		this.image_size = image_size;
		this.image_dimensions = image_dimensions;
		this.image_description = image_description;
	}


	public Long getImage_id() {
		return image_id;
	}


	public void setImage_id(Long image_id) {
		this.image_id = image_id;
	}


	public String getImage_name() {
		return image_name;
	}


	public void setImage_name(String image_name) {
		this.image_name = image_name;
	}


	public Long getImage_size() {
		return image_size;
	}


	public void setImage_size(Long image_size) {
		this.image_size = image_size;
	}


	public String getImage_dimensions() {
		return image_dimensions;
	}


	public void setImage_dimensions(String image_dimensions) {
		this.image_dimensions = image_dimensions;
	}


	public String getImage_description() {
		return image_description;
	}


	public void setImage_description(String image_description) {
		this.image_description = image_description;
	}
}
