package kryo;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1138107535552167060L;
	private String username;
	private String url;
	private String icon;
	private long id;
	private List<User> children;
	
	public User() {
		// TODO Auto-generated constructor stub
		this(null, null, null, 0, new ArrayList<User>());
	}
	
	public User(String username, String url, String icon, long id,
			List<User> children) {
		super();
		this.username = username;
		this.url = url;
		this.icon = icon;
		this.id = id;
		this.children = children;
	}



	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public List<User> getChildren() {
		return children;
	}
	public void setChildren(List<User> children) {
		this.children = children;
	}
}
