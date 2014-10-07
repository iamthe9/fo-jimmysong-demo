package validationfo.basic;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;

import cc.fozone.validation.BasicValidateService;
import cc.fozone.validation.IValidateService;
import cc.fozone.validation.config.BasicValidateConfig;
import cc.fozone.validation.config.IValidateConfig;

/**
 * 最基本的测试
 * @author Jimmy Song
 *
 */
public class BasicTest {
	public static void main(String[] args) {
		/**
		 * Validation.FO的配置资源
		 */
		// 验证器配置，系统默认配置
		String validatorsXML = "validationfo/basic/validators.fo.xml";
		// 规则配置
		String rulesXML = "validationfo/basic/rules.fo.xml";
		
		/**
		 * 实例化配置对象
		 */
		IValidateConfig config =new BasicValidateConfig(validatorsXML, rulesXML);
		/**
		 * 实例化验证服务层
		 */
		IValidateService validateService = new BasicValidateService(config);
		
		// 实例化用户
		User user = createUser();
		
		/**
		 * 执行验证
		 */
		Map<String,String> map = validateService.validate(user, "user.validate");
		// 输出结果
		if(map == null || map.size() == 0) {
			System.out.println("验证成功");
		} else {
			System.out.println("验证失败，结果如下");
			System.out.println(map);
		}
	}
	
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
}
