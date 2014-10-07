package rmi.helloworld;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RMIClient {
	public static void main(String[] args) throws MalformedURLException,
			RemoteException, NotBoundException {
		
		// 通过命名空间查找服务
		IUserService userService = (IUserService) Naming
				.lookup("rmi://localhost:8888/user");
		
		System.out.println(userService.getCurrentName());
		
		User user = userService.getUserById();
		System.out.println(user.getName()+","+user.getAge());
	}
}
