/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.osb.www.shortlink.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ShortLinkEntry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShortLinkEntry
 * @generated
 */
public class ShortLinkEntryWrapper
	extends BaseModelWrapper<ShortLinkEntry>
	implements ModelWrapper<ShortLinkEntry>, ShortLinkEntry {

	public ShortLinkEntryWrapper(ShortLinkEntry shortLinkEntry) {
		super(shortLinkEntry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("shortLinkEntryId", getShortLinkEntryId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("originalURL", getOriginalURL());
		attributes.put("shortURL", getShortURL());
		attributes.put("httpStatusCode", getHttpStatusCode());
		attributes.put("active", isActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long shortLinkEntryId = (Long)attributes.get("shortLinkEntryId");

		if (shortLinkEntryId != null) {
			setShortLinkEntryId(shortLinkEntryId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String originalURL = (String)attributes.get("originalURL");

		if (originalURL != null) {
			setOriginalURL(originalURL);
		}

		String shortURL = (String)attributes.get("shortURL");

		if (shortURL != null) {
			setShortURL(shortURL);
		}

		Integer httpStatusCode = (Integer)attributes.get("httpStatusCode");

		if (httpStatusCode != null) {
			setHttpStatusCode(httpStatusCode);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	/**
	 * Returns the active of this short link entry.
	 *
	 * @return the active of this short link entry
	 */
	@Override
	public boolean getActive() {
		return model.getActive();
	}

	/**
	 * Returns the create date of this short link entry.
	 *
	 * @return the create date of this short link entry
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the http status code of this short link entry.
	 *
	 * @return the http status code of this short link entry
	 */
	@Override
	public int getHttpStatusCode() {
		return model.getHttpStatusCode();
	}

	/**
	 * Returns the modified date of this short link entry.
	 *
	 * @return the modified date of this short link entry
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the original url of this short link entry.
	 *
	 * @return the original url of this short link entry
	 */
	@Override
	public String getOriginalURL() {
		return model.getOriginalURL();
	}

	/**
	 * Returns the primary key of this short link entry.
	 *
	 * @return the primary key of this short link entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the short link entry ID of this short link entry.
	 *
	 * @return the short link entry ID of this short link entry
	 */
	@Override
	public long getShortLinkEntryId() {
		return model.getShortLinkEntryId();
	}

	/**
	 * Returns the short url of this short link entry.
	 *
	 * @return the short url of this short link entry
	 */
	@Override
	public String getShortURL() {
		return model.getShortURL();
	}

	/**
	 * Returns the uuid of this short link entry.
	 *
	 * @return the uuid of this short link entry
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this short link entry is active.
	 *
	 * @return <code>true</code> if this short link entry is active; <code>false</code> otherwise
	 */
	@Override
	public boolean isActive() {
		return model.isActive();
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a short link entry model instance should use the <code>ShortLinkEntry</code> interface instead.
	 */
	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets whether this short link entry is active.
	 *
	 * @param active the active of this short link entry
	 */
	@Override
	public void setActive(boolean active) {
		model.setActive(active);
	}

	/**
	 * Sets the create date of this short link entry.
	 *
	 * @param createDate the create date of this short link entry
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the http status code of this short link entry.
	 *
	 * @param httpStatusCode the http status code of this short link entry
	 */
	@Override
	public void setHttpStatusCode(int httpStatusCode) {
		model.setHttpStatusCode(httpStatusCode);
	}

	/**
	 * Sets the modified date of this short link entry.
	 *
	 * @param modifiedDate the modified date of this short link entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the original url of this short link entry.
	 *
	 * @param originalURL the original url of this short link entry
	 */
	@Override
	public void setOriginalURL(String originalURL) {
		model.setOriginalURL(originalURL);
	}

	/**
	 * Sets the primary key of this short link entry.
	 *
	 * @param primaryKey the primary key of this short link entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the short link entry ID of this short link entry.
	 *
	 * @param shortLinkEntryId the short link entry ID of this short link entry
	 */
	@Override
	public void setShortLinkEntryId(long shortLinkEntryId) {
		model.setShortLinkEntryId(shortLinkEntryId);
	}

	/**
	 * Sets the short url of this short link entry.
	 *
	 * @param shortURL the short url of this short link entry
	 */
	@Override
	public void setShortURL(String shortURL) {
		model.setShortURL(shortURL);
	}

	/**
	 * Sets the uuid of this short link entry.
	 *
	 * @param uuid the uuid of this short link entry
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected ShortLinkEntryWrapper wrap(ShortLinkEntry shortLinkEntry) {
		return new ShortLinkEntryWrapper(shortLinkEntry);
	}

}