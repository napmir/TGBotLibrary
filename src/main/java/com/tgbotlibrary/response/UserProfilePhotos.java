package com.tgbotlibrary.response;

import org.codehaus.jackson.annotate.JsonProperty;

public class UserProfilePhotos implements Response{

	/**
	 * Integer Total number of profile pictures the target user has
	 */
	@JsonProperty("total_count")
	private Integer totalCount;

	/**
	 * Array of Array of PhotoSize Requested profile pictures (in up to 4 sizes
	 * each)
	 */
	@JsonProperty("photos")
	private PhotoSize[][] photos;

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public PhotoSize[][] getPhotos() {
		return photos;
	}

	public void setPhotos(PhotoSize[][] photos) {
		this.photos = photos;
	}

}
