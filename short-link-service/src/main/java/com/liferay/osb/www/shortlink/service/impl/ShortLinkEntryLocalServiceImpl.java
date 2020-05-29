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

package com.liferay.osb.www.shortlink.service.impl;

import com.liferay.osb.www.shortlink.exception.CannotOverrideLayoutException;
import com.liferay.osb.www.shortlink.exception.DuplicateShortLinkEntryException;
import com.liferay.osb.www.shortlink.exception.ShortLinkEntryOriginalURLException;
import com.liferay.osb.www.shortlink.exception.ShortLinkEntryShortURLException;
import com.liferay.osb.www.shortlink.model.ShortLinkEntry;
import com.liferay.osb.www.shortlink.model.ShortLinkEntryConstants;
import com.liferay.osb.www.shortlink.service.base.ShortLinkEntryLocalServiceBaseImpl;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.GroupConstants;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.util.FriendlyURLNormalizerUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.Date;

/**
 * @author Miroslav Ligas
 * @author Joan H. Kim
 * @author Allen Ziegenfus
 */
public class ShortLinkEntryLocalServiceImpl
	extends ShortLinkEntryLocalServiceBaseImpl {

	public ShortLinkEntry addShortLinkEntry(
			String originalURL, String shortURL, int httpStatusCode)
		throws PortalException {

		Date now = new Date();

		long shortLinkEntryId = counterLocalService.increment(
			ShortLinkEntry.class.getName());

		ShortLinkEntry shortLinkEntry = shortLinkEntryPersistence.create(
			shortLinkEntryId);

		shortURL = getShortURL(shortURL);

		validate(0, originalURL, shortURL);

		shortLinkEntry.setCreateDate(now);
		shortLinkEntry.setModifiedDate(now);
		shortLinkEntry.setOriginalURL(originalURL);
		shortLinkEntry.setShortURL(shortURL);
		shortLinkEntry.setHttpStatusCode(httpStatusCode);
		shortLinkEntry.setActive(true);

		return shortLinkEntryPersistence.update(shortLinkEntry);
	}

	@Override
	public ShortLinkEntry fetchShortLinkEntry(String shortURL)
		throws PortalException {

		return shortLinkEntryPersistence.fetchByShortURL(shortURL);
	}

	@Override
	public ShortLinkEntry getShortLinkEntry(String shortURL)
		throws PortalException {

		return shortLinkEntryPersistence.findBySURL(shortURL);
	}

	public ShortLinkEntry updateShortLinkEntry(
			long shortLinkEntryId, String originalURL, String shortURL,
			int httpStatusCode, boolean active)
		throws PortalException {

		ShortLinkEntry shortLinkEntry =
			shortLinkEntryPersistence.findByPrimaryKey(shortLinkEntryId);

		shortURL = getShortURL(shortURL);

		validate(shortLinkEntryId, originalURL, shortURL);

		shortLinkEntry.setModifiedDate(new Date());
		shortLinkEntry.setOriginalURL(originalURL);
		shortLinkEntry.setShortURL(shortURL);
		shortLinkEntry.setHttpStatusCode(httpStatusCode);
		shortLinkEntry.setActive(active);

		return shortLinkEntryPersistence.update(shortLinkEntry);
	}

	protected String getShortURL(String shortURL) {
		if (Validator.isNotNull(shortURL)) {
			return FriendlyURLNormalizerUtil.normalize(shortURL);
		}

		return shortURL;
	}

	protected void validate(
			long shortLinkEntryId, String originalURL, String shortURL)
		throws PortalException {

		if (Validator.isNull(originalURL) ||
			(originalURL.length() >
				ShortLinkEntryConstants.ORIGINAL_URL_MAXIMUM_SIZE)) {

			throw new ShortLinkEntryOriginalURLException();
		}

		if (Validator.isNull(shortURL) ||
			(shortURL.length() <
				ShortLinkEntryConstants.SHORT_URL_MINIMUM_SIZE) ||
			(shortURL.length() >
				ShortLinkEntryConstants.SHORT_URL_MAXIMIM_SIZE)) {

			throw new ShortLinkEntryShortURLException();
		}

		ShortLinkEntry shortLinkEntry =
			shortLinkEntryPersistence.fetchByShortURL(shortURL);

		if ((shortLinkEntry != null) &&
			(shortLinkEntry.getShortLinkEntryId() != shortLinkEntryId)) {

			throw new DuplicateShortLinkEntryException();
		}

		if (!shortURL.startsWith(StringPool.SLASH)) {
			shortURL = StringPool.SLASH + shortURL;
		}

		Group group = GroupLocalServiceUtil.getGroup(
			PortalUtil.getDefaultCompanyId(), GroupConstants.GUEST);

		Layout layout = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
			group.getGroupId(), false, shortURL);

		if (layout != null) {
			throw new CannotOverrideLayoutException();
		}
	}

}