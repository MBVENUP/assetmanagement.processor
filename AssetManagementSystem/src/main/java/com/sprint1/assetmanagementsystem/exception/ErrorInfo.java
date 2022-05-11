package com.sprint1.assetmanagementsystem.exception;

import java.time.LocalDateTime;

public class ErrorInfo {

	LocalDateTime timeStamp;
	String msg;
	String url;

	public ErrorInfo() {
		super();

	}

	public ErrorInfo(LocalDateTime timeStamp, String msg, String url) {
		super();
		this.timeStamp = timeStamp;
		this.msg = msg;
		this.url = url;
	}

	public LocalDateTime getTimestamp() {
		return timeStamp;
	}

	public void setTimestamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "ErrorInfo [timeStamp=" + timeStamp + ", msg=" + msg + ", url=" + url + "]";
	}
}