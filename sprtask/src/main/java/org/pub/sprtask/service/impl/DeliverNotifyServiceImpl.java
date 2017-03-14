/**
 * 
 */
package org.pub.sprtask.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.pub.sprtask.service.DeliverNotifyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author wuhuoxin 2016年12月14日 下午5:30:49
 *
 */
@Service
public class DeliverNotifyServiceImpl implements DeliverNotifyService {
	private static Logger logger = LoggerFactory.getLogger(DeliverNotifyServiceImpl.class);
	
	/**
	 * 异步通知线程池
	 */
	private ExecutorService asyncPool = Executors.newFixedThreadPool(30);;


	/* (non-Javadoc)
	 * @see org.pub.pay.service.DeliverNotifyService#asyncNotify()
	 */
	@Override
	@Scheduled(fixedDelay=20*1000, initialDelay=10*1000)
	public void minutelyAsyncNotify() {
		logger.info("minutelyAsyncNotify start "+System.currentTimeMillis());
		asyncNotify("minutely");
	}
	
	/**
	 * 异步通知任务
	 * @param mode 取值：minutely, hourly
	 */
	private void asyncNotify(String mode) {
		int round = 0;
		do{
			round ++;
			List<String> replayList = new ArrayList<String>();
			replayList.add(String.valueOf(round));
			for(String replay:replayList){
				//通过线程池逐页并发通知
				asyncPool.execute(new Thread(){
					public void run(){
						logger.debug("do asyncNotify {}",replay);
					}
				});
			}
		} while(round < 10);
		
	}
	
}
