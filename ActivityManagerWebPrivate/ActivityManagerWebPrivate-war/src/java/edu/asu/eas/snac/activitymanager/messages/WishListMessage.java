package edu.asu.eas.snac.activitymanager.messages;

/**
 * List of wishes.
 *
 */
public class WishListMessage extends Message {
	private WishItem[] wishes;
        private int size;

        public WishListMessage()
        {
		size = 0;
		setSize(0);
	}
	
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

        public void setSize(int size) {
		this.size = size;
                wishes = new WishItem[size];
        }

        public int getSize() {
		return size;
	}
}
