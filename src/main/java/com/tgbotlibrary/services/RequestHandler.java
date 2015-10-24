package com.tgbotlibrary.services;

import com.tgbotlibrary.request.TGRequest;
import com.tgbotlibrary.response.TGResponse;

public interface RequestHandler {

	TGResponse<?> sendRequest(TGRequest tgRequest);

}
