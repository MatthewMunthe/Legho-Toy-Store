package main;

import java.util.ArrayList;

public class User{

	private String email;
	private String password;
//	private Item itemSelected;
	private ArrayList<Item> cartItem;

	
	public User(String email, String password, ArrayList<Item> cartItem) {
		super();
		this.email = email;
		this.password = password;
		this.cartItem = cartItem;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public ArrayList<Item> getCartItem() {
		return cartItem;
	}


	public void setCartItem(ArrayList<Item> cartItem) {
		this.cartItem = cartItem;
	}
	
	public void addCartItem(Item item) {
		if(this.cartItem == null) {
			this.cartItem = new ArrayList<Item>();
		}
		
		this.cartItem.add(item);
	}
}
