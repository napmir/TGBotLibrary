package com.tgbotlibrary.utils;

import com.tgbotlibrary.response.Update;

public interface CacheService {

	boolean containsUpdate(Update update);

	boolean add(Update update);

}
