package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.persistence.Id;
import com.app.pojos.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Setter
@Getter
@Table(name="Retailer_products")
public class Retailer_Product extends BaseEntity {
	
	
	
	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	public User getRetailer() {
		return retailer;
	}

	public void setRetailer(User retailer) {
		this.retailer = retailer;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getThreshold_limit() {
		return threshold_limit;
	}

	public void setThreshold_limit(double threshold_limit) {
		this.threshold_limit = threshold_limit;
	}

	@ManyToOne
	@JoinColumn(name="product_id",nullable = false)
	private Products product;
	
	@ManyToOne
	@JoinColumn(name="retailer_id",nullable = false)
	private User retailer;
	
	@NotNull(message ="please add a valid quantity" )
	@Min(value = 0, message="quantity should be greater than 0")
	private int quantity;
	
	@NotNull(message ="please add valid stock" )
	private double threshold_limit;
	
}