package validationfo.basic;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;

import validationfo.pojo.User;
import cc.fozone.validation.BasicValidateService;
import cc.fozone.validation.IValidateService;
import cc.fozone.validation.config.BasicValidateConfig;
import cc.fozone.validation.config.IValidateConfig;

public class BasicTest {
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
	
	public static void main(String[] args) {
		String validatorsXML = "validationfo/basic/validators.fo.xml";
		String rulesXML = "validationfo/basic/rules.fo.xml";
		IValidateConfig config =new BasicValidateConfig(validatorsXML, rulesXML);
		IValidateService validateService = new BasicValidateService(config);
		
		User user = createUser();
		
		Map<String,String> map = validateService.validate(user, "user.validate");
		System.out.println(map);
	}
}
