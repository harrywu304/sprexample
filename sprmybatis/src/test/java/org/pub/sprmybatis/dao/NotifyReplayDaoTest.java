/**
 * 
 */
package org.pub.sprmybatis.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.annotation.Resource;

import com.github.pagehelper.PageHelper;
import base.BaseJunit4Test;
import org.pub.sprmybatis.bean.NotifyReplay;

/**
 * @author wuhuoxin 2016年12月28日 下午6:31:56
 *
 */
public class NotifyReplayDaoTest extends BaseJunit4Test {
	
	@Resource
	NotifyReplayDao notifyReplayDao;

	/**
	 * Test method for {@link org.pub.sprmybatis.dao.NotifyReplayDao#selectNotifyReplayByNotifyCount(int[])}.
	 */
	//@Test
	public void testSelectNotifyReplayByNotifyCount() {
		//false参数表示查询分页数据时无需先做select count
		PageHelper.startPage(1, 3, false);
		List<NotifyReplay> list = notifyReplayDao.selectMinuteLevelNotifyReplay();
		assertEquals(3,list.size());
	}

}
