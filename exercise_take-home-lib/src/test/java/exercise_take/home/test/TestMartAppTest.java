package exercise_take.home.test;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import exercise_take.home.entities.Cart;
import exercise_take.home.entities.Product;
import exercise_take.home.entities.User;
import exercise_take.home.implementation.CartServiceImpl;
import exercise_take.home.implementation.ProductServiceImpl;
import exercise_take.home.implementation.TestMartAppFeatures;
import exercise_take.home.implementation.UserServiceImpl;

public class TestMartAppTest {

	private ProductServiceImpl productServiceImpl;
	private CartServiceImpl cartServiceImpl;
	private UserServiceImpl userServiceImpl;
	private TestMartAppFeatures testmartappfeatures;

	final org.apache.logging.log4j.Logger logger = LogManager.getLogger(TestMartAppFeatures.class);

	@BeforeEach
	public void setUp() {

		productServiceImpl = new ProductServiceImpl();
		cartServiceImpl = new CartServiceImpl();
		userServiceImpl = new UserServiceImpl();
		testmartappfeatures = new TestMartAppFeatures();

	}

	@Test
	public void testgetProductTitlesByWorseRating() {
		testmartappfeatures.getProductTitlesByWorseRating(4.20);
	}

	@Test
	public void testgetCartWithHighestTotal() {
		testmartappfeatures.getCartWithHighestTotal();
	}

	@Test
	public void testgetCartWithLowestTotal() {
		testmartappfeatures.getCartWithLowestTotal();
	}
	
	@Test
	public void testaddProductImagesToUserCart() {
		testmartappfeatures.addProductImagesToUserCart(1);
	}

	@Test
	public void testGetAllProducts() {
		List<Product> products = productServiceImpl.getAllProducts();
		logger.info("Get all Products retrieved successfully");
		Assertions.assertNotNull(products);
		Assertions.assertFalse(products.isEmpty());
	}

	@Test
	public void testGetSelectedProducts() {
		List<Product> selectedProducts = productServiceImpl.getAllProducts(11, 13, "perfume Oil,price");
		logger.info("Selected Products retrieved successfully");
		Assertions.assertNotNull(selectedProducts);
		Assertions.assertFalse(selectedProducts.isEmpty());
	}

	@Test
	public void testGetProductById() {
		Product product = productServiceImpl.getProductById(1);
		logger.info("Product received by Id");
		Assertions.assertNotNull(product);
		Assertions.assertEquals(1, product.getId());
	}

	@Test
	public void testSearchProducts() {
		List<Product> matchedProducts = productServiceImpl.searchProducts("phone");
		logger.info("Search Products retrieved successfully");
		Assertions.assertNotNull(matchedProducts);
	}

	@Test
	public void testGetProductCategories() {
		List<String> categories = productServiceImpl.getCategories();
		logger.info("Get Products retrieved successfully");
		Assertions.assertNotNull(categories);
		Assertions.assertFalse(categories.isEmpty());
	}

	@Test
	public void testGetProductsByCategory() {
		List<Product> productsByCategory = productServiceImpl.getProductsByCategory("smartphones");
		logger.info("Get Products by Category retrieved successfully");
		Assertions.assertNotNull(productsByCategory);
	}

	@Test
	public void testGetAllCarts() {
		List<Cart> carts = cartServiceImpl.getAllCarts();
		logger.info("Get all retrieved successfully");
		Assertions.assertNotNull(carts);
		Assertions.assertFalse(carts.isEmpty());
	}

	@Test
	public void testGetCartById() {
		Cart cart = cartServiceImpl.getCart(3);
		logger.info("Get cart by Id retrieved successfully");
		Assertions.assertNotNull(cart);
		Assertions.assertEquals(3, cart.getId());
	}

	@Test
	public void testGetCartsByUserId() {
		Cart cartsByUserId = cartServiceImpl.getUserCarts(5);
		logger.info("Get carts by Id retrieved successfully");
		Assertions.assertNotNull(cartsByUserId);
	}

	@Test
	public void testGetAllUsers() {
		List<User> users = userServiceImpl.getAllUsers();
		logger.info("Get all users retrieved successfully");
		Assertions.assertNotNull(users);
		Assertions.assertFalse(users.isEmpty());
	}

	@Test
	public void testGetUserById() {
		User user = userServiceImpl.getUser(8);
		logger.info("Get users by Id retrieved successfully");
		Assertions.assertNotNull(user);
		Assertions.assertEquals(8, user.getId());
	}

	@Test
	public void testSearchUsers() {
		List<User> matchedUsers = userServiceImpl.searchUsers("Terry");
		logger.info("Search users retrieved successfully");
		Assertions.assertNotNull(matchedUsers);

	}

}
