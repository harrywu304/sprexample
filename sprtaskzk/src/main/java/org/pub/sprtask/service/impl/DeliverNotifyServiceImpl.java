/**
 * 
 */
package org.pub.sprtask.service.impl;

import java.io.UnsupportedEncodingException;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.Resource;

import org.pub.sprtask.service.DeliverNotifyService;
import org.pub.sprtask.util.ZkUtil;
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
	private ExecutorService asyncPool = Executors.newFixedThreadPool(30);
	
	@Resource
	private ZkUtil zkUtil;
	
	private String minutelyAsyncNotifyLock = "/manlock";

	/* (non-Javadoc)
	 * @see org.pub.pay.service.DeliverNotifyService#asyncNotify()
	 */
	@Override
	@Scheduled(fixedDelay=5*1000, initialDelay=5*1000)
	public void minutelyAsyncNotify() {
		String vmName = ManagementFactory.getRuntimeMXBean().getName();
		byte[] vmNameBytes = null;
		try {
			vmNameBytes = vmName.getBytes("utf8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		logger.debug("vmName: {}", vmName);
		byte[] data = zkUtil.getNodeData(minutelyAsyncNotifyLock);
		boolean todoTask = false;
		if(data != null){
			String dataStr = "";
			try {
				dataStr = new String(data,"utf8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			todoTask = (vmName.equals(dataStr));
		} else {
			todoTask = zkUtil.createNode(minutelyAsyncNotifyLock, vmNameBytes);
		}
		if(todoTask){
			logger.info("minutelyAsyncNotify start "+System.currentTimeMillis());
			try{
				asyncNotify("minutely");
			}catch(Exception e){
				logger.error("",e);
			} finally{
				//zkUtil.deleteNode(minutelyAsyncNotifyLock);
			}
		}
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
