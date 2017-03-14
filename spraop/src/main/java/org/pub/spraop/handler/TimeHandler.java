package org.pub.spraop.handler;

import org.springframework.stereotype.Component;

@Component
public class TimeHandler {
	public void printTime()
    {
        System.out.println("CurrentTime = " + System.currentTimeMillis());
    }
}
