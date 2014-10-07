package validationfo.spring;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import cc.fozone.validation.IValidateService;

public class SpringTest {
	public static User createUser(){
		User user = new User();
		
		user.setEmail("fozone#41zone.cc");
		
		user.setPassword("12345");
		user.setPasswordOne("abcde");
		
		Calendar date = Calendar.getInstance();
		
		user.setStarttime(new Timestamp(date.getTimeInMillis()));
		user.setEndtime(new Timestamp(date.getTimeInMillis()-1000));
		
		return user;
	}
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("validationfo/spring/context.xml");
		IValidateService service = context.getBean(IValidateService.class);
		
		User user = createUser();
		Map<String,String> result = service.validate(user, "user.validate");
		System.out.println(result);
	}
}
