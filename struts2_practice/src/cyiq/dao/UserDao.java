package cyiq.dao;

import java.util.List;

import cyiq.bean.User;

public interface UserDao {

	public User login(User user);

	public void save(User user);

	public List<User> findUsersByCondition(User user);

	public User findUsersById(Integer userID);

	public void update(User user);

	public void delete(Integer userID);

}
