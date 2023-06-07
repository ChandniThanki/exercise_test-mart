package exercise_take.home.implementation;

import java.util.List;

import com.google.gson.reflect.TypeToken;
import exercise_take.home.entities.Product;
import exercise_take.home.entities.Products;
import exercise_take.home.model.ProductService;

public class ProductServiceImpl extends BaseClass implements ProductService {

	@Override
	public List<Product> getAllProducts() {
		String url = BASE_URL + "products";
		Products productResponse = sendHttpGetRequest(url, Products.class);
		if (productResponse != null) {
			List<Product> products = productResponse.getProducts();
			return products;
		}
		return null;
	}

	@Override
	public List<Product> getAllProducts(int limit, int skip, String... select) {
		String url = BASE_URL + "products?limit=" + limit + "&skip=" + skip + "&select=" + select;
		Products productResponse = sendHttpGetRequest(url, Products.class);
		if (productResponse != null) {
			List<Product> products = productResponse.getProducts();
			return products;
		}

		return null;
	}

	@Override
	public Object getProduct(Integer productId) {
		String url = BASE_URL + "products/search?q=" + productId;
		Products productResponse = sendHttpGetRequest(url, Products.class);
		if (productResponse != null) {
			List<Product> products = productResponse.getProducts();
			return products;
		}

		return null;
	}

	@Override
	public List<Product> searchProducts(String query) {
		String url = BASE_URL + "products/search?q=" + query;
		Products productResponse = sendHttpGetRequest(url, Products.class);
		if (productResponse != null) {
			List<Product> products = productResponse.getProducts();
			return products;
		}

		return null;
	}

	@Override
	public List<String> getCategories() {
		String url = BASE_URL + "products/categories";
		return sendHttpGetRequest(url, new TypeToken<List<String>>() {
		}.getType());
	}

	@Override
	public List<Product> getProductsByCategory(String category) {
		String url = BASE_URL + "products/category/" + category;
		Products productResponse = sendHttpGetRequest(url, Products.class);
		if (productResponse != null) {
			List<Product> products = productResponse.getProducts();
			return products;
		}

		return null;
	}

	public Product getProductById(int id) {
		String url = BASE_URL + "products/" + id;
		return sendHttpGetRequest(url, Product.class);

	}

}
