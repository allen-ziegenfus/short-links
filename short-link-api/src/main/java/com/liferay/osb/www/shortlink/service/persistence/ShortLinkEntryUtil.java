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

package com.liferay.osb.www.shortlink.service.persistence;

import com.liferay.osb.www.shortlink.model.ShortLinkEntry;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the short link entry service. This utility wraps <code>com.liferay.osb.www.shortlink.service.persistence.impl.ShortLinkEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShortLinkEntryPersistence
 * @generated
 */
public class ShortLinkEntryUtil {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(ShortLinkEntry shortLinkEntry) {
		getPersistence().clearCache(shortLinkEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, ShortLinkEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ShortLinkEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ShortLinkEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ShortLinkEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ShortLinkEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ShortLinkEntry update(ShortLinkEntry shortLinkEntry) {
		return getPersistence().update(shortLinkEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ShortLinkEntry update(
		ShortLinkEntry shortLinkEntry, ServiceContext serviceContext) {

		return getPersistence().update(shortLinkEntry, serviceContext);
	}

	/**
	 * Returns all the short link entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching short link entries
	 */
	public static List<ShortLinkEntry> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the short link entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ShortLinkEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of short link entries
	 * @param end the upper bound of the range of short link entries (not inclusive)
	 * @return the range of matching short link entries
	 */
	public static List<ShortLinkEntry> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the short link entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ShortLinkEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of short link entries
	 * @param end the upper bound of the range of short link entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching short link entries
	 */
	public static List<ShortLinkEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ShortLinkEntry> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the short link entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ShortLinkEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of short link entries
	 * @param end the upper bound of the range of short link entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching short link entries
	 */
	public static List<ShortLinkEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ShortLinkEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first short link entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching short link entry
	 * @throws NoSuchEntryException if a matching short link entry could not be found
	 */
	public static ShortLinkEntry findByUuid_First(
			String uuid, OrderByComparator<ShortLinkEntry> orderByComparator)
		throws com.liferay.osb.www.shortlink.exception.NoSuchEntryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first short link entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching short link entry, or <code>null</code> if a matching short link entry could not be found
	 */
	public static ShortLinkEntry fetchByUuid_First(
		String uuid, OrderByComparator<ShortLinkEntry> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last short link entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching short link entry
	 * @throws NoSuchEntryException if a matching short link entry could not be found
	 */
	public static ShortLinkEntry findByUuid_Last(
			String uuid, OrderByComparator<ShortLinkEntry> orderByComparator)
		throws com.liferay.osb.www.shortlink.exception.NoSuchEntryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last short link entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching short link entry, or <code>null</code> if a matching short link entry could not be found
	 */
	public static ShortLinkEntry fetchByUuid_Last(
		String uuid, OrderByComparator<ShortLinkEntry> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the short link entries before and after the current short link entry in the ordered set where uuid = &#63;.
	 *
	 * @param shortLinkEntryId the primary key of the current short link entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next short link entry
	 * @throws NoSuchEntryException if a short link entry with the primary key could not be found
	 */
	public static ShortLinkEntry[] findByUuid_PrevAndNext(
			long shortLinkEntryId, String uuid,
			OrderByComparator<ShortLinkEntry> orderByComparator)
		throws com.liferay.osb.www.shortlink.exception.NoSuchEntryException {

		return getPersistence().findByUuid_PrevAndNext(
			shortLinkEntryId, uuid, orderByComparator);
	}

	/**
	 * Removes all the short link entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of short link entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching short link entries
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the short link entries where originalURL = &#63;.
	 *
	 * @param originalURL the original url
	 * @return the matching short link entries
	 */
	public static List<ShortLinkEntry> findByOURL(String originalURL) {
		return getPersistence().findByOURL(originalURL);
	}

	/**
	 * Returns a range of all the short link entries where originalURL = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ShortLinkEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param originalURL the original url
	 * @param start the lower bound of the range of short link entries
	 * @param end the upper bound of the range of short link entries (not inclusive)
	 * @return the range of matching short link entries
	 */
	public static List<ShortLinkEntry> findByOURL(
		String originalURL, int start, int end) {

		return getPersistence().findByOURL(originalURL, start, end);
	}

	/**
	 * Returns an ordered range of all the short link entries where originalURL = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ShortLinkEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param originalURL the original url
	 * @param start the lower bound of the range of short link entries
	 * @param end the upper bound of the range of short link entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching short link entries
	 */
	public static List<ShortLinkEntry> findByOURL(
		String originalURL, int start, int end,
		OrderByComparator<ShortLinkEntry> orderByComparator) {

		return getPersistence().findByOURL(
			originalURL, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the short link entries where originalURL = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ShortLinkEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param originalURL the original url
	 * @param start the lower bound of the range of short link entries
	 * @param end the upper bound of the range of short link entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching short link entries
	 */
	public static List<ShortLinkEntry> findByOURL(
		String originalURL, int start, int end,
		OrderByComparator<ShortLinkEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByOURL(
			originalURL, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first short link entry in the ordered set where originalURL = &#63;.
	 *
	 * @param originalURL the original url
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching short link entry
	 * @throws NoSuchEntryException if a matching short link entry could not be found
	 */
	public static ShortLinkEntry findByOURL_First(
			String originalURL,
			OrderByComparator<ShortLinkEntry> orderByComparator)
		throws com.liferay.osb.www.shortlink.exception.NoSuchEntryException {

		return getPersistence().findByOURL_First(
			originalURL, orderByComparator);
	}

	/**
	 * Returns the first short link entry in the ordered set where originalURL = &#63;.
	 *
	 * @param originalURL the original url
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching short link entry, or <code>null</code> if a matching short link entry could not be found
	 */
	public static ShortLinkEntry fetchByOURL_First(
		String originalURL,
		OrderByComparator<ShortLinkEntry> orderByComparator) {

		return getPersistence().fetchByOURL_First(
			originalURL, orderByComparator);
	}

	/**
	 * Returns the last short link entry in the ordered set where originalURL = &#63;.
	 *
	 * @param originalURL the original url
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching short link entry
	 * @throws NoSuchEntryException if a matching short link entry could not be found
	 */
	public static ShortLinkEntry findByOURL_Last(
			String originalURL,
			OrderByComparator<ShortLinkEntry> orderByComparator)
		throws com.liferay.osb.www.shortlink.exception.NoSuchEntryException {

		return getPersistence().findByOURL_Last(originalURL, orderByComparator);
	}

	/**
	 * Returns the last short link entry in the ordered set where originalURL = &#63;.
	 *
	 * @param originalURL the original url
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching short link entry, or <code>null</code> if a matching short link entry could not be found
	 */
	public static ShortLinkEntry fetchByOURL_Last(
		String originalURL,
		OrderByComparator<ShortLinkEntry> orderByComparator) {

		return getPersistence().fetchByOURL_Last(
			originalURL, orderByComparator);
	}

	/**
	 * Returns the short link entries before and after the current short link entry in the ordered set where originalURL = &#63;.
	 *
	 * @param shortLinkEntryId the primary key of the current short link entry
	 * @param originalURL the original url
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next short link entry
	 * @throws NoSuchEntryException if a short link entry with the primary key could not be found
	 */
	public static ShortLinkEntry[] findByOURL_PrevAndNext(
			long shortLinkEntryId, String originalURL,
			OrderByComparator<ShortLinkEntry> orderByComparator)
		throws com.liferay.osb.www.shortlink.exception.NoSuchEntryException {

		return getPersistence().findByOURL_PrevAndNext(
			shortLinkEntryId, originalURL, orderByComparator);
	}

	/**
	 * Removes all the short link entries where originalURL = &#63; from the database.
	 *
	 * @param originalURL the original url
	 */
	public static void removeByOURL(String originalURL) {
		getPersistence().removeByOURL(originalURL);
	}

	/**
	 * Returns the number of short link entries where originalURL = &#63;.
	 *
	 * @param originalURL the original url
	 * @return the number of matching short link entries
	 */
	public static int countByOURL(String originalURL) {
		return getPersistence().countByOURL(originalURL);
	}

	/**
	 * Returns the short link entry where shortURL = &#63; or throws a <code>NoSuchEntryException</code> if it could not be found.
	 *
	 * @param shortURL the short url
	 * @return the matching short link entry
	 * @throws NoSuchEntryException if a matching short link entry could not be found
	 */
	public static ShortLinkEntry findByShortURL(String shortURL)
		throws com.liferay.osb.www.shortlink.exception.NoSuchEntryException {

		return getPersistence().findByShortURL(shortURL);
	}

	/**
	 * Returns the short link entry where shortURL = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param shortURL the short url
	 * @return the matching short link entry, or <code>null</code> if a matching short link entry could not be found
	 */
	public static ShortLinkEntry fetchByShortURL(String shortURL) {
		return getPersistence().fetchByShortURL(shortURL);
	}

	/**
	 * Returns the short link entry where shortURL = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param shortURL the short url
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching short link entry, or <code>null</code> if a matching short link entry could not be found
	 */
	public static ShortLinkEntry fetchByShortURL(
		String shortURL, boolean useFinderCache) {

		return getPersistence().fetchByShortURL(shortURL, useFinderCache);
	}

	/**
	 * Removes the short link entry where shortURL = &#63; from the database.
	 *
	 * @param shortURL the short url
	 * @return the short link entry that was removed
	 */
	public static ShortLinkEntry removeByShortURL(String shortURL)
		throws com.liferay.osb.www.shortlink.exception.NoSuchEntryException {

		return getPersistence().removeByShortURL(shortURL);
	}

	/**
	 * Returns the number of short link entries where shortURL = &#63;.
	 *
	 * @param shortURL the short url
	 * @return the number of matching short link entries
	 */
	public static int countByShortURL(String shortURL) {
		return getPersistence().countByShortURL(shortURL);
	}

	/**
	 * Returns the short link entry where shortURL = &#63; or throws a <code>NoSuchEntryException</code> if it could not be found.
	 *
	 * @param shortURL the short url
	 * @return the matching short link entry
	 * @throws NoSuchEntryException if a matching short link entry could not be found
	 */
	public static ShortLinkEntry findBySURL(String shortURL)
		throws com.liferay.osb.www.shortlink.exception.NoSuchEntryException {

		return getPersistence().findBySURL(shortURL);
	}

	/**
	 * Returns the short link entry where shortURL = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param shortURL the short url
	 * @return the matching short link entry, or <code>null</code> if a matching short link entry could not be found
	 */
	public static ShortLinkEntry fetchBySURL(String shortURL) {
		return getPersistence().fetchBySURL(shortURL);
	}

	/**
	 * Returns the short link entry where shortURL = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param shortURL the short url
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching short link entry, or <code>null</code> if a matching short link entry could not be found
	 */
	public static ShortLinkEntry fetchBySURL(
		String shortURL, boolean useFinderCache) {

		return getPersistence().fetchBySURL(shortURL, useFinderCache);
	}

	/**
	 * Removes the short link entry where shortURL = &#63; from the database.
	 *
	 * @param shortURL the short url
	 * @return the short link entry that was removed
	 */
	public static ShortLinkEntry removeBySURL(String shortURL)
		throws com.liferay.osb.www.shortlink.exception.NoSuchEntryException {

		return getPersistence().removeBySURL(shortURL);
	}

	/**
	 * Returns the number of short link entries where shortURL = &#63;.
	 *
	 * @param shortURL the short url
	 * @return the number of matching short link entries
	 */
	public static int countBySURL(String shortURL) {
		return getPersistence().countBySURL(shortURL);
	}

	/**
	 * Caches the short link entry in the entity cache if it is enabled.
	 *
	 * @param shortLinkEntry the short link entry
	 */
	public static void cacheResult(ShortLinkEntry shortLinkEntry) {
		getPersistence().cacheResult(shortLinkEntry);
	}

	/**
	 * Caches the short link entries in the entity cache if it is enabled.
	 *
	 * @param shortLinkEntries the short link entries
	 */
	public static void cacheResult(List<ShortLinkEntry> shortLinkEntries) {
		getPersistence().cacheResult(shortLinkEntries);
	}

	/**
	 * Creates a new short link entry with the primary key. Does not add the short link entry to the database.
	 *
	 * @param shortLinkEntryId the primary key for the new short link entry
	 * @return the new short link entry
	 */
	public static ShortLinkEntry create(long shortLinkEntryId) {
		return getPersistence().create(shortLinkEntryId);
	}

	/**
	 * Removes the short link entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param shortLinkEntryId the primary key of the short link entry
	 * @return the short link entry that was removed
	 * @throws NoSuchEntryException if a short link entry with the primary key could not be found
	 */
	public static ShortLinkEntry remove(long shortLinkEntryId)
		throws com.liferay.osb.www.shortlink.exception.NoSuchEntryException {

		return getPersistence().remove(shortLinkEntryId);
	}

	public static ShortLinkEntry updateImpl(ShortLinkEntry shortLinkEntry) {
		return getPersistence().updateImpl(shortLinkEntry);
	}

	/**
	 * Returns the short link entry with the primary key or throws a <code>NoSuchEntryException</code> if it could not be found.
	 *
	 * @param shortLinkEntryId the primary key of the short link entry
	 * @return the short link entry
	 * @throws NoSuchEntryException if a short link entry with the primary key could not be found
	 */
	public static ShortLinkEntry findByPrimaryKey(long shortLinkEntryId)
		throws com.liferay.osb.www.shortlink.exception.NoSuchEntryException {

		return getPersistence().findByPrimaryKey(shortLinkEntryId);
	}

	/**
	 * Returns the short link entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param shortLinkEntryId the primary key of the short link entry
	 * @return the short link entry, or <code>null</code> if a short link entry with the primary key could not be found
	 */
	public static ShortLinkEntry fetchByPrimaryKey(long shortLinkEntryId) {
		return getPersistence().fetchByPrimaryKey(shortLinkEntryId);
	}

	/**
	 * Returns all the short link entries.
	 *
	 * @return the short link entries
	 */
	public static List<ShortLinkEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the short link entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ShortLinkEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of short link entries
	 * @param end the upper bound of the range of short link entries (not inclusive)
	 * @return the range of short link entries
	 */
	public static List<ShortLinkEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the short link entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ShortLinkEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of short link entries
	 * @param end the upper bound of the range of short link entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of short link entries
	 */
	public static List<ShortLinkEntry> findAll(
		int start, int end,
		OrderByComparator<ShortLinkEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the short link entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ShortLinkEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of short link entries
	 * @param end the upper bound of the range of short link entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of short link entries
	 */
	public static List<ShortLinkEntry> findAll(
		int start, int end, OrderByComparator<ShortLinkEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the short link entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of short link entries.
	 *
	 * @return the number of short link entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ShortLinkEntryPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ShortLinkEntryPersistence, ShortLinkEntryPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ShortLinkEntryPersistence.class);

		ServiceTracker<ShortLinkEntryPersistence, ShortLinkEntryPersistence>
			serviceTracker =
				new ServiceTracker
					<ShortLinkEntryPersistence, ShortLinkEntryPersistence>(
						bundle.getBundleContext(),
						ShortLinkEntryPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}