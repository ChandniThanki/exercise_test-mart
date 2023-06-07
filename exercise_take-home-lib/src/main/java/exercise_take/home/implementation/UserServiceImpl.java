package exercise_take.home.implementation;

import java.util.List;
import exercise_take.home.entities.User;
import exercise_take.home.entities.Users;
import exercise_take.home.model.UserService;

public class UserServiceImpl extends BaseClass implements UserService {

	@Override
	public List<User> getAllUsers() {
		String url = BASE_URL + "users";
		Users userResponse = sendHttpGetRequest(url, Users.class);
		if (userResponse != null) {
			List<User> users = userResponse.getUser();
			return users;
		}

		return null;
	}

	@Override
	public List<User> searchUsers(String query) {
		String url = BASE_URL + "users/search?q=" + query;
		Users userResponse = sendHttpGetRequest(url, Users.class);
		if (userResponse != null) {
			List<User> users = userResponse.getUser();
			return users;
		}
		return null;
	}

	@Override
	public User getUser(Integer id) {
		String url = BASE_URL + "users/" + id;
		return sendHttpGetRequest(url, User.class);
	}

}
