package com.osho.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.Reference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
 
@Entity
@Table(name="shop")
public class Shop 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long item_id;
	private String item_name;
	private BigDecimal item_price;
	private Integer item_total_quantity;
	private String item_category;
	private boolean item_availabile;
	private String item_currency;
	private String shipping_available;
	private int discount;
	private String item_description;
	private String item_publisher;
	private String item_language;
	private Integer rating;
	private Long no_of_purchases;
	private String cover;
	private String author;
	private boolean gift_wrapped;
	private Long wrap_id;
	@Reference
	private Long image_id;
	
	
	public Shop() {
		 
	}

	public Shop(Long item_id, String item_name, BigDecimal item_price, Integer item_total_quantity,
			String item_category, boolean item_availabile, String item_currency, String shipping_available,
			int discount, String item_description, String item_publisher, String item_language, Integer rating,
			Long no_of_purchases, String cover, String author, boolean gift_wrapped, Long wrap_id, Long image_id) {
		super();
		this.item_id = item_id;
		this.item_name = item_name;
		this.item_price = item_price;
		this.item_total_quantity = item_total_quantity;
		this.item_category = item_category;
		this.item_availabile = item_availabile;
		this.item_currency = item_currency;
		this.shipping_available = shipping_available;
		this.discount = discount;
		this.item_description = item_description;
		this.item_publisher = item_publisher;
		this.item_language = item_language;
		this.rating = rating;
		this.no_of_purchases = no_of_purchases;
		this.cover = cover;
		this.author = author;
		this.gift_wrapped = gift_wrapped;
		this.wrap_id = wrap_id;
		this.image_id = image_id;
	}

	public Long getItem_id() {
		return item_id;
	}


	public void setItem_id(Long item_id) {
		this.item_id = item_id;
	}


	public String getItem_name() {
		return item_name;
	}


	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}


	public BigDecimal getItem_price() {
		return item_price;
	}


	public void setItem_price(BigDecimal item_price) {
		this.item_price = item_price;
	}


	public Integer getItem_total_quantity() {
		return item_total_quantity;
	}


	public void setItem_total_quantity(Integer item_total_quantity) {
		this.item_total_quantity = item_total_quantity;
	}


	public String getItem_category() {
		return item_category;
	}


	public void setItem_category(String item_category) {
		this.item_category = item_category;
	}


	public boolean isItem_availabile() {
		return item_availabile;
	}


	public void setItem_availabile(boolean item_availabile) {
		this.item_availabile = item_availabile;
	}


	public String getItem_currency() {
		return item_currency;
	}


	public void setItem_currency(String item_currency) {
		this.item_currency = item_currency;
	}


	public String getShipping_available() {
		return shipping_available;
	}


	public void setShipping_available(String shipping_available) {
		this.shipping_available = shipping_available;
	}


	public int getDiscount() {
		return discount;
	}


	public void setDiscount(int discount) {
		this.discount = discount;
	}


	public String getItem_description() {
		return item_description;
	}


	public void setItem_description(String item_description) {
		this.item_description = item_description;
	}


	public String getItem_publisher() {
		return item_publisher;
	}


	public void setItem_publisher(String item_publisher) {
		this.item_publisher = item_publisher;
	}


	public String getItem_language() {
		return item_language;
	}


	public void setItem_language(String item_language) {
		this.item_language = item_language;
	}


	public Integer getRating() {
		return rating;
	}


	public void setRating(Integer rating) {
		this.rating = rating;
	}


	public Long getNo_of_purchases() {
		return no_of_purchases;
	}


	public void setNo_of_purchases(Long no_of_purchases) {
		this.no_of_purchases = no_of_purchases;
	}


	public String getCover() {
		return cover;
	}


	public void setCover(String cover) {
		this.cover = cover;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public boolean isGift_wrapped() {
		return gift_wrapped;
	}


	public void setGift_wrapped(boolean gift_wrapped) {
		this.gift_wrapped = gift_wrapped;
	}


	public Long getWrap_id() {
		return wrap_id;
	}


	public void setWrap_id(Long wrap_id) {
		this.wrap_id = wrap_id;
	}


	public Long getImage_id() {
		return image_id;
	}


	public void setImage_id(Long image_id) {
		this.image_id = image_id;
	}

	@Override
	public String toString() {
		return "Shop [item_id=" + item_id + ", item_name=" + item_name + ", item_price=" + item_price
				+ ", item_total_quantity=" + item_total_quantity + ", item_category=" + item_category
				+ ", item_availabile=" + item_availabile + ", item_currency=" + item_currency + ", shipping_available="
				+ shipping_available + ", discount=" + discount + ", item_description=" + item_description
				+ ", item_publisher=" + item_publisher + ", item_language=" + item_language + ", rating=" + rating
				+ ", no_of_purchases=" + no_of_purchases + ", cover=" + cover + ", author=" + author + ", gift_wrapped="
				+ gift_wrapped + ", wrap_id=" + wrap_id + ", image_id=" + image_id + "]";
	}
	
}



