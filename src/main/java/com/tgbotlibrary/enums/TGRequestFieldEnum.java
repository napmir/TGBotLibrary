package com.tgbotlibrary.enums;

import org.apache.http.message.BasicNameValuePair;

public interface TGRequestFieldEnum {

	public interface SendMessage {
		public String ChatID = "chat_id";
		public String Text = "text";
		public String ParseMode = "parse_mode";
		public String DisableWebPagePreview = "disable_web_page_preview";
		public String ReplyToMessageID = "reply_to_message_id";
		public String ReplyMarkup = "reply_markup";
	}

	public interface ForwardMessage {
		public String ChatID = "chat_id";
		public String FromChatID = "from_chat_id";
		public String MessageID = "message_id";
	}

	public interface SendAudio {
		public String ChatID = "chat_id";
		public String Audio = "audio";
		public String Duration = "duration";
		public String Performer = "performer";
		public String Title = "title";
		public String ReplyToMessageID = "reply_to_message_id";
		public String ReplyMarkup = "reply_markup";

	}

	
	public interface SendDocument {
		public String ChatID = "chat_id";
		public String Document = "document";
		public String ReplyToMessageID = "reply_to_message_id";
		public String ReplyMarkup = "reply_markup";

	}

	public interface SendSticker {
		public String ChatID = "chat_id";
		public String Sticker = "sticker";
		public String ReplyToMessageID = "reply_to_message_id";
		public String ReplyMarkup = "reply_markup";

	}

	public interface SendVideo {
		public String ChatID = "chat_id";
		public String Video = "video";
		public String Duration = "duration";
		public String Caption = "caption";
		public String ReplyToMessageID = "reply_to_message_id";
		public String ReplyMarkup = "reply_markup";
	}
	
	public interface SendPhoto {
		public String ChatID = "chat_id";
		public String Photo = "photo";
		public String Caption = "caption";
		public String ReplyToMessageID = "reply_to_message_id";
		public String ReplyMarkup = "reply_markup";
	}

	public interface SendVoice {
		public String ChatID = "chat_id";
		public String Voice = "voice";
		public String Duration = "duration";
		public String ReplyToMessageID = "reply_to_message_id";
		public String ReplyMarkup = "reply_markup";
	}

	public interface SendLocation {
		public String ChatID = "chat_id";
		public String Latitude = "latitude";
		public String Longitude = "longitude";
		public String ReplyToMessageID = "reply_to_message_id";
		public String ReplyMarkup = "reply_markup";
	}
	
	public interface SendChatAction {
		public String ChatID = "chat_id";
		public String Action = "action";
	}

	public interface GetUserProfilePhots{
		public String UserID = "user_id";
		public String Offset = "offset";
		public String Limit = "limit";
	}
	
	public interface GetUpdates{
		public String Offset = "offset";
		public String Limit = "limit";
		public String Timeout = "timeout";
	}
	
	public interface GetFile{
		public String FileID ="file_id";
		public String FileSize ="file_size";
		public String FilePath ="file_path";
	}
	
	public interface GetWebHook{
		public String Url ="url";
	}
}
