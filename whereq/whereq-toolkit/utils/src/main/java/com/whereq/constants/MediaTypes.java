package com.whereq.constants;

/**
 * MediaType with UTF-8 charset;
 * 
 * Jax-RS and Spring MediaType don't have UTF-8;
 * 
 * Google'MediaType has to invoke toString() to get the string instead of a constant, it's not able to be used in Restful method's annotation;
 * 
 * @author bacon
 */
public class MediaTypes {
	
	private MediaTypes() {};

	public static final String APPLICATION_XML = "application/xml";
	public static final String APPLICATION_XML_UTF_8 = "application/xml; charset=UTF-8";

	public static final String JSON = "application/json";
	public static final String JSON_UTF_8 = "application/json; charset=UTF-8";

	public static final String JAVASCRIPT = "application/javascript";
	public static final String JAVASCRIPT_UTF_8 = "application/javascript; charset=UTF-8";

	public static final String APPLICATION_XHTML_XML = "application/xhtml+xml";
	public static final String APPLICATION_XHTML_XML_UTF_8 = "application/xhtml+xml; charset=UTF-8";

	public static final String TEXT_PLAIN = "text/plain";
	public static final String TEXT_PLAIN_UTF_8 = "text/plain; charset=UTF-8";

	public static final String TEXT_XML = "text/xml";
	public static final String TEXT_XML_UTF_8 = "text/xml; charset=UTF-8";

	public static final String TEXT_HTML = "text/html";
	public static final String TEXT_HTML_UTF_8 = "text/html; charset=UTF-8";
}
