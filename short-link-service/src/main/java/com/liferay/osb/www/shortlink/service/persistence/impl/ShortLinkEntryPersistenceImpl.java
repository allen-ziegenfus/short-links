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

package com.liferay.osb.www.shortlink.service.persistence.impl;

import com.liferay.osb.www.shortlink.exception.NoSuchEntryException;
import com.liferay.osb.www.shortlink.model.ShortLinkEntry;
import com.liferay.osb.www.shortlink.model.impl.ShortLinkEntryImpl;
import com.liferay.osb.www.shortlink.model.impl.ShortLinkEntryModelImpl;
import com.liferay.osb.www.shortlink.service.persistence.ShortLinkEntryPersistence;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the short link entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ShortLinkEntryPersistenceImpl
	extends BasePersistenceImpl<ShortLinkEntry>
	implements ShortLinkEntryPersistence {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ShortLinkEntryUtil</code> to access the short link entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ShortLinkEntryImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the short link entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching short link entries
	 */
	@Override
	public List<ShortLinkEntry> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ShortLinkEntry> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<ShortLinkEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ShortLinkEntry> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<ShortLinkEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ShortLinkEntry> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<ShortLinkEntry> list = null;

		if (useFinderCache) {
			list = (List<ShortLinkEntry>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ShortLinkEntry shortLinkEntry : list) {
					if (!uuid.equals(shortLinkEntry.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_SHORTLINKENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(ShortLinkEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<ShortLinkEntry>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ShortLinkEntry>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first short link entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching short link entry
	 * @throws NoSuchEntryException if a matching short link entry could not be found
	 */
	@Override
	public ShortLinkEntry findByUuid_First(
			String uuid, OrderByComparator<ShortLinkEntry> orderByComparator)
		throws NoSuchEntryException {

		ShortLinkEntry shortLinkEntry = fetchByUuid_First(
			uuid, orderByComparator);

		if (shortLinkEntry != null) {
			return shortLinkEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the first short link entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching short link entry, or <code>null</code> if a matching short link entry could not be found
	 */
	@Override
	public ShortLinkEntry fetchByUuid_First(
		String uuid, OrderByComparator<ShortLinkEntry> orderByComparator) {

		List<ShortLinkEntry> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last short link entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching short link entry
	 * @throws NoSuchEntryException if a matching short link entry could not be found
	 */
	@Override
	public ShortLinkEntry findByUuid_Last(
			String uuid, OrderByComparator<ShortLinkEntry> orderByComparator)
		throws NoSuchEntryException {

		ShortLinkEntry shortLinkEntry = fetchByUuid_Last(
			uuid, orderByComparator);

		if (shortLinkEntry != null) {
			return shortLinkEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the last short link entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching short link entry, or <code>null</code> if a matching short link entry could not be found
	 */
	@Override
	public ShortLinkEntry fetchByUuid_Last(
		String uuid, OrderByComparator<ShortLinkEntry> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ShortLinkEntry> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ShortLinkEntry[] findByUuid_PrevAndNext(
			long shortLinkEntryId, String uuid,
			OrderByComparator<ShortLinkEntry> orderByComparator)
		throws NoSuchEntryException {

		uuid = Objects.toString(uuid, "");

		ShortLinkEntry shortLinkEntry = findByPrimaryKey(shortLinkEntryId);

		Session session = null;

		try {
			session = openSession();

			ShortLinkEntry[] array = new ShortLinkEntryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, shortLinkEntry, uuid, orderByComparator, true);

			array[1] = shortLinkEntry;

			array[2] = getByUuid_PrevAndNext(
				session, shortLinkEntry, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ShortLinkEntry getByUuid_PrevAndNext(
		Session session, ShortLinkEntry shortLinkEntry, String uuid,
		OrderByComparator<ShortLinkEntry> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SHORTLINKENTRY_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ShortLinkEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						shortLinkEntry)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<ShortLinkEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the short link entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ShortLinkEntry shortLinkEntry :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(shortLinkEntry);
		}
	}

	/**
	 * Returns the number of short link entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching short link entries
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SHORTLINKENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"shortLinkEntry.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(shortLinkEntry.uuid IS NULL OR shortLinkEntry.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByOURL;
	private FinderPath _finderPathWithoutPaginationFindByOURL;
	private FinderPath _finderPathCountByOURL;

	/**
	 * Returns all the short link entries where originalURL = &#63;.
	 *
	 * @param originalURL the original url
	 * @return the matching short link entries
	 */
	@Override
	public List<ShortLinkEntry> findByOURL(String originalURL) {
		return findByOURL(
			originalURL, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ShortLinkEntry> findByOURL(
		String originalURL, int start, int end) {

		return findByOURL(originalURL, start, end, null);
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
	@Override
	public List<ShortLinkEntry> findByOURL(
		String originalURL, int start, int end,
		OrderByComparator<ShortLinkEntry> orderByComparator) {

		return findByOURL(originalURL, start, end, orderByComparator, true);
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
	@Override
	public List<ShortLinkEntry> findByOURL(
		String originalURL, int start, int end,
		OrderByComparator<ShortLinkEntry> orderByComparator,
		boolean useFinderCache) {

		originalURL = Objects.toString(originalURL, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByOURL;
				finderArgs = new Object[] {originalURL};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByOURL;
			finderArgs = new Object[] {
				originalURL, start, end, orderByComparator
			};
		}

		List<ShortLinkEntry> list = null;

		if (useFinderCache) {
			list = (List<ShortLinkEntry>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ShortLinkEntry shortLinkEntry : list) {
					if (!originalURL.equals(shortLinkEntry.getOriginalURL())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_SHORTLINKENTRY_WHERE);

			boolean bindOriginalURL = false;

			if (originalURL.isEmpty()) {
				query.append(_FINDER_COLUMN_OURL_ORIGINALURL_3);
			}
			else {
				bindOriginalURL = true;

				query.append(_FINDER_COLUMN_OURL_ORIGINALURL_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(ShortLinkEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindOriginalURL) {
					qPos.add(originalURL);
				}

				if (!pagination) {
					list = (List<ShortLinkEntry>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ShortLinkEntry>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first short link entry in the ordered set where originalURL = &#63;.
	 *
	 * @param originalURL the original url
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching short link entry
	 * @throws NoSuchEntryException if a matching short link entry could not be found
	 */
	@Override
	public ShortLinkEntry findByOURL_First(
			String originalURL,
			OrderByComparator<ShortLinkEntry> orderByComparator)
		throws NoSuchEntryException {

		ShortLinkEntry shortLinkEntry = fetchByOURL_First(
			originalURL, orderByComparator);

		if (shortLinkEntry != null) {
			return shortLinkEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("originalURL=");
		msg.append(originalURL);

		msg.append("}");

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the first short link entry in the ordered set where originalURL = &#63;.
	 *
	 * @param originalURL the original url
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching short link entry, or <code>null</code> if a matching short link entry could not be found
	 */
	@Override
	public ShortLinkEntry fetchByOURL_First(
		String originalURL,
		OrderByComparator<ShortLinkEntry> orderByComparator) {

		List<ShortLinkEntry> list = findByOURL(
			originalURL, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last short link entry in the ordered set where originalURL = &#63;.
	 *
	 * @param originalURL the original url
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching short link entry
	 * @throws NoSuchEntryException if a matching short link entry could not be found
	 */
	@Override
	public ShortLinkEntry findByOURL_Last(
			String originalURL,
			OrderByComparator<ShortLinkEntry> orderByComparator)
		throws NoSuchEntryException {

		ShortLinkEntry shortLinkEntry = fetchByOURL_Last(
			originalURL, orderByComparator);

		if (shortLinkEntry != null) {
			return shortLinkEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("originalURL=");
		msg.append(originalURL);

		msg.append("}");

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the last short link entry in the ordered set where originalURL = &#63;.
	 *
	 * @param originalURL the original url
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching short link entry, or <code>null</code> if a matching short link entry could not be found
	 */
	@Override
	public ShortLinkEntry fetchByOURL_Last(
		String originalURL,
		OrderByComparator<ShortLinkEntry> orderByComparator) {

		int count = countByOURL(originalURL);

		if (count == 0) {
			return null;
		}

		List<ShortLinkEntry> list = findByOURL(
			originalURL, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ShortLinkEntry[] findByOURL_PrevAndNext(
			long shortLinkEntryId, String originalURL,
			OrderByComparator<ShortLinkEntry> orderByComparator)
		throws NoSuchEntryException {

		originalURL = Objects.toString(originalURL, "");

		ShortLinkEntry shortLinkEntry = findByPrimaryKey(shortLinkEntryId);

		Session session = null;

		try {
			session = openSession();

			ShortLinkEntry[] array = new ShortLinkEntryImpl[3];

			array[0] = getByOURL_PrevAndNext(
				session, shortLinkEntry, originalURL, orderByComparator, true);

			array[1] = shortLinkEntry;

			array[2] = getByOURL_PrevAndNext(
				session, shortLinkEntry, originalURL, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ShortLinkEntry getByOURL_PrevAndNext(
		Session session, ShortLinkEntry shortLinkEntry, String originalURL,
		OrderByComparator<ShortLinkEntry> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SHORTLINKENTRY_WHERE);

		boolean bindOriginalURL = false;

		if (originalURL.isEmpty()) {
			query.append(_FINDER_COLUMN_OURL_ORIGINALURL_3);
		}
		else {
			bindOriginalURL = true;

			query.append(_FINDER_COLUMN_OURL_ORIGINALURL_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ShortLinkEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindOriginalURL) {
			qPos.add(originalURL);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						shortLinkEntry)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<ShortLinkEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the short link entries where originalURL = &#63; from the database.
	 *
	 * @param originalURL the original url
	 */
	@Override
	public void removeByOURL(String originalURL) {
		for (ShortLinkEntry shortLinkEntry :
				findByOURL(
					originalURL, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(shortLinkEntry);
		}
	}

	/**
	 * Returns the number of short link entries where originalURL = &#63;.
	 *
	 * @param originalURL the original url
	 * @return the number of matching short link entries
	 */
	@Override
	public int countByOURL(String originalURL) {
		originalURL = Objects.toString(originalURL, "");

		FinderPath finderPath = _finderPathCountByOURL;

		Object[] finderArgs = new Object[] {originalURL};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SHORTLINKENTRY_WHERE);

			boolean bindOriginalURL = false;

			if (originalURL.isEmpty()) {
				query.append(_FINDER_COLUMN_OURL_ORIGINALURL_3);
			}
			else {
				bindOriginalURL = true;

				query.append(_FINDER_COLUMN_OURL_ORIGINALURL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindOriginalURL) {
					qPos.add(originalURL);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_OURL_ORIGINALURL_2 =
		"shortLinkEntry.originalURL = ?";

	private static final String _FINDER_COLUMN_OURL_ORIGINALURL_3 =
		"(shortLinkEntry.originalURL IS NULL OR shortLinkEntry.originalURL = '')";

	private FinderPath _finderPathFetchByShortURL;
	private FinderPath _finderPathCountByShortURL;

	/**
	 * Returns the short link entry where shortURL = &#63; or throws a <code>NoSuchEntryException</code> if it could not be found.
	 *
	 * @param shortURL the short url
	 * @return the matching short link entry
	 * @throws NoSuchEntryException if a matching short link entry could not be found
	 */
	@Override
	public ShortLinkEntry findByShortURL(String shortURL)
		throws NoSuchEntryException {

		ShortLinkEntry shortLinkEntry = fetchByShortURL(shortURL);

		if (shortLinkEntry == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("shortURL=");
			msg.append(shortURL);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchEntryException(msg.toString());
		}

		return shortLinkEntry;
	}

	/**
	 * Returns the short link entry where shortURL = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param shortURL the short url
	 * @return the matching short link entry, or <code>null</code> if a matching short link entry could not be found
	 */
	@Override
	public ShortLinkEntry fetchByShortURL(String shortURL) {
		return fetchByShortURL(shortURL, true);
	}

	/**
	 * Returns the short link entry where shortURL = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param shortURL the short url
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching short link entry, or <code>null</code> if a matching short link entry could not be found
	 */
	@Override
	public ShortLinkEntry fetchByShortURL(
		String shortURL, boolean useFinderCache) {

		shortURL = Objects.toString(shortURL, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {shortURL};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByShortURL, finderArgs, this);
		}

		if (result instanceof ShortLinkEntry) {
			ShortLinkEntry shortLinkEntry = (ShortLinkEntry)result;

			if (!Objects.equals(shortURL, shortLinkEntry.getShortURL())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_SHORTLINKENTRY_WHERE);

			boolean bindShortURL = false;

			if (shortURL.isEmpty()) {
				query.append(_FINDER_COLUMN_SHORTURL_SHORTURL_3);
			}
			else {
				bindShortURL = true;

				query.append(_FINDER_COLUMN_SHORTURL_SHORTURL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindShortURL) {
					qPos.add(shortURL);
				}

				List<ShortLinkEntry> list = q.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByShortURL, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {shortURL};
							}

							_log.warn(
								"ShortLinkEntryPersistenceImpl.fetchByShortURL(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ShortLinkEntry shortLinkEntry = list.get(0);

					result = shortLinkEntry;

					cacheResult(shortLinkEntry);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByShortURL, finderArgs);
				}

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (ShortLinkEntry)result;
		}
	}

	/**
	 * Removes the short link entry where shortURL = &#63; from the database.
	 *
	 * @param shortURL the short url
	 * @return the short link entry that was removed
	 */
	@Override
	public ShortLinkEntry removeByShortURL(String shortURL)
		throws NoSuchEntryException {

		ShortLinkEntry shortLinkEntry = findByShortURL(shortURL);

		return remove(shortLinkEntry);
	}

	/**
	 * Returns the number of short link entries where shortURL = &#63;.
	 *
	 * @param shortURL the short url
	 * @return the number of matching short link entries
	 */
	@Override
	public int countByShortURL(String shortURL) {
		shortURL = Objects.toString(shortURL, "");

		FinderPath finderPath = _finderPathCountByShortURL;

		Object[] finderArgs = new Object[] {shortURL};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SHORTLINKENTRY_WHERE);

			boolean bindShortURL = false;

			if (shortURL.isEmpty()) {
				query.append(_FINDER_COLUMN_SHORTURL_SHORTURL_3);
			}
			else {
				bindShortURL = true;

				query.append(_FINDER_COLUMN_SHORTURL_SHORTURL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindShortURL) {
					qPos.add(shortURL);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_SHORTURL_SHORTURL_2 =
		"shortLinkEntry.shortURL = ?";

	private static final String _FINDER_COLUMN_SHORTURL_SHORTURL_3 =
		"(shortLinkEntry.shortURL IS NULL OR shortLinkEntry.shortURL = '')";

	private FinderPath _finderPathFetchBySURL;
	private FinderPath _finderPathCountBySURL;

	/**
	 * Returns the short link entry where shortURL = &#63; or throws a <code>NoSuchEntryException</code> if it could not be found.
	 *
	 * @param shortURL the short url
	 * @return the matching short link entry
	 * @throws NoSuchEntryException if a matching short link entry could not be found
	 */
	@Override
	public ShortLinkEntry findBySURL(String shortURL)
		throws NoSuchEntryException {

		ShortLinkEntry shortLinkEntry = fetchBySURL(shortURL);

		if (shortLinkEntry == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("shortURL=");
			msg.append(shortURL);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchEntryException(msg.toString());
		}

		return shortLinkEntry;
	}

	/**
	 * Returns the short link entry where shortURL = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param shortURL the short url
	 * @return the matching short link entry, or <code>null</code> if a matching short link entry could not be found
	 */
	@Override
	public ShortLinkEntry fetchBySURL(String shortURL) {
		return fetchBySURL(shortURL, true);
	}

	/**
	 * Returns the short link entry where shortURL = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param shortURL the short url
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching short link entry, or <code>null</code> if a matching short link entry could not be found
	 */
	@Override
	public ShortLinkEntry fetchBySURL(String shortURL, boolean useFinderCache) {
		shortURL = Objects.toString(shortURL, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {shortURL};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBySURL, finderArgs, this);
		}

		if (result instanceof ShortLinkEntry) {
			ShortLinkEntry shortLinkEntry = (ShortLinkEntry)result;

			if (!Objects.equals(shortURL, shortLinkEntry.getShortURL())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_SHORTLINKENTRY_WHERE);

			boolean bindShortURL = false;

			if (shortURL.isEmpty()) {
				query.append(_FINDER_COLUMN_SURL_SHORTURL_3);
			}
			else {
				bindShortURL = true;

				query.append(_FINDER_COLUMN_SURL_SHORTURL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindShortURL) {
					qPos.add(shortURL);
				}

				List<ShortLinkEntry> list = q.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBySURL, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {shortURL};
							}

							_log.warn(
								"ShortLinkEntryPersistenceImpl.fetchBySURL(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ShortLinkEntry shortLinkEntry = list.get(0);

					result = shortLinkEntry;

					cacheResult(shortLinkEntry);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchBySURL, finderArgs);
				}

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (ShortLinkEntry)result;
		}
	}

	/**
	 * Removes the short link entry where shortURL = &#63; from the database.
	 *
	 * @param shortURL the short url
	 * @return the short link entry that was removed
	 */
	@Override
	public ShortLinkEntry removeBySURL(String shortURL)
		throws NoSuchEntryException {

		ShortLinkEntry shortLinkEntry = findBySURL(shortURL);

		return remove(shortLinkEntry);
	}

	/**
	 * Returns the number of short link entries where shortURL = &#63;.
	 *
	 * @param shortURL the short url
	 * @return the number of matching short link entries
	 */
	@Override
	public int countBySURL(String shortURL) {
		shortURL = Objects.toString(shortURL, "");

		FinderPath finderPath = _finderPathCountBySURL;

		Object[] finderArgs = new Object[] {shortURL};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SHORTLINKENTRY_WHERE);

			boolean bindShortURL = false;

			if (shortURL.isEmpty()) {
				query.append(_FINDER_COLUMN_SURL_SHORTURL_3);
			}
			else {
				bindShortURL = true;

				query.append(_FINDER_COLUMN_SURL_SHORTURL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindShortURL) {
					qPos.add(shortURL);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_SURL_SHORTURL_2 =
		"shortLinkEntry.shortURL = ?";

	private static final String _FINDER_COLUMN_SURL_SHORTURL_3 =
		"(shortLinkEntry.shortURL IS NULL OR shortLinkEntry.shortURL = '')";

	public ShortLinkEntryPersistenceImpl() {
		setModelClass(ShortLinkEntry.class);

		setModelImplClass(ShortLinkEntryImpl.class);
		setModelPKClass(long.class);
		setEntityCacheEnabled(ShortLinkEntryModelImpl.ENTITY_CACHE_ENABLED);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the short link entry in the entity cache if it is enabled.
	 *
	 * @param shortLinkEntry the short link entry
	 */
	@Override
	public void cacheResult(ShortLinkEntry shortLinkEntry) {
		entityCache.putResult(
			ShortLinkEntryModelImpl.ENTITY_CACHE_ENABLED,
			ShortLinkEntryImpl.class, shortLinkEntry.getPrimaryKey(),
			shortLinkEntry);

		finderCache.putResult(
			_finderPathFetchByShortURL,
			new Object[] {shortLinkEntry.getShortURL()}, shortLinkEntry);

		finderCache.putResult(
			_finderPathFetchBySURL, new Object[] {shortLinkEntry.getShortURL()},
			shortLinkEntry);

		shortLinkEntry.resetOriginalValues();
	}

	/**
	 * Caches the short link entries in the entity cache if it is enabled.
	 *
	 * @param shortLinkEntries the short link entries
	 */
	@Override
	public void cacheResult(List<ShortLinkEntry> shortLinkEntries) {
		for (ShortLinkEntry shortLinkEntry : shortLinkEntries) {
			if (entityCache.getResult(
					ShortLinkEntryModelImpl.ENTITY_CACHE_ENABLED,
					ShortLinkEntryImpl.class, shortLinkEntry.getPrimaryKey()) ==
						null) {

				cacheResult(shortLinkEntry);
			}
			else {
				shortLinkEntry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all short link entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ShortLinkEntryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the short link entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ShortLinkEntry shortLinkEntry) {
		entityCache.removeResult(
			ShortLinkEntryModelImpl.ENTITY_CACHE_ENABLED,
			ShortLinkEntryImpl.class, shortLinkEntry.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((ShortLinkEntryModelImpl)shortLinkEntry, true);
	}

	@Override
	public void clearCache(List<ShortLinkEntry> shortLinkEntries) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ShortLinkEntry shortLinkEntry : shortLinkEntries) {
			entityCache.removeResult(
				ShortLinkEntryModelImpl.ENTITY_CACHE_ENABLED,
				ShortLinkEntryImpl.class, shortLinkEntry.getPrimaryKey());

			clearUniqueFindersCache(
				(ShortLinkEntryModelImpl)shortLinkEntry, true);
		}
	}

	protected void cacheUniqueFindersCache(
		ShortLinkEntryModelImpl shortLinkEntryModelImpl) {

		Object[] args = new Object[] {shortLinkEntryModelImpl.getShortURL()};

		finderCache.putResult(
			_finderPathCountByShortURL, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByShortURL, args, shortLinkEntryModelImpl, false);

		args = new Object[] {shortLinkEntryModelImpl.getShortURL()};

		finderCache.putResult(
			_finderPathCountBySURL, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchBySURL, args, shortLinkEntryModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		ShortLinkEntryModelImpl shortLinkEntryModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				shortLinkEntryModelImpl.getShortURL()
			};

			finderCache.removeResult(_finderPathCountByShortURL, args);
			finderCache.removeResult(_finderPathFetchByShortURL, args);
		}

		if ((shortLinkEntryModelImpl.getColumnBitmask() &
			 _finderPathFetchByShortURL.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				shortLinkEntryModelImpl.getOriginalShortURL()
			};

			finderCache.removeResult(_finderPathCountByShortURL, args);
			finderCache.removeResult(_finderPathFetchByShortURL, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				shortLinkEntryModelImpl.getShortURL()
			};

			finderCache.removeResult(_finderPathCountBySURL, args);
			finderCache.removeResult(_finderPathFetchBySURL, args);
		}

		if ((shortLinkEntryModelImpl.getColumnBitmask() &
			 _finderPathFetchBySURL.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				shortLinkEntryModelImpl.getOriginalShortURL()
			};

			finderCache.removeResult(_finderPathCountBySURL, args);
			finderCache.removeResult(_finderPathFetchBySURL, args);
		}
	}

	/**
	 * Creates a new short link entry with the primary key. Does not add the short link entry to the database.
	 *
	 * @param shortLinkEntryId the primary key for the new short link entry
	 * @return the new short link entry
	 */
	@Override
	public ShortLinkEntry create(long shortLinkEntryId) {
		ShortLinkEntry shortLinkEntry = new ShortLinkEntryImpl();

		shortLinkEntry.setNew(true);
		shortLinkEntry.setPrimaryKey(shortLinkEntryId);

		String uuid = PortalUUIDUtil.generate();

		shortLinkEntry.setUuid(uuid);

		return shortLinkEntry;
	}

	/**
	 * Removes the short link entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param shortLinkEntryId the primary key of the short link entry
	 * @return the short link entry that was removed
	 * @throws NoSuchEntryException if a short link entry with the primary key could not be found
	 */
	@Override
	public ShortLinkEntry remove(long shortLinkEntryId)
		throws NoSuchEntryException {

		return remove((Serializable)shortLinkEntryId);
	}

	/**
	 * Removes the short link entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the short link entry
	 * @return the short link entry that was removed
	 * @throws NoSuchEntryException if a short link entry with the primary key could not be found
	 */
	@Override
	public ShortLinkEntry remove(Serializable primaryKey)
		throws NoSuchEntryException {

		Session session = null;

		try {
			session = openSession();

			ShortLinkEntry shortLinkEntry = (ShortLinkEntry)session.get(
				ShortLinkEntryImpl.class, primaryKey);

			if (shortLinkEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(shortLinkEntry);
		}
		catch (NoSuchEntryException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected ShortLinkEntry removeImpl(ShortLinkEntry shortLinkEntry) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(shortLinkEntry)) {
				shortLinkEntry = (ShortLinkEntry)session.get(
					ShortLinkEntryImpl.class,
					shortLinkEntry.getPrimaryKeyObj());
			}

			if (shortLinkEntry != null) {
				session.delete(shortLinkEntry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (shortLinkEntry != null) {
			clearCache(shortLinkEntry);
		}

		return shortLinkEntry;
	}

	@Override
	public ShortLinkEntry updateImpl(ShortLinkEntry shortLinkEntry) {
		boolean isNew = shortLinkEntry.isNew();

		if (!(shortLinkEntry instanceof ShortLinkEntryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(shortLinkEntry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					shortLinkEntry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in shortLinkEntry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ShortLinkEntry implementation " +
					shortLinkEntry.getClass());
		}

		ShortLinkEntryModelImpl shortLinkEntryModelImpl =
			(ShortLinkEntryModelImpl)shortLinkEntry;

		if (Validator.isNull(shortLinkEntry.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			shortLinkEntry.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (shortLinkEntry.getCreateDate() == null)) {
			if (serviceContext == null) {
				shortLinkEntry.setCreateDate(now);
			}
			else {
				shortLinkEntry.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!shortLinkEntryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				shortLinkEntry.setModifiedDate(now);
			}
			else {
				shortLinkEntry.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (shortLinkEntry.isNew()) {
				session.save(shortLinkEntry);

				shortLinkEntry.setNew(false);
			}
			else {
				shortLinkEntry = (ShortLinkEntry)session.merge(shortLinkEntry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!ShortLinkEntryModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {shortLinkEntryModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {shortLinkEntryModelImpl.getOriginalURL()};

			finderCache.removeResult(_finderPathCountByOURL, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByOURL, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((shortLinkEntryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					shortLinkEntryModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {shortLinkEntryModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((shortLinkEntryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByOURL.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					shortLinkEntryModelImpl.getOriginalOriginalURL()
				};

				finderCache.removeResult(_finderPathCountByOURL, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByOURL, args);

				args = new Object[] {shortLinkEntryModelImpl.getOriginalURL()};

				finderCache.removeResult(_finderPathCountByOURL, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByOURL, args);
			}
		}

		entityCache.putResult(
			ShortLinkEntryModelImpl.ENTITY_CACHE_ENABLED,
			ShortLinkEntryImpl.class, shortLinkEntry.getPrimaryKey(),
			shortLinkEntry, false);

		clearUniqueFindersCache(shortLinkEntryModelImpl, false);
		cacheUniqueFindersCache(shortLinkEntryModelImpl);

		shortLinkEntry.resetOriginalValues();

		return shortLinkEntry;
	}

	/**
	 * Returns the short link entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the short link entry
	 * @return the short link entry
	 * @throws NoSuchEntryException if a short link entry with the primary key could not be found
	 */
	@Override
	public ShortLinkEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEntryException {

		ShortLinkEntry shortLinkEntry = fetchByPrimaryKey(primaryKey);

		if (shortLinkEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return shortLinkEntry;
	}

	/**
	 * Returns the short link entry with the primary key or throws a <code>NoSuchEntryException</code> if it could not be found.
	 *
	 * @param shortLinkEntryId the primary key of the short link entry
	 * @return the short link entry
	 * @throws NoSuchEntryException if a short link entry with the primary key could not be found
	 */
	@Override
	public ShortLinkEntry findByPrimaryKey(long shortLinkEntryId)
		throws NoSuchEntryException {

		return findByPrimaryKey((Serializable)shortLinkEntryId);
	}

	/**
	 * Returns the short link entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param shortLinkEntryId the primary key of the short link entry
	 * @return the short link entry, or <code>null</code> if a short link entry with the primary key could not be found
	 */
	@Override
	public ShortLinkEntry fetchByPrimaryKey(long shortLinkEntryId) {
		return fetchByPrimaryKey((Serializable)shortLinkEntryId);
	}

	/**
	 * Returns all the short link entries.
	 *
	 * @return the short link entries
	 */
	@Override
	public List<ShortLinkEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ShortLinkEntry> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<ShortLinkEntry> findAll(
		int start, int end,
		OrderByComparator<ShortLinkEntry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<ShortLinkEntry> findAll(
		int start, int end, OrderByComparator<ShortLinkEntry> orderByComparator,
		boolean useFinderCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<ShortLinkEntry> list = null;

		if (useFinderCache) {
			list = (List<ShortLinkEntry>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_SHORTLINKENTRY);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SHORTLINKENTRY;

				if (pagination) {
					sql = sql.concat(ShortLinkEntryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ShortLinkEntry>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ShortLinkEntry>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the short link entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ShortLinkEntry shortLinkEntry : findAll()) {
			remove(shortLinkEntry);
		}
	}

	/**
	 * Returns the number of short link entries.
	 *
	 * @return the number of short link entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SHORTLINKENTRY);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "shortLinkEntryId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SHORTLINKENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ShortLinkEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the short link entry persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			ShortLinkEntryModelImpl.ENTITY_CACHE_ENABLED,
			ShortLinkEntryModelImpl.FINDER_CACHE_ENABLED,
			ShortLinkEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			ShortLinkEntryModelImpl.ENTITY_CACHE_ENABLED,
			ShortLinkEntryModelImpl.FINDER_CACHE_ENABLED,
			ShortLinkEntryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);

		_finderPathCountAll = new FinderPath(
			ShortLinkEntryModelImpl.ENTITY_CACHE_ENABLED,
			ShortLinkEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			ShortLinkEntryModelImpl.ENTITY_CACHE_ENABLED,
			ShortLinkEntryModelImpl.FINDER_CACHE_ENABLED,
			ShortLinkEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			ShortLinkEntryModelImpl.ENTITY_CACHE_ENABLED,
			ShortLinkEntryModelImpl.FINDER_CACHE_ENABLED,
			ShortLinkEntryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUuid", new String[] {String.class.getName()},
			ShortLinkEntryModelImpl.UUID_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			ShortLinkEntryModelImpl.ENTITY_CACHE_ENABLED,
			ShortLinkEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByOURL = new FinderPath(
			ShortLinkEntryModelImpl.ENTITY_CACHE_ENABLED,
			ShortLinkEntryModelImpl.FINDER_CACHE_ENABLED,
			ShortLinkEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByOURL",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByOURL = new FinderPath(
			ShortLinkEntryModelImpl.ENTITY_CACHE_ENABLED,
			ShortLinkEntryModelImpl.FINDER_CACHE_ENABLED,
			ShortLinkEntryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByOURL", new String[] {String.class.getName()},
			ShortLinkEntryModelImpl.ORIGINALURL_COLUMN_BITMASK);

		_finderPathCountByOURL = new FinderPath(
			ShortLinkEntryModelImpl.ENTITY_CACHE_ENABLED,
			ShortLinkEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOURL",
			new String[] {String.class.getName()});

		_finderPathFetchByShortURL = new FinderPath(
			ShortLinkEntryModelImpl.ENTITY_CACHE_ENABLED,
			ShortLinkEntryModelImpl.FINDER_CACHE_ENABLED,
			ShortLinkEntryImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByShortURL", new String[] {String.class.getName()},
			ShortLinkEntryModelImpl.SHORTURL_COLUMN_BITMASK);

		_finderPathCountByShortURL = new FinderPath(
			ShortLinkEntryModelImpl.ENTITY_CACHE_ENABLED,
			ShortLinkEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByShortURL",
			new String[] {String.class.getName()});

		_finderPathFetchBySURL = new FinderPath(
			ShortLinkEntryModelImpl.ENTITY_CACHE_ENABLED,
			ShortLinkEntryModelImpl.FINDER_CACHE_ENABLED,
			ShortLinkEntryImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchBySURL",
			new String[] {String.class.getName()},
			ShortLinkEntryModelImpl.SHORTURL_COLUMN_BITMASK);

		_finderPathCountBySURL = new FinderPath(
			ShortLinkEntryModelImpl.ENTITY_CACHE_ENABLED,
			ShortLinkEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySURL",
			new String[] {String.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(ShortLinkEntryImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_SHORTLINKENTRY =
		"SELECT shortLinkEntry FROM ShortLinkEntry shortLinkEntry";

	private static final String _SQL_SELECT_SHORTLINKENTRY_WHERE =
		"SELECT shortLinkEntry FROM ShortLinkEntry shortLinkEntry WHERE ";

	private static final String _SQL_COUNT_SHORTLINKENTRY =
		"SELECT COUNT(shortLinkEntry) FROM ShortLinkEntry shortLinkEntry";

	private static final String _SQL_COUNT_SHORTLINKENTRY_WHERE =
		"SELECT COUNT(shortLinkEntry) FROM ShortLinkEntry shortLinkEntry WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "shortLinkEntry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ShortLinkEntry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ShortLinkEntry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ShortLinkEntryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "active"});

}