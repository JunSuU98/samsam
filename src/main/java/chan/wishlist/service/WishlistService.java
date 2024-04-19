package chan.wishlist.service;

import java.util.ArrayList;

import chan.wishlist.dto.WishlistDTO;

public interface WishlistService {
ArrayList<WishlistDTO> wishlistSelectAll();
public WishlistDTO wishlistSelect(WishlistDTO wishlistDTO);
WishlistDTO wishlistDelete(WishlistDTO wishlistDTO);
WishlistDTO wishlistInsert(WishlistDTO wishlistDTO);

WishlistDTO wishlistDeleteAll(WishlistDTO wishlistDTO);
}
