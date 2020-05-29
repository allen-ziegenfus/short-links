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

import com.liferay.osb.www.shortlink.exception.NoSuchEntryException;
import com.liferay.osb.www.shortlink.model.ShortLinkEntry;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the short link entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShortLinkEntryUtil
 * @generated
 */
@ProviderType
public interface ShortLinkEntryPersistence
	extends BasePersistence<ShortLinkEntry> {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ShortLinkEntryUtil} to access the short link entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the short link entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching short link entries
	 */
	public java.util.List<ShortLinkEntry> findByUuid(String uuid);

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
	public java.util.List<ShortLinkEntry> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<ShortLinkEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ShortLinkEntry>
			orderByComparator);

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
	public java.util.List<ShortLinkEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ShortLinkEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first short link entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching short link entry
	 * @throws NoSuchEntryException if a matching short link entry could not be found
	 */
	public ShortLinkEntry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ShortLinkEntry>
				orderByComparator)
		throws NoSuchEntryException;

	/**
	 * Returns the first short link entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching short link entry, or <code>null</code> if a matching short link entry could not be found
	 */
	public ShortLinkEntry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ShortLinkEntry>
			orderByComparator);

	/**
	 * Returns the last short link entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching short link entry
	 * @throws NoSuchEntryException if a matching short link entry could not be found
	 */
	public ShortLinkEntry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ShortLinkEntry>
				orderByComparator)
		throws NoSuchEntryException;

	/**
	 * Returns the last short link entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching short link entry, or <code>null</code> if a matching short link entry could not be found
	 */
	public ShortLinkEntry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ShortLinkEntry>
			orderByComparator);

	/**
	 * Returns the short link entries before and after the current short link entry in the ordered set where uuid = &#63;.
	 *
	 * @param shortLinkEntryId the primary key of the current short link entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next short link entry
	 * @throws NoSuchEntryException if a short link entry with the primary key could not be found
	 */
	public ShortLinkEntry[] findByUuid_PrevAndNext(
			long shortLinkEntryId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ShortLinkEntry>
				orderByComparator)
		throws NoSuchEntryException;

	/**
	 * Removes all the short link entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of short link entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching short link entries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the short link entries where originalURL = &#63;.
	 *
	 * @param originalURL the original url
	 * @return the matching short link entries
	 */
	public java.util.List<ShortLinkEntry> findByOURL(String originalURL);

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
	public java.util.List<ShortLinkEntry> findByOURL(
		String originalURL, int start, int end);

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
	public java.util.List<ShortLinkEntry> findByOURL(
		String originalURL, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ShortLinkEntry>
			orderByComparator);

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
	public java.util.List<ShortLinkEntry> findByOURL(
		String originalURL, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ShortLinkEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first short link entry in the ordered set where originalURL = &#63;.
	 *
	 * @param originalURL the original url
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching short link entry
	 * @throws NoSuchEntryException if a matching short link entry could not be found
	 */
	public ShortLinkEntry findByOURL_First(
			String originalURL,
			com.liferay.portal.kernel.util.OrderByComparator<ShortLinkEntry>
				orderByComparator)
		throws NoSuchEntryException;

	/**
	 * Returns the first short link entry in the ordered set where originalURL = &#63;.
	 *
	 * @param originalURL the original url
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching short link entry, or <code>null</code> if a matching short link entry could not be found
	 */
	public ShortLinkEntry fetchByOURL_First(
		String originalURL,
		com.liferay.portal.kernel.util.OrderByComparator<ShortLinkEntry>
			orderByComparator);

	/**
	 * Returns the last short link entry in the ordered set where originalURL = &#63;.
	 *
	 * @param originalURL the original url
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching short link entry
	 * @throws NoSuchEntryException if a matching short link entry could not be found
	 */
	public ShortLinkEntry findByOURL_Last(
			String originalURL,
			com.liferay.portal.kernel.util.OrderByComparator<ShortLinkEntry>
				orderByComparator)
		throws NoSuchEntryException;

	/**
	 * Returns the last short link entry in the ordered set where originalURL = &#63;.
	 *
	 * @param originalURL the original url
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching short link entry, or <code>null</code> if a matching short link entry could not be found
	 */
	public ShortLinkEntry fetchByOURL_Last(
		String originalURL,
		com.liferay.portal.kernel.util.OrderByComparator<ShortLinkEntry>
			orderByComparator);

	/**
	 * Returns the short link entries before and after the current short link entry in the ordered set where originalURL = &#63;.
	 *
	 * @param shortLinkEntryId the primary key of the current short link entry
	 * @param originalURL the original url
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next short link entry
	 * @throws NoSuchEntryException if a short link entry with the primary key could not be found
	 */
	public ShortLinkEntry[] findByOURL_PrevAndNext(
			long shortLinkEntryId, String originalURL,
			com.liferay.portal.kernel.util.OrderByComparator<ShortLinkEntry>
				orderByComparator)
		throws NoSuchEntryException;

	/**
	 * Removes all the short link entries where originalURL = &#63; from the database.
	 *
	 * @param originalURL the original url
	 */
	public void removeByOURL(String originalURL);

	/**
	 * Returns the number of short link entries where originalURL = &#63;.
	 *
	 * @param originalURL the original url
	 * @return the number of matching short link entries
	 */
	public int countByOURL(String originalURL);

	/**
	 * Returns the short link entry where shortURL = &#63; or throws a <code>NoSuchEntryException</code> if it could not be found.
	 *
	 * @param shortURL the short url
	 * @return the matching short link entry
	 * @throws NoSuchEntryException if a matching short link entry could not be found
	 */
	public ShortLinkEntry findByShortURL(String shortURL)
		throws NoSuchEntryException;

	/**
	 * Returns the short link entry where shortURL = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param shortURL the short url
	 * @return the matching short link entry, or <code>null</code> if a matching short link entry could not be found
	 */
	public ShortLinkEntry fetchByShortURL(String shortURL);

	/**
	 * Returns the short link entry where shortURL = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param shortURL the short url
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching short link entry, or <code>null</code> if a matching short link entry could not be found
	 */
	public ShortLinkEntry fetchByShortURL(
		String shortURL, boolean useFinderCache);

	/**
	 * Removes the short link entry where shortURL = &#63; from the database.
	 *
	 * @param shortURL the short url
	 * @return the short link entry that was removed
	 */
	public ShortLinkEntry removeByShortURL(String shortURL)
		throws NoSuchEntryException;

	/**
	 * Returns the number of short link entries where shortURL = &#63;.
	 *
	 * @param shortURL the short url
	 * @return the number of matching short link entries
	 */
	public int countByShortURL(String shortURL);

	/**
	 * Returns the short link entry where shortURL = &#63; or throws a <code>NoSuchEntryException</code> if it could not be found.
	 *
	 * @param shortURL the short url
	 * @return the matching short link entry
	 * @throws NoSuchEntryException if a matching short link entry could not be found
	 */
	public ShortLinkEntry findBySURL(String shortURL)
		throws NoSuchEntryException;

	/**
	 * Returns the short link entry where shortURL = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param shortURL the short url
	 * @return the matching short link entry, or <code>null</code> if a matching short link entry could not be found
	 */
	public ShortLinkEntry fetchBySURL(String shortURL);

	/**
	 * Returns the short link entry where shortURL = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param shortURL the short url
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching short link entry, or <code>null</code> if a matching short link entry could not be found
	 */
	public ShortLinkEntry fetchBySURL(String shortURL, boolean useFinderCache);

	/**
	 * Removes the short link entry where shortURL = &#63; from the database.
	 *
	 * @param shortURL the short url
	 * @return the short link entry that was removed
	 */
	public ShortLinkEntry removeBySURL(String shortURL)
		throws NoSuchEntryException;

	/**
	 * Returns the number of short link entries where shortURL = &#63;.
	 *
	 * @param shortURL the short url
	 * @return the number of matching short link entries
	 */
	public int countBySURL(String shortURL);

	/**
	 * Caches the short link entry in the entity cache if it is enabled.
	 *
	 * @param shortLinkEntry the short link entry
	 */
	public void cacheResult(ShortLinkEntry shortLinkEntry);

	/**
	 * Caches the short link entries in the entity cache if it is enabled.
	 *
	 * @param shortLinkEntries the short link entries
	 */
	public void cacheResult(java.util.List<ShortLinkEntry> shortLinkEntries);

	/**
	 * Creates a new short link entry with the primary key. Does not add the short link entry to the database.
	 *
	 * @param shortLinkEntryId the primary key for the new short link entry
	 * @return the new short link entry
	 */
	public ShortLinkEntry create(long shortLinkEntryId);

	/**
	 * Removes the short link entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param shortLinkEntryId the primary key of the short link entry
	 * @return the short link entry that was removed
	 * @throws NoSuchEntryException if a short link entry with the primary key could not be found
	 */
	public ShortLinkEntry remove(long shortLinkEntryId)
		throws NoSuchEntryException;

	public ShortLinkEntry updateImpl(ShortLinkEntry shortLinkEntry);

	/**
	 * Returns the short link entry with the primary key or throws a <code>NoSuchEntryException</code> if it could not be found.
	 *
	 * @param shortLinkEntryId the primary key of the short link entry
	 * @return the short link entry
	 * @throws NoSuchEntryException if a short link entry with the primary key could not be found
	 */
	public ShortLinkEntry findByPrimaryKey(long shortLinkEntryId)
		throws NoSuchEntryException;

	/**
	 * Returns the short link entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param shortLinkEntryId the primary key of the short link entry
	 * @return the short link entry, or <code>null</code> if a short link entry with the primary key could not be found
	 */
	public ShortLinkEntry fetchByPrimaryKey(long shortLinkEntryId);

	/**
	 * Returns all the short link entries.
	 *
	 * @return the short link entries
	 */
	public java.util.List<ShortLinkEntry> findAll();

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
	public java.util.List<ShortLinkEntry> findAll(int start, int end);

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
	public java.util.List<ShortLinkEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ShortLinkEntry>
			orderByComparator);

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
	public java.util.List<ShortLinkEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ShortLinkEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the short link entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of short link entries.
	 *
	 * @return the number of short link entries
	 */
	public int countAll();

}