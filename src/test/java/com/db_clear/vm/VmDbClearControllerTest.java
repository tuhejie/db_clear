package com.db_clear.vm;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.junit.Test;

import com.db_clear.base.BaseTest;
import com.db_clear.utils.charset.CharsetUtils;
import com.db_clear.utils.http.HttpClientResponse;
import com.db_clear.utils.http.HttpClientUtils;

public class VmDbClearControllerTest extends BaseTest {
	
	String url = "http://127.0.0.1:7070/db_clear";
	
	@Test
	public void testClearVmAddress() throws ClientProtocolException, IOException {
		url += "/clear_vm";
		HttpClientResponse response = HttpClientUtils.doPost(url, null, null, null, null, CharsetUtils.UTF_8);
		String result = response.getResponse();
		logger.debug("设备数据清理结果:\n{}", result);
	}
}
