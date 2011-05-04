package edu.asu.eas.snac.activitymanager.messages;

/**
 * List of wishes.
 *
 */
public class WishListMessage extends Message {
	private WishItem[] wishes;
	
	public WishListMessage(int size){
		wishes = new WishItem[size];
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
