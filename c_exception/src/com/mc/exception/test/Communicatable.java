package com.mc.exception.test;

import com.mc.exception.custom.TimeOutException;

public interface Communicatable extends Http,FTP{
	void sendMessage() throws TimeOutException;
	void receiveMessage();

}
