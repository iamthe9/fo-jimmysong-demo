package cc.fozone.jimmysong.demo.kryo;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Output;

/**
 * Hello world!
 *
 */
public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		List<User> list = new ArrayList<User>();
		list.add(new User("Sub","http://renren.com","subicon",4444,null));
		User user = new User("Hello","http://www.baidu.com/","icon",12342,list);
	
		Kryo kryo = new Kryo();
		Output output = new Output(new FileOutputStream("user.txt"));
		kryo.writeObject(output, user);
		output.close();
	}
}
