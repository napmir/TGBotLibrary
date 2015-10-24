package com.tgbotlibrary.enums;

public interface CommonEnum {

	public interface Config {
		public interface Telegram {
			public String URL = "telegram.url";
			public String Token = "telegram.token";
		}

		public interface Proxy {
			public String Enabled = "proxy.enabled";
			public String Host = "proxy.host";
			public String Port = "proxy.port";
			public String Protocol = "proxy.protocol";
		}

		public interface Listener {
			public String SleepTime = "listener.sleeptime";
			public String Offset = "listener.request.offset";
			public String Limit = "listener.request.limit";
			public String Timeout = "listener.request.timeout";
		}

		public interface Dispatcher {
			public String ThreadPoolSize = "listener.dispatcher.threadpool.size";
			public String SleepTime = "listener.dispatcher.sleeptime";
			public String TaskListCapacity = "listener.dispatcher.tasklist.capacity";
		}
	}
}
