package com.tgbotlibrary.interactions;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

import com.tgbotlibrary.enums.CommonEnum;
import com.tgbotlibrary.request.TGRequest;
import com.tgbotlibrary.request.TGRequestCreator;
import com.tgbotlibrary.response.TGResponse;
import com.tgbotlibrary.response.Update;
import com.tgbotlibrary.services.RequestHandler;
import com.tgbotlibrary.utils.CacheService;
import com.tgbotlibrary.utils.JsonUtils.MapperHandler;

public class InteractionListenerImpl extends InteractionListenerAbstract {

	private static final Logger LOG = Logger.getLogger(InteractionListenerImpl.class);
	private Long offset;
	private Integer limit;
	private Integer timeout;

	@Autowired
	private RequestHandler requestHandler;

	@Autowired
	private TGRequestCreator tgRequestCreator;

	@Autowired
	private CacheService cacheService;

	@Autowired
	private InteractionFactory interactionFactory;
	@Autowired
	private InteractionDispatcher interactionDispatcher;

	@Override
	public void retrieveInteractions() {

		TGRequest request = tgRequestCreator.getUpdates(getOffset().longValue(), getLimit().longValue(),
				getTimeout().longValue());

		if (request != null) {
			TGResponse<?> response = requestHandler.sendRequest(request);
			// LOG.warn("Request: " + response != null &&
			// response.getDescription() != null?
			// response.getDescription().toString() : " null");
			if (response != null) {
				if (response.getOk()) {
					// LOG.warn("Response results " +
					// response.getResult().size());
					handleUpdates(response);
				} else {
					LOG.error("Telegram response was unsuccessful: [" + response.getErrorCode() + "] "
							+ response.getDescription());
				}
			} else {
				LOG.error("Telegram respons is null");
			}
		} else {
			LOG.error("Request is null");
		}
	}

	private void handleUpdates(final TGResponse<?> response) {
		//LOG.info("handling updates");
		for (final Object updateObj : response.getResult()) {
			// String jsonString = new JSONObject(updateObj).toString()
			// MapperHandler.INSTANCE
			// .getObjectMapper().readValue(
			// updateObj, Update.class
			// );

			final Update update = (Update) updateObj;

			LOG.trace("Watching... UpdateId:" + update.getId() + " - MessageID:" + update.getMessage().getId() + " - "
					+ update.getMessage().getFrom().getId() + ":" + update.getMessage().getFrom().getUsername());

			if (!cacheService.containsUpdate(update)) {
				boolean result = cacheService.add(update);
				if (result) {
					final Interaction interaction = getInteractionFactory().createInteraction(update.getMessage());
					
					getInteractionDispatcher().enqueue(interaction);

					// Update offset in order to fetch a new slot the next time
					setOffset(update.getId().longValue() + 1L);
				}
			}
		}

	}

	public InteractionFactory getInteractionFactory() {
		return interactionFactory;
	}

	@Required
	public void setInteractionFactory(InteractionFactory interactionFactory) {
		this.interactionFactory = interactionFactory;
	}

	public InteractionDispatcher getInteractionDispatcher() {
		return interactionDispatcher;
	}

	@Required
	public void setInteractionDispatcher(InteractionDispatcher interactionDispatcher) {
		this.interactionDispatcher = interactionDispatcher;
	}

	public Long getOffset() {
		return offset;
	}

	@Required
	public void setOffset(Long offset) {
		this.offset = offset;
	}

	public Integer getLimit() {
		return limit;
	}

	@Required
	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer getTimeout() {
		return timeout;
	}

	@Required
	public void setTimeout(Integer timeout) {
		this.timeout = timeout;
	}

}
