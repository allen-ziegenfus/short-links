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

package com.liferay.osb.www.shortlink.model.impl;

import com.liferay.osb.www.shortlink.model.ShortLinkEntry;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ShortLinkEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ShortLinkEntryCacheModel
	implements CacheModel<ShortLinkEntry>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ShortLinkEntryCacheModel)) {
			return false;
		}

		ShortLinkEntryCacheModel shortLinkEntryCacheModel =
			(ShortLinkEntryCacheModel)obj;

		if (shortLinkEntryId == shortLinkEntryCacheModel.shortLinkEntryId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, shortLinkEntryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", shortLinkEntryId=");
		sb.append(shortLinkEntryId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", originalURL=");
		sb.append(originalURL);
		sb.append(", shortURL=");
		sb.append(shortURL);
		sb.append(", httpStatusCode=");
		sb.append(httpStatusCode);
		sb.append(", active=");
		sb.append(active);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ShortLinkEntry toEntityModel() {
		ShortLinkEntryImpl shortLinkEntryImpl = new ShortLinkEntryImpl();

		if (uuid == null) {
			shortLinkEntryImpl.setUuid("");
		}
		else {
			shortLinkEntryImpl.setUuid(uuid);
		}

		shortLinkEntryImpl.setShortLinkEntryId(shortLinkEntryId);

		if (createDate == Long.MIN_VALUE) {
			shortLinkEntryImpl.setCreateDate(null);
		}
		else {
			shortLinkEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			shortLinkEntryImpl.setModifiedDate(null);
		}
		else {
			shortLinkEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (originalURL == null) {
			shortLinkEntryImpl.setOriginalURL("");
		}
		else {
			shortLinkEntryImpl.setOriginalURL(originalURL);
		}

		if (shortURL == null) {
			shortLinkEntryImpl.setShortURL("");
		}
		else {
			shortLinkEntryImpl.setShortURL(shortURL);
		}

		shortLinkEntryImpl.setHttpStatusCode(httpStatusCode);
		shortLinkEntryImpl.setActive(active);

		shortLinkEntryImpl.resetOriginalValues();

		return shortLinkEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		shortLinkEntryId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		originalURL = objectInput.readUTF();
		shortURL = objectInput.readUTF();

		httpStatusCode = objectInput.readInt();

		active = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(shortLinkEntryId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (originalURL == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(originalURL);
		}

		if (shortURL == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(shortURL);
		}

		objectOutput.writeInt(httpStatusCode);

		objectOutput.writeBoolean(active);
	}

	public String uuid;
	public long shortLinkEntryId;
	public long createDate;
	public long modifiedDate;
	public String originalURL;
	public String shortURL;
	public int httpStatusCode;
	public boolean active;

}