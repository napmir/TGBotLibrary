package com.tgbotlibrary.services;

import java.util.concurrent.ConcurrentMap;

import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.tgbotlibrary.response.Message;
import com.tgbotlibrary.response.Update;
import com.tgbotlibrary.utils.CacheService;

@Service
public class CacheServiceImpl implements CacheService {

	private ConcurrentMap<String, Message> cache = Maps.newConcurrentMap();

	@Override
	public boolean containsUpdate(final Update update) {
		return cache.containsKey(update.getId().toString());
	}

	@Override
	public boolean add(final Update update) {
		if (!containsUpdate(update)) {
			cache.put(update.getId().toString(), update.getMessage());
			return true;
		}
		return false;

	}
}
