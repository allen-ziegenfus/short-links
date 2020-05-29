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

package com.liferay.osb.www.shortlink.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ShortLinkEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ShortLinkEntryLocalService
 * @generated
 */
public class ShortLinkEntryLocalServiceWrapper
	implements ServiceWrapper<ShortLinkEntryLocalService>,
			   ShortLinkEntryLocalService {

	public ShortLinkEntryLocalServiceWrapper(
		ShortLinkEntryLocalService shortLinkEntryLocalService) {

		_shortLinkEntryLocalService = shortLinkEntryLocalService;
	}

	/**
	 * Adds the short link entry to the database. Also notifies the appropriate model listeners.
	 *
	 * @param shortLinkEntry the short link entry
	 * @return the short link entry that was added
	 */
	@Override
	public com.liferay.osb.www.shortlink.model.ShortLinkEntry addShortLinkEntry(
		com.liferay.osb.www.shortlink.model.ShortLinkEntry shortLinkEntry) {

		return _shortLinkEntryLocalService.addShortLinkEntry(shortLinkEntry);
	}

	@Override
	public com.liferay.osb.www.shortlink.model.ShortLinkEntry addShortLinkEntry(
			String originalURL, String shortURL, int httpStatusCode)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _shortLinkEntryLocalService.addShortLinkEntry(
			originalURL, shortURL, httpStatusCode);
	}

	/**
	 * Creates a new short link entry with the primary key. Does not add the short link entry to the database.
	 *
	 * @param shortLinkEntryId the primary key for the new short link entry
	 * @return the new short link entry
	 */
	@Override
	public com.liferay.osb.www.shortlink.model.ShortLinkEntry
		createShortLinkEntry(long shortLinkEntryId) {

		return _shortLinkEntryLocalService.createShortLinkEntry(
			shortLinkEntryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _shortLinkEntryLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the short link entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param shortLinkEntryId the primary key of the short link entry
	 * @return the short link entry that was removed
	 * @throws PortalException if a short link entry with the primary key could not be found
	 */
	@Override
	public com.liferay.osb.www.shortlink.model.ShortLinkEntry
			deleteShortLinkEntry(long shortLinkEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _shortLinkEntryLocalService.deleteShortLinkEntry(
			shortLinkEntryId);
	}

	/**
	 * Deletes the short link entry from the database. Also notifies the appropriate model listeners.
	 *
	 * @param shortLinkEntry the short link entry
	 * @return the short link entry that was removed
	 */
	@Override
	public com.liferay.osb.www.shortlink.model.ShortLinkEntry
		deleteShortLinkEntry(
			com.liferay.osb.www.shortlink.model.ShortLinkEntry shortLinkEntry) {

		return _shortLinkEntryLocalService.deleteShortLinkEntry(shortLinkEntry);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _shortLinkEntryLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _shortLinkEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.osb.www.shortlink.model.impl.ShortLinkEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _shortLinkEntryLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.osb.www.shortlink.model.impl.ShortLinkEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _shortLinkEntryLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _shortLinkEntryLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _shortLinkEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.osb.www.shortlink.model.ShortLinkEntry
		fetchShortLinkEntry(long shortLinkEntryId) {

		return _shortLinkEntryLocalService.fetchShortLinkEntry(
			shortLinkEntryId);
	}

	@Override
	public com.liferay.osb.www.shortlink.model.ShortLinkEntry
			fetchShortLinkEntry(String shortURL)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _shortLinkEntryLocalService.fetchShortLinkEntry(shortURL);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _shortLinkEntryLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _shortLinkEntryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _shortLinkEntryLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _shortLinkEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns a range of all the short link entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.osb.www.shortlink.model.impl.ShortLinkEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of short link entries
	 * @param end the upper bound of the range of short link entries (not inclusive)
	 * @return the range of short link entries
	 */
	@Override
	public java.util.List<com.liferay.osb.www.shortlink.model.ShortLinkEntry>
		getShortLinkEntries(int start, int end) {

		return _shortLinkEntryLocalService.getShortLinkEntries(start, end);
	}

	/**
	 * Returns the number of short link entries.
	 *
	 * @return the number of short link entries
	 */
	@Override
	public int getShortLinkEntriesCount() {
		return _shortLinkEntryLocalService.getShortLinkEntriesCount();
	}

	/**
	 * Returns the short link entry with the primary key.
	 *
	 * @param shortLinkEntryId the primary key of the short link entry
	 * @return the short link entry
	 * @throws PortalException if a short link entry with the primary key could not be found
	 */
	@Override
	public com.liferay.osb.www.shortlink.model.ShortLinkEntry getShortLinkEntry(
			long shortLinkEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _shortLinkEntryLocalService.getShortLinkEntry(shortLinkEntryId);
	}

	@Override
	public com.liferay.osb.www.shortlink.model.ShortLinkEntry getShortLinkEntry(
			String shortURL)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _shortLinkEntryLocalService.getShortLinkEntry(shortURL);
	}

	@Override
	public com.liferay.osb.www.shortlink.model.ShortLinkEntry
			updateShortLinkEntry(
				long shortLinkEntryId, String originalURL, String shortURL,
				int httpStatusCode, boolean active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _shortLinkEntryLocalService.updateShortLinkEntry(
			shortLinkEntryId, originalURL, shortURL, httpStatusCode, active);
	}

	/**
	 * Updates the short link entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param shortLinkEntry the short link entry
	 * @return the short link entry that was updated
	 */
	@Override
	public com.liferay.osb.www.shortlink.model.ShortLinkEntry
		updateShortLinkEntry(
			com.liferay.osb.www.shortlink.model.ShortLinkEntry shortLinkEntry) {

		return _shortLinkEntryLocalService.updateShortLinkEntry(shortLinkEntry);
	}

	@Override
	public ShortLinkEntryLocalService getWrappedService() {
		return _shortLinkEntryLocalService;
	}

	@Override
	public void setWrappedService(
		ShortLinkEntryLocalService shortLinkEntryLocalService) {

		_shortLinkEntryLocalService = shortLinkEntryLocalService;
	}

	private ShortLinkEntryLocalService _shortLinkEntryLocalService;

}