package validationfo.custom;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import cc.fozone.validation.IValidator;
import cc.fozone.validation.config.pojo.Rule;

/**
 * 构造一个判断 参数 是否能够被 指定的值 整出的验证器
 * 例如：对象值为4 ，验证参数为2，那么 4可以被2整除，表示成功
 * 
 * @author Jimmy Song
 *
 */
public class CustomValidator implements IValidator {
	private static final Logger logger = Logger.getLogger(CustomValidator.class);
	public boolean execute(Object context, Class type, Object value, Rule rule) {
		// TODO Auto-generated method stub
		
		/**
		 * 通过 value 实际验证的值
		 */
		if(value == null) return true;
		
		/**
		 * 通过 type 获取值的类型
		 */
		if(!(type == Integer.class || type == int.class)) {
			return false;
		}
		int objectValue = ((Integer)value).intValue();
		
		
		/**
		 * 通过 rule 获取规则参数
		 */
		String toValue = rule.getParameter("value");
		if(StringUtils.isBlank(toValue)) return false;
		
		int intValue = -1;
		try {
			intValue = Integer.parseInt(toValue);
		} catch(NumberFormatException e){
			logger.error("倍数值转换错误！");
			return false;
		}
		
		if(intValue <= 0) {
			logger.warn("倍数值不能小于等于0");
			return false;
		}
		
		return objectValue % intValue == 0;
	}

}
