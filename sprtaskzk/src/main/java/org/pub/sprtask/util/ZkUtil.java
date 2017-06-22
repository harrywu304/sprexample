package org.pub.sprtask.util;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ZkUtil {
	
	private static Logger logger = LoggerFactory.getLogger(ZkUtil.class);
	
	@Resource
	private ZooKeeper zkClient;
	
	public boolean createNode(String path, byte[] data){
		boolean rt = false;
		try {
			String actualPath = zkClient.create(path,data, Ids.OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL);
			logger.debug("actualPath: {}",actualPath);
			rt = true;
		} catch (KeeperException e) {
			logger.error("", e);
		} catch (InterruptedException e) {
			logger.error("", e);
		}
		return rt;
	}
	
	public boolean deleteNode(String path){
		boolean rt = false;
		try {
			zkClient.delete(path, -1);
			rt = true;
		} catch (KeeperException e) {
			logger.error("", e);
		} catch (InterruptedException e) {
			logger.error("", e);
		}
		return rt;
	}
	
	public byte[] getNodeData(String path) {
		byte[] rt = null;
		try {
			rt = zkClient.getData(path, false, null);
			try {
				logger.debug("node data: {}", new String(rt,"utf8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		} catch (KeeperException e) {
			logger.error("", e);
		} catch (InterruptedException e) {
			logger.error("", e);
		}
		return rt;
	}

}
