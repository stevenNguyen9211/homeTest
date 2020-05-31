package com.initPage;

public class Base {

	protected static ThreadLocal<WebPage> _tldriver = new ThreadLocal<WebPage>();

	public static WebPage getCurrentDriver() {
		if (_tldriver.get() == null || _tldriver.get().getSessionID() == null) {
			_tldriver.set(new WebPage());
		}
		return _tldriver.get();
	}
}
