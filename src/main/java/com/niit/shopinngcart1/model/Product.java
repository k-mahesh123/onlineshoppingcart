package com.niit.shopinngcart1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Table
@Entity
@Component
public class Product {
    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int productid;
    
    @NotNull
    @Size(min=5,max=10)
	private String productname;
    @Column
    @NotNull
	private int productprice;
    @NotNull
	@Column
	private String suppliername;
    @NotNull
	@Column
	private String productwaranty;
	@Column
	 @NotNull
	private String categoryname;
	
	private String path;
    
    
    @Column
    @JsonIgnore
    @NotNull
	transient private MultipartFile img;
    @Column
    private String image;
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public int getProductprice() {
		return productprice;
	}
	public void setProductprice(int productprice) {
		this.productprice = productprice;
	}
	public String getSuppliername() {
		return suppliername;
	}
	public void setSuppliername(String suppliername) {
		this.suppliername = suppliername;
	}
	public String getProductwaranty() {
		return productwaranty;
	}
	public void setProductwaranty(String productwaranty) {
		this.productwaranty = productwaranty;
	}
	public MultipartFile getImg() {
		return img;
	}
	public void setImg(MultipartFile img) {
		this.img = img;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
}
	 
