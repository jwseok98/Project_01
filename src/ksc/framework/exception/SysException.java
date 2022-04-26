package ksc.framework.exception;

import com.lgcns.laf.exception.LException;

public class SysException extends LException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SysException() {
		super();
	}
	
	public SysException(String message) {
		super(message);
	}
	
	public SysException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public SysException(Throwable cause) {
		super(cause);
	}

}
