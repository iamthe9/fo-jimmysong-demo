package validationfo.custom;

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
public class CustomTest {
	public static void main(String[] args) {
		/**
		 * Validation.FO的配置资源
		 */
		// 验证器配置，系统默认配置
		String validatorsXML = "validationfo/custom/validators.fo.xml";
		// 规则配置
		String rulesXML = "validationfo/custom/rules.fo.xml";
		
		/**
		 * 实例化配置对象
		 */
		IValidateConfig config =new BasicValidateConfig(validatorsXML, rulesXML);
		/**
		 * 实例化验证服务层
		 */
		IValidateService validateService = new BasicValidateService(config);
		
		// 实例化用户
		Money money = new Money();
		money.setNumber(7);
		money.setText("演示Context使用的Text");
		
		/**
		 * 执行验证
		 */
		Map<String,String> map = validateService.validate(money, "money.validate");
		// 输出结果
		if(map == null || map.size() == 0) {
			System.out.println("验证成功");
		} else {
			System.out.println("验证失败，结果如下");
			System.out.println(map);
		}
	}
	
}
