/**
 * 
 */
package org.pub.sprmvc.converter;

import java.sql.Timestamp;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

/**
 * 字符串时间戳到timestamp的转换器
 * @author wuhuoxin 2016年11月25日 下午6:26:01
 *
 */
public class TimestampConverter implements Converter<String, Timestamp> {

	@Override
	public Timestamp convert(String timeStr) {
		Timestamp t = null;
		if (!StringUtils.isEmpty(timeStr)) {
			long time = Long.valueOf(timeStr);
			t = new Timestamp(time);
		}
		return t;
	}

}