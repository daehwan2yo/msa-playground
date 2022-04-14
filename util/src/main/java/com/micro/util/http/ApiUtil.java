package com.micro.util.http;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApiUtil {
	private static final Logger LOG = LoggerFactory.getLogger(ApiUtil.class);

	private final String port;

	private String serviceAddress = null;

	public ApiUtil(String port) {
		this.port = port;
	}

	public String getServiceAddress() {
		if (serviceAddress == null) {
			serviceAddress = findMyHostname() + "/" + findMyIpAddress() + ":" + port;
		}
		return serviceAddress;
	}

	private String findMyHostname() {
		try {
			return InetAddress.getLocalHost()
							  .getHostName();
		} catch (UnknownHostException e) {
			return "unknown host name";
		}
	}

	private String findMyIpAddress() {
		try {
			return InetAddress.getLocalHost()
							  .getHostAddress();
		} catch (UnknownHostException e) {
			return "unknown IP address";
		}
	}

}
