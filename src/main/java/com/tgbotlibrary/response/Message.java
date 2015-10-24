package com.tgbotlibrary.response;

import org.codehaus.jackson.annotate.JsonProperty;

public class Message implements Response{

	/**
	 * Integer Unique message identifier
	 */
	@JsonProperty("message_id")
	private Integer id;

	/**
	 * User Optional. Sender, can be empty for messages sent to channels
	 */
	@JsonProperty("from")
	private User from;

	/**
	 * Integer Date the message was sent in Unix time
	 */
	@JsonProperty("date")
	private Integer date;

	/**
	 * Chat Conversation the message belongs to
	 */
	@JsonProperty("chat")
	private Chat chat;

	/**
	 * User Optional. For forwarded messages, sender of the original message
	 */
	@JsonProperty("forward_from")
	private User forwardFrom;

	/**
	 * Integer Optional. For forwarded messages, date the original message was
	 * sent in Unix time
	 */
	@JsonProperty("forward_date")
	private Integer forwardDate;

	/**
	 * Message Optional. For replies, the original message. Note that the
	 * Message object in this field will not contain further reply_to_message
	 * fields even if it itself is a reply.
	 */
	@JsonProperty("reply_to_message")
	private Message replyToMessage;

	/**
	 * String Optional. For text messages, the actual UTF-8 text of the message
	 */
	@JsonProperty("text")
	private String text;

	/**
	 * Audio Optional. Message is an audio file, information about the file
	 */
	@JsonProperty("audio")
	private Audio audio;

	/**
	 * Document Optional. Message is a general file, information about the file
	 */
	@JsonProperty("document")
	private Document document;

	/**
	 * Array of PhotoSize Optional. Message is a photo, available sizes of the
	 * photo
	 */
	@JsonProperty("photo")
	private PhotoSize[] photos;

	/**
	 * Sticker Optional. Message is a sticker, information about the sticker
	 */
	@JsonProperty("sticker")
	private Sticker sticker;

	/**
	 * Video Optional. Message is a video, information about the video
	 */
	@JsonProperty("video")
	private Video video;

	/**
	 * Voice Optional. Message is a voice message, information about the file
	 */
	@JsonProperty("voice")
	private Voice voice;

	/**
	 * String Optional. Caption for the photo or video
	 */
	@JsonProperty("caption")
	private String caption;

	/**
	 * Contact Optional. Message is a shared contact, information about the
	 * contact
	 */
	@JsonProperty("contact")
	private String contact;

	/**
	 * Location Optional. Message is a shared location, information about the
	 * location
	 */
	@JsonProperty("location")
	private String location;

	/**
	 * Optional. A new member was added to the group, information about them
	 * (this member may be bot itself)
	 */
	@JsonProperty("new_chat_participant")
	private User newChatParticipant;

	/**
	 * User Optional. A member was removed from the group, information about
	 * them (this member may be bot itself)
	 */
	@JsonProperty("left_chat_participant")
	private User leftChatParticipant;

	/**
	 * String Optional. A chat title was changed to this value
	 */
	@JsonProperty("new_chat_title")
	private String newChatTitle;

	/**
	 * Array of PhotoSize Optional. A chat photo was change to this value
	 */
	@JsonProperty("new_chat_photo")
	private PhotoSize[] newChatPhotos;

	/**
	 * Boolean Optional. Informs that the group photo was deleted
	 */
	@JsonProperty("delete_chat_photo")
	private Boolean deleteChatPhoto;
	
	/**
	 * Boolean Optional. Informs that the group has been created
	 */
	@JsonProperty("group_chat_created")
	private Boolean groupChatCreated;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getFrom() {
		return from;
	}

	public void setFrom(User from) {
		this.from = from;
	}

	public Integer getDate() {
		return date;
	}

	public void setDate(Integer date) {
		this.date = date;
	}

	public Chat getChat() {
		return chat;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
	}

	public User getForwardFrom() {
		return forwardFrom;
	}

	public void setForwardFrom(User forwardFrom) {
		this.forwardFrom = forwardFrom;
	}

	public Integer getForwardDate() {
		return forwardDate;
	}

	public void setForwardDate(Integer forwardDate) {
		this.forwardDate = forwardDate;
	}

	public Message getReplyToMessage() {
		return replyToMessage;
	}

	public void setReplyToMessage(Message replyToMessage) {
		this.replyToMessage = replyToMessage;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Audio getAudio() {
		return audio;
	}

	public void setAudio(Audio audio) {
		this.audio = audio;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public PhotoSize[] getPhotos() {
		return photos;
	}

	public void setPhotos(PhotoSize[] photos) {
		this.photos = photos;
	}

	public Sticker getSticker() {
		return sticker;
	}

	public void setSticker(Sticker sticker) {
		this.sticker = sticker;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public Voice getVoice() {
		return voice;
	}

	public void setVoice(Voice voice) {
		this.voice = voice;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public User getNewChatParticipant() {
		return newChatParticipant;
	}

	public void setNewChatParticipant(User newChatParticipant) {
		this.newChatParticipant = newChatParticipant;
	}

	public User getLeftChatParticipant() {
		return leftChatParticipant;
	}

	public void setLeftChatParticipant(User leftChatParticipant) {
		this.leftChatParticipant = leftChatParticipant;
	}

	public String getNewChatTitle() {
		return newChatTitle;
	}

	public void setNewChatTitle(String newChatTitle) {
		this.newChatTitle = newChatTitle;
	}

	public PhotoSize[] getNewChatPhotos() {
		return newChatPhotos;
	}

	public void setNewChatPhotos(PhotoSize[] newChatPhotos) {
		this.newChatPhotos = newChatPhotos;
	}

	public Boolean getDeleteChatPhoto() {
		return deleteChatPhoto;
	}

	public void setDeleteChatPhoto(Boolean deleteChatPhoto) {
		this.deleteChatPhoto = deleteChatPhoto;
	}

	public Boolean getGroupChatCreated() {
		return groupChatCreated;
	}

	public void setGroupChatCreated(Boolean groupChatCreated) {
		this.groupChatCreated = groupChatCreated;
	}

}
