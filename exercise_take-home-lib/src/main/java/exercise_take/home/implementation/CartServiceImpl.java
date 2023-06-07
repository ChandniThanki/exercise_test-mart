package exercise_take.home.implementation;

import java.util.List;
import exercise_take.home.entities.Cart;
import exercise_take.home.entities.Carts;
import exercise_take.home.model.CartService;

public class CartServiceImpl extends BaseClass implements CartService {

	@Override
	public List<Cart> getAllCarts() {
		String url = BASE_URL + "carts";
		Carts cartResponse = sendHttpGetRequest(url, Carts.class);
		if (cartResponse != null) {
			List<Cart> carts = cartResponse.getCarts();
			return carts;
		}

		return null;
	}

	@Override
	public Cart getCart(Integer cartId) {
		String url = BASE_URL + "carts/" + cartId;
		return sendHttpGetRequest(url, Cart.class);
	}

	@Override
	public List<Cart> getUserCarts(Integer id) {
		String url = BASE_URL + "carts/" + id;
		return sendHttpGetRequest(url, Cart.class);
	}

	public Cart getUserCarts(int userId) {
		String url = BASE_URL + "carts/user/" + userId;
		return sendHttpGetRequest(url, Cart.class);
	}

}
