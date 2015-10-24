package com.tgbotlibrary.request;

import java.io.File;

import com.tgbotlibrary.enums.ActionTypeEnum;
import com.tgbotlibrary.response.ReplyKeyboard;

public interface TGRequestCreator {

	TGRequest getMe();

	TGRequest sendMessage(final long chatId, final String text, final boolean disableWebPagePreview,
			final Long replyToMessageId, final String parseMode, final ReplyKeyboard replyKeyboard);

	TGRequest forwardMessage(final long chatId, final int fromChatId, final int messageId);

	TGRequest sendPhoto(final long chatId, final File inputFile, final String caption, final Long replyToMessageId,
			final ReplyKeyboard replyKeyboard);

	TGRequest sendPhoto(final long chatId, final String photoID, final String caption, final Long replyToMessageId,
			final ReplyKeyboard replyKeyboard);

	TGRequest sendAudio(final long chatId, final File inputFile, final String title, final String performer,
			final Integer duration, final Long replyToMessageId, final ReplyKeyboard replyKeyboard);

	TGRequest sendAudio(final long chatId, final String audioID, final String title, final String performer,
			final Integer duration, final Long replyToMessageId, final ReplyKeyboard replyKeyboard);

	TGRequest sendDocument(final long chatId, final File inputFile, final Long replyToMessageId,
			final ReplyKeyboard replyKeyboard);

	TGRequest sendDocument(final long chatId, final String documentID, final Long replyToMessageId,
			final ReplyKeyboard replyKeyboard);

	TGRequest sendSticker(final long chatId, final File inputFile, final Long replyToMessageId,
			final ReplyKeyboard replyKeyboard);

	TGRequest sendSticker(final long chatId, final String stickerID, final Long replyToMessageId,
			final ReplyKeyboard replyKeyboard);

	TGRequest sendVideo(final long chatId, final File inputFile, final Integer duration, final String caption,
			final Long replyToMessageId, final ReplyKeyboard replyKeyboard);

	TGRequest sendVideo(final long chatId, final String videoID, final Integer duration, final String caption,
			final Long replyToMessageId, final ReplyKeyboard replyKeyboard);

	TGRequest sendVoice(final long chatId, final File inputFile, final Integer duration, final String caption,
			final Long replyToMessageId, final ReplyKeyboard replyKeyboard);

	TGRequest sendVoice(final long chatId, final String voiceID, final Integer duration, final String caption,
			final Long replyToMessageId, final ReplyKeyboard replyKeyboard);

	TGRequest sendLocation(final long chatId, final double latitude, final double longitude,
			final Long replyToMessageId, final ReplyKeyboard replyKeyboard);

	TGRequest sendChatAction(final long chatId, final ActionTypeEnum actionType);

	TGRequest getUserProfilePhotos(final long userId, final Integer offset, final Integer limit);

	TGRequest getUpdates(final Long offset, final Long limit, final Long timeout);

	TGRequest setWebhook(final String url);

	TGRequest getFile(final String fileID, final Long fileSize, final String filePath);

}
