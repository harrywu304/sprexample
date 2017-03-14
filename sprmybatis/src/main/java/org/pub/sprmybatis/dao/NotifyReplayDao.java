/**
 * 
 */
package org.pub.sprmybatis.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import org.pub.sprmybatis.bean.NotifyReplay;

/**
 * 异步通知记录表的Dao
 * @author wuhuoxin 2016年12月15日 下午3:35:05
 *
 */
@Repository
public interface NotifyReplayDao { 
	
	/**
	 * 
	 * @param notifyReplay
	 * @return
	 */
	public int insertNotifyReplay(NotifyReplay notifyReplay);
	
	
	public int deleteNotifyReplay(String payOrderId);
	
	/**
	 * 更新notify_count和last_try_time
	 * @param notifyReplay
	 * @return
	 */
	public int updateReplayInfo(NotifyReplay notifyReplay);
	
	/**
	 * 查找分钟级通知replay
	 * @return
	 */
	public List<NotifyReplay> selectMinuteLevelNotifyReplay();
	
	/**
	 * 查找小时级通知replay
	 * @return
	 */
	public List<NotifyReplay> selectHourLevelNotifyReplay();
	

}
