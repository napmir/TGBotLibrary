package com.tgbotlibrary.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.util.List;

import org.apache.http.Consts;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.tgbotlibrary.enums.CommonEnum;
import com.tgbotlibrary.request.TGRequest;
import com.tgbotlibrary.utils.CommonUtils;
import com.tgbotlibrary.utils.Config;

@Component
public class HttpServiceImpl implements HttpService {

	private static final Logger LOG = Logger.getLogger(HttpServiceImpl.class);

	@Override
	public String getStringResponse(TGRequest tgRequest) {
		final String requestURL = CommonUtils.getMethodUrl(tgRequest.getRequestType().getMethodName());

		final HttpPost httpRequest = new HttpPost(requestURL);
		final HttpClient httpClient = HttpClientFactory.createHttpClient();

		setRequestEntity(tgRequest, httpRequest);
		addProxyIfNeeded(httpRequest);

		try {
			HttpResponse response = httpClient.execute(httpRequest);
			BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = reader.readLine()) != null) {
				result.append(line);
			}

			if (response.getStatusLine().getStatusCode() != 200) {
				LOG.error(MessageFormat.format("Telegram response error code {}, reason: {} ",
						response.getStatusLine().getStatusCode(), response.getStatusLine().getReasonPhrase()));
				return null;
			}

			return result.toString();
		} catch (IOException e) {
			LOG.error("Something went wrong in response", e);
		}

		return null;

	}

	private void addProxyIfNeeded(final HttpPost httpRequest) {
		boolean isProxyEnabled = Config.getProperty(CommonEnum.Config.Proxy.Enabled, false);

		//LOG.info("Proxy enabled: " + isProxyEnabled);

		if (isProxyEnabled) {
			String host = Config.getProperty(CommonEnum.Config.Proxy.Host, "");
			String protocol = Config.getProperty(CommonEnum.Config.Proxy.Protocol, "");
			int port = Config.getProperty(CommonEnum.Config.Proxy.Port, 0);

			LOG.info("Proxy host: " + host);
			LOG.info("Proxy port: " + port);
			LOG.info("Proxy protocol: " + protocol);

			if (!StringUtils.isEmpty(host) && !StringUtils.isEmpty(protocol) && port > 0) {
				HttpHost proxyHost = new HttpHost(host, port, protocol);
				RequestConfig config = RequestConfig.custom().setProxy(proxyHost).build();
				httpRequest.setConfig(config);
			} else {
				LOG.error("Proxy enabled but wrong configuration, skipping...");
			}
		}
	}

	private void setRequestEntity(TGRequest tgRequest, final HttpPost request) {
		List<BasicNameValuePair> requestParams = tgRequest.getParameters();
		if (tgRequest.getFile() != null) {
			final MultipartEntityBuilder mpeb = MultipartEntityBuilder.create();
			mpeb.addBinaryBody(tgRequest.getFileType(), tgRequest.getFile());
			for (BasicNameValuePair bnvp : requestParams) {
				mpeb.addTextBody(bnvp.getName(), bnvp.getValue());
			}

			request.setEntity(mpeb.build());
		} else {
			request.setEntity(new UrlEncodedFormEntity(requestParams, Consts.UTF_8));
		}
	}
}
