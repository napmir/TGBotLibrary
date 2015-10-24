package com.tgbotlibrary.request;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.tgbotlibrary.enums.ActionTypeEnum;
import com.tgbotlibrary.enums.RequestTypeEnum;
import com.tgbotlibrary.enums.TGRequestFieldEnum;
import com.tgbotlibrary.response.ReplyKeyboard;

@Service
public class TGRequestCreatorImpl implements TGRequestCreator {

	@Override
	public TGRequest getMe() {
		return new TGRequest(RequestTypeEnum.GET_ME, new ArrayList<BasicNameValuePair>());
	}

	@Override
	public TGRequest sendMessage(final long chatId, final String text, final boolean disableWebPagePreview,
			final Long replyToMessageId, final String parseMode, final ReplyKeyboard replyKeyboard) {

		List<BasicNameValuePair> basicNameValuePair = Lists.newArrayList();

		addNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendMessage.ChatID, String.valueOf(chatId));
		addNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendMessage.Text, text);

		// optionals
		addNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendMessage.DisableWebPagePreview,
				String.valueOf(disableWebPagePreview));

		addNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendMessage.ParseMode, parseMode);
		if (replyToMessageId != null) {
			addOptionalNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendMessage.ReplyToMessageID,
					replyToMessageId);
		}
		if (replyKeyboard != null) {
			addOptionalNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendMessage.ReplyMarkup,
					replyKeyboard);
		}
		return new TGRequest(RequestTypeEnum.SEND_MESSAGE, basicNameValuePair);

	}

	@Override
	public TGRequest forwardMessage(final long chatId, final int fromChatId, final int messageId) {
		List<BasicNameValuePair> basicNameValuePair = Lists.newArrayList();

		addNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.ForwardMessage.ChatID, String.valueOf(chatId));
		addNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.ForwardMessage.FromChatID,
				String.valueOf(fromChatId));
		addNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.ForwardMessage.MessageID,
				String.valueOf(messageId));

		return new TGRequest(RequestTypeEnum.SEND_MESSAGE, basicNameValuePair);
	}

	@Override
	public TGRequest sendPhoto(final long chatId, final File inputFile, final String caption,
			final Long replyToMessageId, final ReplyKeyboard replyKeyboard) {
		List<BasicNameValuePair> basicNameValuePair = Lists.newArrayList();

		addNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendPhoto.ChatID, String.valueOf(chatId));

		addOptionalNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendPhoto.Caption, caption);
		addOptionalNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendPhoto.ReplyToMessageID,
				replyToMessageId);
		addOptionalNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendPhoto.ReplyMarkup, replyKeyboard);

		// chat_id Integer or String Yes Unique identifier for the target chat
		// or username of the target channel (in the format @channelusername)
		// photo InputFile or String Yes Photo to send. You can either pass a
		// file_id as String to resend a photo that is already on the Telegram
		// servers, or upload a new photo using multipart/form-data.
		// caption String Optional Photo caption (may also be used when
		// resending photos by file_id).
		// reply_to_message_id Integer Optional If the message is a reply, ID of
		// the original message
		// reply_markup ReplyKeyboardMarkup or ReplyKeyboardHide or ForceReply
		// Optional Additional interface options. A JSON-serialized object for a
		// custom reply keyboard, instructions to hide keyboard or to force a
		// reply from the user.
		//

		return new TGRequest(RequestTypeEnum.SEND_PHOTO, basicNameValuePair, inputFile,
				TGRequestFieldEnum.SendPhoto.Photo);

	}

	@Override
	public TGRequest sendPhoto(final long chatId, final String photoID, final String caption,
			final Long replyToMessageId, final ReplyKeyboard replyKeyboard) {
		List<BasicNameValuePair> basicNameValuePair = Lists.newArrayList();

		addNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendPhoto.ChatID, String.valueOf(chatId));
		addNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendPhoto.Photo, photoID);

		addOptionalNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendPhoto.Caption, caption);
		addOptionalNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendPhoto.ReplyToMessageID,
				replyToMessageId);
		addOptionalNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendPhoto.ReplyMarkup, replyKeyboard);

		return new TGRequest(RequestTypeEnum.SEND_PHOTO, basicNameValuePair);
	}

	@Override
	public TGRequest sendAudio(final long chatId, final File inputFile, final String title, final String performer,
			final Integer duration, final Long replyToMessageId, final ReplyKeyboard replyKeyboard) {
		List<BasicNameValuePair> basicNameValuePair = Lists.newArrayList();

		addNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendAudio.ChatID, String.valueOf(chatId));

		addOptionalNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendAudio.Duration, duration);
		addOptionalNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendAudio.Performer, performer);
		addOptionalNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendAudio.Title, title);
		addOptionalNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendAudio.ReplyToMessageID,
				replyToMessageId);
		addOptionalNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendAudio.ReplyMarkup, replyKeyboard);

		// chat_id Integer or String Yes Unique identifier for the target chat
		// or username of the target channel (in the format @channelusername)
		// audio InputFile or String Yes Audio file to send. You can either pass
		// a file_id as String to resend an audio that is already on the
		// Telegram servers, or upload a new audio file using
		// multipart/form-data.
		// duration Integer Optional Duration of the audio in seconds
		// performer String Optional Performer
		// title String Optional Track name
		// reply_to_message_id Integer Optional If the message is a reply, ID of
		// the original message
		// reply_markup ReplyKeyboardMarkup or ReplyKeyboardHide or ForceReply
		// Optional Additional interface options. A JSON-serialized object for a
		// custom reply keyboard, instructions to hide keyboard or to force a
		// reply from the user.
		//
		return new TGRequest(RequestTypeEnum.SEND_AUDIO, basicNameValuePair, inputFile,
				TGRequestFieldEnum.SendAudio.Audio);
	}

	@Override
	public TGRequest sendAudio(final long chatId, final String audioID, final String title, final String performer,
			final Integer duration, final Long replyToMessageId, final ReplyKeyboard replyKeyboard) {
		List<BasicNameValuePair> basicNameValuePair = Lists.newArrayList();

		addNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendAudio.ChatID, String.valueOf(chatId));
		addNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendAudio.Audio, String.valueOf(chatId));

		addOptionalNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendAudio.Duration, duration);
		addOptionalNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendAudio.Performer, performer);
		addOptionalNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendAudio.Title, title);
		addOptionalNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendAudio.ReplyToMessageID,
				replyToMessageId);
		addOptionalNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendAudio.ReplyMarkup, replyKeyboard);

		return new TGRequest(RequestTypeEnum.SEND_AUDIO, basicNameValuePair);
	}

	@Override
	public TGRequest sendDocument(final long chatId, final File inputFile, final Long replyToMessageId,
			final ReplyKeyboard replyKeyboard) {

		List<BasicNameValuePair> basicNameValuePair = Lists.newArrayList();
		addNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendDocument.ChatID, String.valueOf(chatId));

		addOptionalNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendAudio.ReplyToMessageID,
				replyToMessageId);
		addOptionalNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendAudio.ReplyMarkup, replyKeyboard);

		// chat_id Integer or String Yes Unique identifier for the target chat
		// or username of the target channel (in the format @channelusername)
		// document InputFile or String Yes File to send. You can either pass a
		// file_id as String to resend a file that is already on the Telegram
		// servers, or upload a new file using multipart/form-data.
		// reply_to_message_id Integer Optional If the message is a reply, ID of
		// the original message
		// reply_markup ReplyKeyboardMarkup or ReplyKeyboardHide or ForceReply
		// Optional Additional interface options. A JSON-serialized object for a
		// custom reply keyboard, instructions to hide keyboard or to force a
		// reply from the user.

		return new TGRequest(RequestTypeEnum.SEND_DOCUMENT, basicNameValuePair, inputFile,
				TGRequestFieldEnum.SendDocument.Document);
	}

	@Override
	public TGRequest sendDocument(final long chatId, final String documentID, final Long replyToMessageId,
			final ReplyKeyboard replyKeyboard) {

		List<BasicNameValuePair> basicNameValuePair = Lists.newArrayList();
		addNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendDocument.ChatID, String.valueOf(chatId));
		addNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendDocument.Document, documentID);

		addOptionalNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendAudio.ReplyToMessageID,
				replyToMessageId);
		addOptionalNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendAudio.ReplyMarkup, replyKeyboard);

		return new TGRequest(RequestTypeEnum.SEND_DOCUMENT, basicNameValuePair);
	}

	@Override
	public TGRequest sendSticker(final long chatId, final File inputFile, final Long replyToMessageId,
			final ReplyKeyboard replyKeyboard) {
		List<BasicNameValuePair> basicNameValuePair = Lists.newArrayList();

		addNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendSticker.ChatID, String.valueOf(chatId));

		addOptionalNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendAudio.ReplyToMessageID,
				replyToMessageId);
		addOptionalNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendAudio.ReplyMarkup, replyKeyboard);

		// chat_id Integer or String Yes Unique identifier for the target chat
		// or username of the target channel (in the format @channelusername)
		// sticker InputFile or String Yes Sticker to send. You can either pass
		// a file_id as String to resend a sticker that is already on the
		// Telegram servers, or upload a new sticker using multipart/form-data.
		// reply_to_message_id Integer Optional If the message is a reply, ID of
		// the original message
		// reply_markup ReplyKeyboardMarkup or ReplyKeyboardHide or ForceReply
		// Optional Additional interface options. A JSON-serialized object for a
		// custom reply keyboard, instructions to hide keyboard or to force a
		// reply from the user.
		//
		return new TGRequest(RequestTypeEnum.SEND_STICKER, basicNameValuePair, inputFile,
				TGRequestFieldEnum.SendSticker.Sticker);
	}

	@Override
	public TGRequest sendSticker(final long chatId, final String stickerID, final Long replyToMessageId,
			final ReplyKeyboard replyKeyboard) {
		List<BasicNameValuePair> basicNameValuePair = Lists.newArrayList();

		addNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendSticker.ChatID, String.valueOf(chatId));
		addNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendSticker.Sticker, stickerID);

		addOptionalNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendAudio.ReplyToMessageID,
				replyToMessageId);
		addOptionalNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendAudio.ReplyMarkup, replyKeyboard);

		return new TGRequest(RequestTypeEnum.SEND_STICKER, basicNameValuePair);
	}

	@Override
	public TGRequest sendVideo(final long chatId, final File inputFile, final Integer duration, final String caption,
			final Long replyToMessageId, final ReplyKeyboard replyKeyboard) {
		List<BasicNameValuePair> basicNameValuePair = Lists.newArrayList();

		addNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendVideo.ChatID, String.valueOf(chatId));

		addOptionalNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendVideo.Duration, duration);
		addOptionalNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendVideo.Caption, caption);
		addOptionalNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendVideo.ReplyToMessageID,
				replyToMessageId);
		addOptionalNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendVideo.ReplyMarkup, replyKeyboard);

		// chat_id Integer or String Yes Unique identifier for the target chat
		// or username of the target channel (in the format @channelusername)
		// video InputFile or String Yes Video to send. You can either pass a
		// file_id as String to resend a video that is already on the Telegram
		// servers, or upload a new video file using multipart/form-data.
		// duration Integer Optional Duration of sent video in seconds
		// caption String Optional Video caption (may also be used when
		// resending videos by file_id).
		// reply_to_message_id Integer Optional If the message is a reply, ID of
		// the original message
		// reply_markup ReplyKeyboardMarkup or ReplyKeyboardHide or ForceReply
		// Optional Additional interface options. A JSON-serialized object for a
		// custom reply keyboard, instructions to hide keyboard or to force a
		// reply from the user.
		//
		return new TGRequest(RequestTypeEnum.SEND_VIDEO, basicNameValuePair, inputFile,
				TGRequestFieldEnum.SendVideo.Video);
	}

	@Override
	public TGRequest sendVideo(final long chatId, final String videoID, final Integer duration, final String caption,
			final Long replyToMessageId, final ReplyKeyboard replyKeyboard) {
		List<BasicNameValuePair> basicNameValuePair = Lists.newArrayList();

		addNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendVideo.ChatID, String.valueOf(chatId));
		addNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendVideo.Video, videoID);

		addOptionalNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendVideo.Duration, duration);
		addOptionalNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendVideo.Caption, caption);
		addOptionalNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendVideo.ReplyToMessageID,
				replyToMessageId);
		addOptionalNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendVideo.ReplyMarkup, replyKeyboard);

		return new TGRequest(RequestTypeEnum.SEND_VIDEO, basicNameValuePair);
	}

	@Override
	public TGRequest sendVoice(final long chatId, final File inputFile, final Integer duration, final String caption,
			final Long replyToMessageId, final ReplyKeyboard replyKeyboard) {

		List<BasicNameValuePair> basicNameValuePair = Lists.newArrayList();

		addNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendVoice.ChatID, String.valueOf(chatId));

		addOptionalNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendVoice.Duration, duration);
		addOptionalNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendVoice.ReplyToMessageID,
				replyToMessageId);
		addOptionalNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendVoice.ReplyMarkup, replyKeyboard);

		// chat_id Integer or String Yes Unique identifier for the target chat
		// or username of the target channel (in the format @channelusername)
		// voice InputFile or String Yes Audio file to send. You can either pass
		// a file_id as String to resend an audio that is already on the
		// Telegram servers, or upload a new audio file using
		// multipart/form-data.
		// duration Integer Optional Duration of sent audio in seconds
		// reply_to_message_id Integer Optional If the message is a reply, ID of
		// the original message
		// reply_markup ReplyKeyboardMarkup or ReplyKeyboardHide or ForceReply
		// Optional Additional interface options. A JSON-serialized object for a
		// custom reply keyboard, instructions to hide keyboard or to force a
		// reply from the user.
		//
		return new TGRequest(RequestTypeEnum.SEND_VOICE, basicNameValuePair, inputFile,
				TGRequestFieldEnum.SendVoice.Voice);
	}

	@Override
	public TGRequest sendVoice(final long chatId, final String voiceID, final Integer duration, final String caption,
			final Long replyToMessageId, final ReplyKeyboard replyKeyboard) {

		List<BasicNameValuePair> basicNameValuePair = Lists.newArrayList();

		addNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendVoice.ChatID, String.valueOf(chatId));
		addNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendVoice.Voice, voiceID);

		addOptionalNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendVoice.Duration, duration);
		addOptionalNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendVoice.ReplyToMessageID,
				replyToMessageId);
		addOptionalNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendVoice.ReplyMarkup, replyKeyboard);

		return new TGRequest(RequestTypeEnum.SEND_VOICE, basicNameValuePair);
	}

	@Override
	public TGRequest sendLocation(final long chatId, final double latitude, final double longitude,
			final Long replyToMessageId, final ReplyKeyboard replyKeyboard) {
		List<BasicNameValuePair> basicNameValuePair = Lists.newArrayList();

		addNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendLocation.ChatID, String.valueOf(chatId));
		addNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendLocation.Latitude,
				String.valueOf(latitude));
		addNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendLocation.Longitude,
				String.valueOf(longitude));

		addOptionalNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendLocation.ReplyToMessageID,
				replyToMessageId);
		addOptionalNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendLocation.ReplyMarkup,
				replyKeyboard);

		// chat_id Integer or String Yes Unique identifier for the target chat
		// or username of the target channel (in the format @channelusername)
		// latitude Float number Yes Latitude of location
		// longitude Float number Yes Longitude of location
		// reply_to_message_id Integer Optional If the message is a reply, ID of
		// the original message
		// reply_markup ReplyKeyboardMarkup or ReplyKeyboardHide or ForceReply
		// Optional Additional interface options. A JSON-serialized object for a
		// custom reply keyboard, instructions to hide keyboard or to force a
		// reply from the user.
		//
		return new TGRequest(RequestTypeEnum.SEND_LOCATION, basicNameValuePair);
	}

	@Override
	public TGRequest sendChatAction(final long chatId, final ActionTypeEnum actionType) {
		List<BasicNameValuePair> basicNameValuePair = Lists.newArrayList();

		addNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendChatAction.ChatID, String.valueOf(chatId));
		addNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.SendChatAction.Action,
				actionType.getActionToBroadcast());

		// chat_id Integer or String Yes Unique identifier for the target chat
		// or username of the target channel (in the format @channelusername)
		// action String Yes Type of action to broadcast. Choose one, depending
		// on what the user is about to receive: typing for text messages,
		// upload_photo for photos, record_video or upload_video for videos,
		// record_audio or upload_audio for audio files, upload_document for
		// general files, find_location for location data.

		return new TGRequest(RequestTypeEnum.SEND_CHAT_ACTION, basicNameValuePair);
	}

	@Override
	public TGRequest getUserProfilePhotos(final long userId, final Integer offset, final Integer limit) {
		List<BasicNameValuePair> basicNameValuePair = Lists.newArrayList();

		addNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.GetUserProfilePhots.UserID,
				String.valueOf(userId));
		addNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.GetUserProfilePhots.Limit,
				String.valueOf(limit));
		addNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.GetUserProfilePhots.Offset,
				String.valueOf(offset));

		// user_id Integer Yes Unique identifier of the target user
		// offset Integer Optional Sequential number of the first photo to be
		// returned. By default, all photos are returned.
		// limit Integer Optional Limits the number of photos to be retrieved.
		// Values between 1—100 are accepted. Defaults to 100.
		//
		return new TGRequest(RequestTypeEnum.GET_USER_PROFILE_PHOTOS, basicNameValuePair);
	}

	@Override
	public TGRequest getUpdates(final Long offset, final Long limit, final Long timeout) {
		List<BasicNameValuePair> basicNameValuePair = Lists.newArrayList();

		addNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.GetUpdates.Offset, String.valueOf(offset));
		addNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.GetUpdates.Limit, String.valueOf(limit));
		addNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.GetUpdates.Timeout, String.valueOf(timeout));

		return new TGRequest(RequestTypeEnum.GET_UPDATES, basicNameValuePair);
	}

	@Override
	public TGRequest setWebhook(final String url) {
		List<BasicNameValuePair> basicNameValuePair = Lists.newArrayList();

		addNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.GetWebHook.Url, url);

		return new TGRequest(RequestTypeEnum.SET_WEBHOOK, basicNameValuePair);
	}

	@Override
	public TGRequest getFile(final String fileID, final Long fileSize, final String filePath) {

		List<BasicNameValuePair> basicNameValuePair = Lists.newArrayList();

		addNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.GetFile.FileID, fileID);
		addNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.GetFile.FileSize, String.valueOf(fileSize));
		addNewBasicNameValuePair(basicNameValuePair, TGRequestFieldEnum.GetFile.FilePath, filePath);

		// file_id String Unique identifier for this file
		// file_size Integer Optional. File size, if known
		// file_path String Optional. File path. Use
		// https://api.telegram.org/file/bot<token>/<file_path> to get the file.

		return new TGRequest(RequestTypeEnum.GET_FILE, basicNameValuePair);
	}

	private void addNewBasicNameValuePair(final List<BasicNameValuePair> list, String key, String value) {
		BasicNameValuePair pair = new BasicNameValuePair(key, value);
		list.add(pair);
	}

	private void addOptionalNewBasicNameValuePair(final List<BasicNameValuePair> list, String key, Object value) {
		if (value != null) {
			String stringValue = String.valueOf(value);
			addNewBasicNameValuePair(list, key, stringValue);
		}
	}
}
