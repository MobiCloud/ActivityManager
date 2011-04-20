package edu.asu.eas.snac.activitymanager.messages;

/**
 * List of wishes.
 *
 */
public class WishListMessage extends Message {
	private WishItem[] wishes;
	private int size;
	
	public WishListMessage(){
		size = 10;
		init();
	}
	
	private void init(){
		wishes = new WishItem[size];
	}
	
	public WishListMessage(int size){
		this.size = size;
		init();
	}
	
	
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
		init();
	}

	public void setWish(int offset, WishItem wish){
		wishes[offset] = wish;
	}
	
	public WishItem getWish(int offset){
		return wishes[offset];
	}
	
	public WishItem[] getAllWishes(){
		return wishes;
	}
}
