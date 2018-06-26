package com.db_clear.utils.http;

import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class HttpClientResponse {
	private static final String ok = "200";
	private String stateCode;
	private String response;
	private Map<String, String> headers;
	private JSONObject result;

	public boolean isSuccess() {
		return ok.equals(this.stateCode);
	}

	public void result(String response) {
		this.result = JSON.parseObject(response);
	}

	public String getStateCode() {
		return this.stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getResponse() {
		return this.response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}

	public JSONObject getResult() {
		return result;
	}

	public void setResult(JSONObject result) {
		this.result = result;
	}

}
