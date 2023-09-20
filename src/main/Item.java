package main;

import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Item {
	
	private String name;
	private String price;
	private String stock;
	private String desc;
	private File file;
	private Image img;
	private ImageView iv;
	private Integer count;
	
	public Item(String name, String price, String stock, String desc, File file, Image img, ImageView iv, Integer count) {
		super();
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.desc = desc;
		this.file = file;
		this.img = img;
		this.iv = iv;
		this.count = count;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public ImageView getIv() {
		return iv;
	}

	public void setIv(ImageView iv) {
		this.iv = iv;
	}
}
