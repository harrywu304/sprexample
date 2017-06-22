package org.pub.sprtask.util;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZkWatcher implements Watcher {
	
	private static Logger logger = LoggerFactory.getLogger(ZkWatcher.class);

	@Override
	public void process(WatchedEvent event) {
		logger.info("event:{}", event);
	}

}
