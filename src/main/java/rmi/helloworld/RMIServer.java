package rmi.helloworld;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class RMIServer {
	public static void main(String[] args) throws RemoteException,
			MalformedURLException, AlreadyBoundException {
		// 实例化用户接口
		IUserService userService = new UserServiceImpl();

		// 注册RMI服务端口
		LocateRegistry.createRegistry(8888);

		// 绑定服务
		Naming.bind("//localhost:8888/user", userService);
		
		System.out.println("RMI服务绑定成功");
	}
}
