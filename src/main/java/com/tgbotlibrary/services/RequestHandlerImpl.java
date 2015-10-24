package com.tgbotlibrary.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

import com.tgbotlibrary.enums.RequestTypeEnum;
import com.tgbotlibrary.interactions.InteractionListenerAbstract;
import com.tgbotlibrary.request.TGRequest;
import com.tgbotlibrary.response.TGResponse;
import com.tgbotlibrary.utils.JsonUtils;


public class RequestHandlerImpl implements RequestHandler {

	protected static final Logger LOG = Logger.getLogger(RequestHandlerImpl.class);

	@Autowired
	private HttpService httpService;

	@Override
	public TGResponse<?> sendRequest(TGRequest tgRequest) {
		if(tgRequest.getRequestType() != RequestTypeEnum.GET_UPDATES){
			LOG.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}
		String stringResponse = getHttpService().getStringResponse(tgRequest);
		TGResponse<?> telegramResponse = JsonUtils.parseJsonResponse(stringResponse, tgRequest.getRequestType().getResultClass());

		return telegramResponse;
	}

	public HttpService getHttpService() {
		return httpService;
	}
	@Required
	public void setHttpService(HttpService httpService) {
		this.httpService = httpService;
	}

}
