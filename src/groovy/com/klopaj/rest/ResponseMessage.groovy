/*
 * Copyright (c) 2012. klopaj.com
 */

package com.klopaj.rest

/**
 * Response message is used to send response back to the client via REST service.<br />
 * <b>code</b> should contain this message's code (number identifying error code).<br />
 * <b>message</b> should be in human readable format
 */
class ResponseMessage {
	String code;
	String message;
}
