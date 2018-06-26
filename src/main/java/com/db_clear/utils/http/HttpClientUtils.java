package com.db_clear.utils.http;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.db_clear.exceptions.server.ServerCode50000Exception;
import com.db_clear.utils.charset.CharsetUtils;
import com.db_clear.utils.collection.MapUtils;
import com.db_clear.utils.string.StringUtils;

/**
 * @title:TODO httpclient 工具类
 * @Description:
 * @author: tuhejie
 * @PackageName: com.thj.utils.http
 * @ClassName: HttpClientUtils
 * @Date: 2018年6月14日 下午4:18:59
 */
public class HttpClientUtils {

	private Logger logger = LoggerFactory.getLogger(getClass());

	private CloseableHttpClient httpclient;

	/**
	 * @title:TODO httpclient get 请求
	 * @Description:
	 * @Author: tuhejie
	 * @Date: 2018年6月14日 下午4:19:30
	 * @param url
	 *            请求url
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static HttpClientResponse doGet(String url) throws ClientProtocolException, IOException {
		return doGet(url, null);
	}

	/**
	 * @title:TODO httpclient get 请求
	 * @Description:
	 * @Author: tuhejie
	 * @Date: 2018年6月14日 下午4:20:04
	 * @param url
	 *            请求url
	 * @param headers
	 *            请求头map
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static HttpClientResponse doGet(String url, Map<String, String> headers)
			throws ClientProtocolException, IOException {
		return doGet(url, headers, null);
	}

	/**
	 * @title:TODO httpclient get 请求
	 * @Description:
	 * @Author: tuhejie
	 * @Date: 2018年6月14日 下午4:20:43
	 * @param url
	 *            请求url
	 * @param headers
	 *            请求头map
	 * @param query
	 *            queryString类型的参数键值对map
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static HttpClientResponse doGet(String url, Map<String, String> headers, Map<String, String> query)
			throws ClientProtocolException, IOException {
		return doGet(url, headers, query, null);
	}

	/**
	 * @title:TODO httpclient get 请求
	 * @Description:
	 * @Author: tuhejie
	 * @Date: 2018年6月14日 下午4:21:21
	 * @param url
	 *            请求url
	 * @param headers
	 *            请求头map
	 * @param query
	 *            queryString类型的参数键值对map
	 * @param path
	 *            path类型的参数键值对map
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static HttpClientResponse doGet(String url, Map<String, String> headers, Map<String, String> query,
			Map<String, String> path) throws ClientProtocolException, IOException {
		return doGet(url, headers, query, path, null);
	}

	/**
	 * @title:TODO httpclient get 请求
	 * @Description:
	 * @Author: tuhejie
	 * @Date: 2018年6月14日 下午4:21:58
	 * @param url
	 *            请求url
	 * @param headers
	 *            请求头map
	 * @param query
	 *            queryString类型的参数键值对map
	 * @param path
	 *            path类型的参数键值对map
	 * @param charSet
	 *            请求内容及响应内容字符编码, 默认UTF-8
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static HttpClientResponse doGet(String url, Map<String, String> headers, Map<String, String> query,
			Map<String, String> path, String charSet) throws ClientProtocolException, IOException {
		return doGet(url, headers, query, path, charSet, null);
	}

	/**
	 * @title:TODO httpclient get 请求
	 * @Description:
	 * @Author: tuhejie
	 * @Date: 2018年6月14日 下午4:22:40
	 * @param url
	 *            请求url
	 * @param headers
	 *            请求头map
	 * @param query
	 *            queryString类型的参数键值对map
	 * @param path
	 *            path类型的参数键值对map
	 * @param charSet
	 *            请求内容及响应内容字符编码, 默认UTF-8
	 * @param timeout
	 *            请求超时时间
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static HttpClientResponse doGet(String url, Map<String, String> headers, Map<String, String> query,
			Map<String, String> path, String charSet, Integer timeout) throws ClientProtocolException, IOException {
		HttpClientUtils httpClient = new HttpClientUtils();
		httpClient.init();
		HttpClientResponse response = httpClient.get(httpClient.formatUrl(url, query, path), headers, charSet, timeout);
		httpClient.close();
		return response;
	}

	/**
	 * @title:TODO httpclient put 请求
	 * @Description:
	 * @Author: tuhejie
	 * @Date: 2018年6月14日 下午4:23:44
	 * @param url 请求url
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static HttpClientResponse doPut(String url) throws ClientProtocolException, IOException {
		return doPut(url, null);
	}

	/**
	 * @title:TODO httpclient put 请求
	 * @Description:
	 * @Author: tuhejie
	 * @Date: 2018年6月14日 下午4:24:07
	 * @param url 请求url
	 * @param headers 请求头map
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static HttpClientResponse doPut(String url, Map<String, String> headers)
			throws ClientProtocolException, IOException {
		return doPut(url, headers, null);
	}

	/**
	 * @title:TODO httpclient put 请求
	 * @Description:
	 * @Author: tuhejie
	 * @Date: 2018年6月14日 下午4:24:36
	 * @param url 请求url
	 * @param headers 请求头map
	 * @param query queryString类型的参数键值对map
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static HttpClientResponse doPut(String url, Map<String, String> headers, Map<String, String> query)
			throws ClientProtocolException, IOException {
		return doPut(url, headers, query, null);
	}

	/**
	 * @title:TODO httpclient put 请求
	 * @Description:
	 * @Author: tuhejie
	 * @Date: 2018年6月14日 下午4:25:04
	 * @param url 请求url
	 * @param headers 请求头map
	 * @param query queryString类型的参数键值对map
	 * @param path path类型的参数键值对map
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static HttpClientResponse doPut(String url, Map<String, String> headers, Map<String, String> query,
			Map<String, String> path) throws ClientProtocolException, IOException {
		return doPut(url, headers, query, path, null);
	}

	/**
	 * @title:TODO httpclient put 请求
	 * @Description:
	 * @Author: tuhejie
	 * @Date: 2018年6月14日 下午4:25:41
	 * @param url 请求url
	 * @param headers 请求头map
	 * @param query queryString类型的参数键值对map
	 * @param path path类型的参数键值对map
	 * @param body 请求内容
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static HttpClientResponse doPut(String url, Map<String, String> headers, Map<String, String> query,
			Map<String, String> path, String body) throws ClientProtocolException, IOException {
		return doPut(url, headers, query, path, body, null);
	}

	/**
	 * @title: TODO httpclient put 请求
	 * @description: http put 请求
	 * @author: create by tuhejie
	 * @date: 2017年12月12日 下午2:39:37
	 * @param url
	 *            请求url
	 * @param headers
	 *            请求头map
	 * @param query
	 *            queryString类型的参数键值对map
	 * @param path
	 *            path类型的参数键值对map
	 * @param body
	 *            请求内容
	 * @param charSet
	 *            请求内容及响应内容字符编码
	 * @return
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static HttpClientResponse doPut(String url, Map<String, String> headers, Map<String, String> query,
			Map<String, String> path, String body, String charSet) throws ClientProtocolException, IOException {
		return doPut(url, headers, query, path, body, charSet, null);
	}

	/**
	 * @title: TODO httpclient put 请求
	 * @description: http put 请求
	 * @author: create by tuhejie
	 * @date: 2017年12月12日 下午2:39:37
	 * @param url
	 *            请求url
	 * @param headers
	 *            请求头map
	 * @param query
	 *            queryString类型的参数键值对map
	 * @param path
	 *            path类型的参数键值对map
	 * @param body
	 *            请求内容
	 * @param charSet
	 *            请求内容及响应内容字符编码
	 * @param timeout
	 *            请求超时时间
	 * @return
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static HttpClientResponse doPut(String url, Map<String, String> headers, Map<String, String> query,
			Map<String, String> path, String body, String charSet, Integer timeout)
			throws ClientProtocolException, IOException {
		HttpClientUtils httpClient = new HttpClientUtils();
		httpClient.init();
		HttpClientResponse response = httpClient.put(httpClient.formatUrl(url, query, path), headers, body, charSet,
				timeout);
		httpClient.close();
		return response;
	}

	/**
	 * @title: TODO httpclient delete 请求
	 * @description: http delete 请求
	 * @author: create by tuhejie
	 * @date: 2017年12月12日 下午2:39:37
	 * @param url
	 *            请求url
	 * @return
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static HttpClientResponse doDelete(String url) throws ClientProtocolException, IOException {
		return doDelete(url, null);
	}

	/**
	 * @title: TODO httpclient delete 请求
	 * @description: http delete 请求
	 * @author: create by tuhejie
	 * @date: 2017年12月12日 下午2:39:37
	 * @param url
	 *            请求url
	 * @param headers
	 *            请求头map
	 * @return
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static HttpClientResponse doDelete(String url, Map<String, String> headers)
			throws ClientProtocolException, IOException {
		return doDelete(url, headers, null);
	}

	/**
	 * @title: TODO httpclient delete 请求
	 * @description: http delete 请求
	 * @author: create by tuhejie
	 * @date: 2017年12月12日 下午2:39:37
	 * @param url
	 *            请求url
	 * @param headers
	 *            请求头map
	 * @param query
	 *            queryString类型的参数键值对map
	 * @return
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static HttpClientResponse doDelete(String url, Map<String, String> headers, Map<String, String> query)
			throws ClientProtocolException, IOException {
		return doDelete(url, headers, query, null);
	}

	/**
	 * @title: TODO httpclient delete 请求
	 * @description: http delete 请求
	 * @author: create by tuhejie
	 * @date: 2017年12月12日 下午2:39:37
	 * @param url
	 *            请求url
	 * @param headers
	 *            请求头map
	 * @param query
	 *            queryString类型的参数键值对map
	 * @param path
	 *            path类型的参数键值对map
	 * @return
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static HttpClientResponse doDelete(String url, Map<String, String> headers, Map<String, String> query,
			Map<String, String> path) throws ClientProtocolException, IOException {
		return doDelete(url, headers, query, path, null);
	}

	/**
	 * @title: TODO httpclient delete 请求
	 * @description: http delete 请求
	 * @author: create by tuhejie
	 * @date: 2017年12月12日 下午2:39:37
	 * @param url
	 *            请求url
	 * @param headers
	 *            请求头map
	 * @param query
	 *            queryString类型的参数键值对map
	 * @param path
	 *            path类型的参数键值对map
	 * @param charSet
	 *            请求内容及响应内容字符编码
	 * @return
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static HttpClientResponse doDelete(String url, Map<String, String> headers, Map<String, String> query,
			Map<String, String> path, String charSet) throws ClientProtocolException, IOException {
		return doDelete(url, headers, query, path, charSet, null);
	}

	/**
	 * @title: TODO httpclient delete 请求
	 * @description: http delete 请求
	 * @author: create by tuhejie
	 * @date: 2017年12月12日 下午2:39:37
	 * @param url
	 *            请求url
	 * @param headers
	 *            请求头map
	 * @param query
	 *            queryString类型的参数键值对map
	 * @param path
	 *            path类型的参数键值对map
	 * @param charSet
	 *            请求内容及响应内容字符编码
	 * @param timeout
	 *            请求超时时间
	 * @return
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static HttpClientResponse doDelete(String url, Map<String, String> headers, Map<String, String> query,
			Map<String, String> path, String charSet, Integer timeout) throws ClientProtocolException, IOException {
		HttpClientUtils httpClient = new HttpClientUtils();
		httpClient.init();
		HttpClientResponse response = httpClient.delete(httpClient.formatUrl(url, query, path), headers, charSet,
				timeout);
		httpClient.close();
		return response;
	}

	/**
	 * @title: TODO httpclient post 请求
	 * @description: http post 请求
	 * @author: create by tuhejie
	 * @date: 2017年12月12日 下午2:39:37
	 * @param url
	 *            请求url
	 * @return
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static HttpClientResponse doPost(String url) throws ClientProtocolException, IOException {
		return doPost(url, null);
	}

	/**
	 * @title: TODO httpclient post 请求
	 * @description: http post 请求
	 * @author: create by tuhejie
	 * @date: 2017年12月12日 下午2:39:37
	 * @param url
	 *            请求url
	 * @param headers
	 *            请求头map
	 * @return
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static HttpClientResponse doPost(String url, Map<String, String> headers)
			throws ClientProtocolException, IOException {
		return doPost(url, headers, null);
	}

	/**
	 * @title: TODO httpclient post 请求
	 * @description: http post 请求
	 * @author: create by tuhejie
	 * @date: 2017年12月12日 下午2:39:37
	 * @param url
	 *            请求url
	 * @param headers
	 *            请求头map
	 * @param query
	 *            queryString类型的参数键值对map
	 * @return
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static HttpClientResponse doPost(String url, Map<String, String> headers, Map<String, String> query)
			throws ClientProtocolException, IOException {
		return doPost(url, headers, query, null);
	}

	/**
	 * @title: TODO httpclient post 请求
	 * @description: http post 请求
	 * @author: create by tuhejie
	 * @date: 2017年12月12日 下午2:39:37
	 * @param url
	 *            请求url
	 * @param headers
	 *            请求头map
	 * @param query
	 *            queryString类型的参数键值对map
	 * @param path
	 *            path类型的参数键值对map
	 * @return
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static HttpClientResponse doPost(String url, Map<String, String> headers, Map<String, String> query,
			Map<String, String> path) throws ClientProtocolException, IOException {
		return doPost(url, headers, query, path, null);
	}

	/**
	 * @title: TODO httpclient post 请求
	 * @description: http post 请求
	 * @author: create by tuhejie
	 * @date: 2017年12月12日 下午2:39:37
	 * @param url
	 *            请求url
	 * @param headers
	 *            请求头map
	 * @param query
	 *            queryString类型的参数键值对map
	 * @param path
	 *            path类型的参数键值对map
	 * @param body
	 *            请求内容
	 * @return
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static HttpClientResponse doPost(String url, Map<String, String> headers, Map<String, String> query,
			Map<String, String> path, String body) throws ClientProtocolException, IOException {
		return doPost(url, headers, query, path, body, null);
	}

	/**
	 * @title: TODO httpclient post 请求
	 * @description: http post 请求
	 * @author: create by tuhejie
	 * @date: 2017年12月12日 下午2:39:37
	 * @param url
	 *            请求url
	 * @param headers
	 *            请求头map
	 * @param query
	 *            queryString类型的参数键值对map
	 * @param path
	 *            path类型的参数键值对map
	 * @param body
	 *            请求内容
	 * @param charSet
	 *            请求内容及响应内容字符编码
	 * @return
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static HttpClientResponse doPost(String url, Map<String, String> headers, Map<String, String> query,
			Map<String, String> path, String body, String charSet) throws ClientProtocolException, IOException {
		return doPost(url, headers, query, path, body, charSet, null);
	}

	/**
	 * @title: TODO httpclient post 请求
	 * @description: http post 请求
	 * @author: create by tuhejie
	 * @date: 2017年12月12日 下午2:39:37
	 * @param url
	 *            请求url
	 * @param headers
	 *            请求头map
	 * @param query
	 *            queryString类型的参数键值对map
	 * @param path
	 *            path类型的参数键值对map
	 * @param body
	 *            请求内容
	 * @param charSet
	 *            请求内容及响应内容字符编码
	 * @param timeout
	 *            请求超时时间
	 * @return
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static HttpClientResponse doPost(String url, Map<String, String> headers, Map<String, String> query,
			Map<String, String> path, String body, String charSet, Integer timeout)
			throws ClientProtocolException, IOException {
		HttpClientUtils httpClient = new HttpClientUtils();
		httpClient.init();
		HttpClientResponse response = httpClient.post(httpClient.formatUrl(url, query, path), headers, body, charSet,
				timeout);
		httpClient.close();
		return response;
	}

	/**
	 * @title: TODO 初始化httpclient
	 * @description:
	 * @author: create by tuhejie
	 * @date: 2017年12月12日 下午3:16:40
	 */
	private void init() {
		this.httpclient = HttpClientBuilder.create().build();
	}

	/**
	 * @title: TODO 关闭httpclient
	 * @description:
	 * @author: create by tuhejie
	 * @date: 2017年12月12日 下午3:16:40
	 */
	private void close() {
		org.apache.http.client.utils.HttpClientUtils.closeQuietly(this.httpclient);
	}

	private HttpClientResponse get(String url, Map<String, String> headers, String charSet, Integer timeout)
			throws ClientProtocolException, IOException {
		HttpGet httpGet = new HttpGet(url);
		return sendHTTPRequest(httpGet, headers, null, charSet, timeout);
	}

	private HttpClientResponse put(String url, Map<String, String> headers, String body, String charSet,
			Integer timeout) throws ClientProtocolException, IOException {
		HttpPut httpPut = new HttpPut(url);
		return sendHTTPRequest(httpPut, headers, body, charSet, timeout);
	}

	private HttpClientResponse delete(String url, Map<String, String> headers, String charSet, Integer timeout)
			throws ClientProtocolException, IOException {
		HttpDelete httpDelete = new HttpDelete(url);
		return sendHTTPRequest(httpDelete, headers, null, charSet, timeout);
	}

	private HttpClientResponse post(String url, Map<String, String> headers, String body, String charSet,
			Integer timeout) throws ClientProtocolException, IOException {
		HttpPost httpPost = new HttpPost(url);
		return sendHTTPRequest(httpPost, headers, body, charSet, timeout);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private HttpClientResponse sendHTTPRequest(HttpRequestBase httpRequestBase, Map<String, String> headers,
			String body, String charSet, Integer timeout) throws ClientProtocolException, IOException {
		HttpClientResponse httpClientResponse = new HttpClientResponse();
		if (null != timeout) {
			RequestConfig config = RequestConfig.custom().setConnectTimeout(timeout).setSocketTimeout(timeout)
					.setConnectionRequestTimeout(timeout).build();
			httpRequestBase.setConfig(config);
		}
		if (StringUtils.isBlank(charSet)) {
			charSet = CharsetUtils.UTF_8;
		}
		if (MapUtils.isNotEmpty(headers)) {
			convertHeaderCharsetToIso88591(headers);
			Set<Entry<String, String>> entrySet = headers.entrySet();
			for (Entry<String, String> entry : entrySet) {
				httpRequestBase.setHeader(entry.getKey(), entry.getValue());
			}
		}
		if (StringUtils.isNotBlank(body) && ((httpRequestBase instanceof HttpEntityEnclosingRequestBase))) {
			((HttpEntityEnclosingRequestBase) httpRequestBase).setEntity(new StringEntity(body, charSet));
		}
		CloseableHttpResponse response = this.httpclient.execute(httpRequestBase);
		httpClientResponse.setStateCode(response.getStatusLine().toString().split(" ")[1]);
		Header[] responseHeaders = response.getAllHeaders();
		HashMap<String, String> responseHeadersMap = new HashMap();
		for (int i = 0; i < responseHeaders.length; i++) {
			Header header = responseHeaders[i];
			responseHeadersMap.put(header.getName(), header.getValue());
		}
		if (MapUtils.isNotEmpty(responseHeadersMap)) {
			convertHeaderCharsetFromIso88591(responseHeadersMap);
		}
		httpClientResponse.setHeaders(responseHeadersMap);
		try {
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				String res = EntityUtils.toString(entity, charSet);
				httpClientResponse.setResponse(res);
			}
		} finally {
			response.close();
		}
		return httpClientResponse;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private String formatUrl(String url, Map<String, String> query, Map<String, String> path) {
		String result = StringUtils.EMPTY;
		if (MapUtils.isNotEmpty(path)) {
			String patternString = "\\{(" + StringUtils.join(path.keySet(), "|") + ")\\}";
			Pattern pattern = Pattern.compile(patternString);
			Matcher matcher = pattern.matcher(url);
			StringBuffer sb = new StringBuffer();
			while (matcher.find()) {
				matcher.appendReplacement(sb, (String) path.get(matcher.group(1)));
			}
			matcher.appendTail(sb);
			result = result + sb.toString();
		} else {
			result = url;
		}
		if (MapUtils.isNotEmpty(query)) {
			String params = StringUtils.EMPTY;
			Iterator<Map.Entry<String, String>> iter = query.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry<String, String> entry = (Map.Entry) iter.next();
				if (null != entry.getValue()) {
					params = params + (String) entry.getKey() + StringUtils.EQUAL_SIGN
							+ urlEncode((String) entry.getValue()) + StringUtils.AND_SIGN;
				}
			}
			result = result + StringUtils.QUESTION_MARK + params.substring(0, params.length() - 1);
		}
		return result.toString();
	}

	private String urlEncode(String url) {
		String encodeString = StringUtils.EMPTY;
		try {
			encodeString = URLEncoder.encode(url, CharsetUtils.UTF_8);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return encodeString;
	}

	// To fix the bug that the header value could not be unicode chars.
	// Because HTTP headers are encoded in iso-8859-1,
	// we need to convert the utf-8(java encoding) strings to iso-8859-1 ones.
	private void convertHeaderCharsetFromIso88591(Map<String, String> headers) {
		convertHeaderCharset(headers, CharsetUtils.ISO_8859_1, CharsetUtils.UTF_8);
	}

	// For response, convert from iso-8859-1 to utf-8.
	private void convertHeaderCharsetToIso88591(Map<String, String> headers) {
		convertHeaderCharset(headers, CharsetUtils.UTF_8, CharsetUtils.ISO_8859_1);
	}

	private void convertHeaderCharset(Map<String, String> headers, String fromCharset, String toCharset) {

		for (Map.Entry<String, String> header : headers.entrySet()) {
			if (header.getValue() == null) {
				continue;
			}

			try {
				header.setValue(new String(header.getValue().getBytes(fromCharset), toCharset));
			} catch (UnsupportedEncodingException e) {
				logger.error("HttpClient Header 编码转化异常:{}", ExceptionUtils.getStackTrace(e));
				throw new ServerCode50000Exception("HttpClient Header 编码转化异常");
			}
		}
	}

}
