package rmi.helloworld;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * RMI调用的接口定义
 * 1. 需要RMI进行调用的接口必须实现java.rmi.Remote接口
 * 2. 接口方法必须抛出 java.rmi.RemoteException异常
 * @author Jimmy Song
 *
 */
public interface IUserService extends Remote {
	/**
	 * 获得用户名
	 * @return
	 * @throws RemoteException
	 */
	public String getCurrentName() throws RemoteException;
	
	/**
	 * 获得用户
	 * @return
	 * @throws RemoteException
	 */
	public User getUserById() throws RemoteException;
}
