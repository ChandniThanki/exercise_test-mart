package exercise_take.home.implementation;

import java.util.ArrayList;
import java.util.List;
import exercise_take.home.entities.Cart;
import exercise_take.home.entities.Carts;
import exercise_take.home.entities.Product;
import exercise_take.home.entities.Products;

public class TestMartAppFeatures extends BaseClass {

	public void getProductTitlesByWorseRating(double rating) {

		String url = BASE_URL + "products";
		Products productResponse = sendHttpGetRequest(url, Products.class);

		if (productResponse != null) {
			List<Product> products = productResponse.getProducts();

			for (Product product : products) {
				double productRating = product.getRating();

				if (productRating <= rating) {
					product.getTitle();

				}
			}
		}
	}

	public Cart getCartWithHighestTotal() {

		String url = BASE_URL + "carts";
		Cart highestTotalCart = null;
		Carts cartResponse = sendHttpGetRequest(url, Carts.class);
		ArrayList<Integer> al = new ArrayList<Integer>();
		if (cartResponse != null) {
			List<Cart> carts = cartResponse.getCarts();
			double highestTotal = 0;
			for (Cart cc : carts) {
				if (cc.getTotal() > highestTotal) {
					highestTotal = cc.getTotal();
					highestTotalCart = cc;
				}
			}

			return highestTotalCart;
		}
		return null;

	}

	public Cart getCartWithLowestTotal() {
		String url = BASE_URL + "carts";
		Cart lowestTotalCart = null;
		Carts cartResponse = sendHttpGetRequest(url, Carts.class);
		ArrayList<Integer> al = new ArrayList<Integer>();
		if (cartResponse != null) {
			List<Cart> carts = cartResponse.getCarts();
			double lowestTotal = Double.MAX_VALUE;
			for (Cart cc : carts) {
				if (cc.getTotal() < lowestTotal) {
					lowestTotal = cc.getTotal();
					lowestTotalCart = cc;
				}
			}

			return lowestTotalCart;
		}

		return null;

	}

	public List<Product> addProductImagesToUserCart(Integer userId) {

		List<Product> products = new ArrayList<>();
		String url = BASE_URL + "carts/user/" + userId;
		Carts cartResponse = sendHttpGetRequest(url, Carts.class);

		Cart userCart = cartResponse.getCarts().get(0);
		List<Product> cartProduct = userCart.getProducts();

		for (Product product : cartProduct) {
			List<String> images = getProductImageUrl(product.getId());
			product.setImages(images);
			products.add(product);
		}

		return products;

	}

	private List<String> getProductImageUrl(int id) {

		ProductServiceImpl impl = new ProductServiceImpl();
		Product p = impl.getProductById(id);
		return p.getImages();
	}
}
