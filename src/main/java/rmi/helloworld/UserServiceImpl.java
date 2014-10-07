package rmi.helloworld;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * 实现接口必须继承 java.rmi.server.UnicastRemoteObject ， 否则启动会失败
 * @author Jimmy Song
 *
 */
public class UserServiceImpl extends UnicastRemoteObject  implements IUserService {

	private static final long serialVersionUID = 6760819462105653668L;

	
	protected UserServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCurrentName() throws RemoteException {
		// TODO Auto-generated method stub
		return "jimmysong";
	}

	public User getUserById() throws RemoteException {
		// TODO Auto-generated method stub
		User user = new User();
		user.setName("jimmysong");
		user.setAge(100);
		return user;
	}

}
