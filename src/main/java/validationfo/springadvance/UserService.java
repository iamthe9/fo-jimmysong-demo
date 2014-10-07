package validationfo.springadvance;

public class UserService {
	public boolean exist(String value) {
		return !"superman".equals(value);
	}
	
	public boolean length(User user){
		return user.getUsername().length() == user.getUsernameLength();
	}
	
	public boolean lengthByName(String username){
		return username.length() >= 5;
	}
}
