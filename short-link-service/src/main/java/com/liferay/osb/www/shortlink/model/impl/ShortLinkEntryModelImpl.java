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

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.osb.www.shortlink.model.ShortLinkEntry;
import com.liferay.osb.www.shortlink.model.ShortLinkEntryModel;
import com.liferay.osb.www.shortlink.model.ShortLinkEntrySoap;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the ShortLinkEntry service. Represents a row in the &quot;ShortLink_ShortLinkEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>ShortLinkEntryModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ShortLinkEntryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShortLinkEntryImpl
 * @generated
 */
@JSON(strict = true)
public class ShortLinkEntryModelImpl
	extends BaseModelImpl<ShortLinkEntry> implements ShortLinkEntryModel {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a short link entry model instance should use the <code>ShortLinkEntry</code> interface instead.
	 */
	public static final String TABLE_NAME = "ShortLink_ShortLinkEntry";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"shortLinkEntryId", Types.BIGINT},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"originalURL", Types.VARCHAR}, {"shortURL", Types.VARCHAR},
		{"httpStatusCode", Types.INTEGER}, {"active_", Types.BOOLEAN}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("shortLinkEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("originalURL", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("shortURL", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("httpStatusCode", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("active_", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE =
		"create table ShortLink_ShortLinkEntry (uuid_ VARCHAR(75) null,shortLinkEntryId LONG not null primary key,createDate DATE null,modifiedDate DATE null,originalURL STRING null,shortURL VARCHAR(100) null,httpStatusCode INTEGER,active_ BOOLEAN)";

	public static final String TABLE_SQL_DROP =
		"drop table ShortLink_ShortLinkEntry";

	public static final String ORDER_BY_JPQL =
		" ORDER BY shortLinkEntry.shortLinkEntryId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY ShortLink_ShortLinkEntry.shortLinkEntryId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.osb.www.shortlink.service.util.ServiceProps.get(
			"value.object.entity.cache.enabled.com.liferay.osb.www.shortlink.model.ShortLinkEntry"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.osb.www.shortlink.service.util.ServiceProps.get(
			"value.object.finder.cache.enabled.com.liferay.osb.www.shortlink.model.ShortLinkEntry"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		com.liferay.osb.www.shortlink.service.util.ServiceProps.get(
			"value.object.column.bitmask.enabled.com.liferay.osb.www.shortlink.model.ShortLinkEntry"),
		true);

	public static final long ORIGINALURL_COLUMN_BITMASK = 1L;

	public static final long SHORTURL_COLUMN_BITMASK = 2L;

	public static final long UUID_COLUMN_BITMASK = 4L;

	public static final long SHORTLINKENTRYID_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static ShortLinkEntry toModel(ShortLinkEntrySoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		ShortLinkEntry model = new ShortLinkEntryImpl();

		model.setUuid(soapModel.getUuid());
		model.setShortLinkEntryId(soapModel.getShortLinkEntryId());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setOriginalURL(soapModel.getOriginalURL());
		model.setShortURL(soapModel.getShortURL());
		model.setHttpStatusCode(soapModel.getHttpStatusCode());
		model.setActive(soapModel.isActive());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<ShortLinkEntry> toModels(
		ShortLinkEntrySoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<ShortLinkEntry> models = new ArrayList<ShortLinkEntry>(
			soapModels.length);

		for (ShortLinkEntrySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.osb.www.shortlink.service.util.ServiceProps.get(
			"lock.expiration.time.com.liferay.osb.www.shortlink.model.ShortLinkEntry"));

	public ShortLinkEntryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _shortLinkEntryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setShortLinkEntryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _shortLinkEntryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ShortLinkEntry.class;
	}

	@Override
	public String getModelClassName() {
		return ShortLinkEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<ShortLinkEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<ShortLinkEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ShortLinkEntry, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((ShortLinkEntry)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<ShortLinkEntry, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<ShortLinkEntry, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(ShortLinkEntry)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<ShortLinkEntry, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<ShortLinkEntry, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, ShortLinkEntry>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			ShortLinkEntry.class.getClassLoader(), ShortLinkEntry.class,
			ModelWrapper.class);

		try {
			Constructor<ShortLinkEntry> constructor =
				(Constructor<ShortLinkEntry>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException roe) {
					throw new InternalError(roe);
				}
			};
		}
		catch (NoSuchMethodException nsme) {
			throw new InternalError(nsme);
		}
	}

	private static final Map<String, Function<ShortLinkEntry, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<ShortLinkEntry, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<ShortLinkEntry, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<ShortLinkEntry, Object>>();
		Map<String, BiConsumer<ShortLinkEntry, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<ShortLinkEntry, ?>>();

		attributeGetterFunctions.put("uuid", ShortLinkEntry::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<ShortLinkEntry, String>)ShortLinkEntry::setUuid);
		attributeGetterFunctions.put(
			"shortLinkEntryId", ShortLinkEntry::getShortLinkEntryId);
		attributeSetterBiConsumers.put(
			"shortLinkEntryId",
			(BiConsumer<ShortLinkEntry, Long>)
				ShortLinkEntry::setShortLinkEntryId);
		attributeGetterFunctions.put(
			"createDate", ShortLinkEntry::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<ShortLinkEntry, Date>)ShortLinkEntry::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", ShortLinkEntry::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<ShortLinkEntry, Date>)ShortLinkEntry::setModifiedDate);
		attributeGetterFunctions.put(
			"originalURL", ShortLinkEntry::getOriginalURL);
		attributeSetterBiConsumers.put(
			"originalURL",
			(BiConsumer<ShortLinkEntry, String>)ShortLinkEntry::setOriginalURL);
		attributeGetterFunctions.put("shortURL", ShortLinkEntry::getShortURL);
		attributeSetterBiConsumers.put(
			"shortURL",
			(BiConsumer<ShortLinkEntry, String>)ShortLinkEntry::setShortURL);
		attributeGetterFunctions.put(
			"httpStatusCode", ShortLinkEntry::getHttpStatusCode);
		attributeSetterBiConsumers.put(
			"httpStatusCode",
			(BiConsumer<ShortLinkEntry, Integer>)
				ShortLinkEntry::setHttpStatusCode);
		attributeGetterFunctions.put("active", ShortLinkEntry::getActive);
		attributeSetterBiConsumers.put(
			"active",
			(BiConsumer<ShortLinkEntry, Boolean>)ShortLinkEntry::setActive);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		_columnBitmask |= UUID_COLUMN_BITMASK;

		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getShortLinkEntryId() {
		return _shortLinkEntryId;
	}

	@Override
	public void setShortLinkEntryId(long shortLinkEntryId) {
		_shortLinkEntryId = shortLinkEntryId;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getOriginalURL() {
		if (_originalURL == null) {
			return "";
		}
		else {
			return _originalURL;
		}
	}

	@Override
	public void setOriginalURL(String originalURL) {
		_columnBitmask |= ORIGINALURL_COLUMN_BITMASK;

		if (_originalOriginalURL == null) {
			_originalOriginalURL = _originalURL;
		}

		_originalURL = originalURL;
	}

	public String getOriginalOriginalURL() {
		return GetterUtil.getString(_originalOriginalURL);
	}

	@JSON
	@Override
	public String getShortURL() {
		if (_shortURL == null) {
			return "";
		}
		else {
			return _shortURL;
		}
	}

	@Override
	public void setShortURL(String shortURL) {
		_columnBitmask |= SHORTURL_COLUMN_BITMASK;

		if (_originalShortURL == null) {
			_originalShortURL = _shortURL;
		}

		_shortURL = shortURL;
	}

	public String getOriginalShortURL() {
		return GetterUtil.getString(_originalShortURL);
	}

	@JSON
	@Override
	public int getHttpStatusCode() {
		return _httpStatusCode;
	}

	@Override
	public void setHttpStatusCode(int httpStatusCode) {
		_httpStatusCode = httpStatusCode;
	}

	@JSON
	@Override
	public boolean getActive() {
		return _active;
	}

	@JSON
	@Override
	public boolean isActive() {
		return _active;
	}

	@Override
	public void setActive(boolean active) {
		_active = active;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, ShortLinkEntry.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ShortLinkEntry toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, ShortLinkEntry>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ShortLinkEntryImpl shortLinkEntryImpl = new ShortLinkEntryImpl();

		shortLinkEntryImpl.setUuid(getUuid());
		shortLinkEntryImpl.setShortLinkEntryId(getShortLinkEntryId());
		shortLinkEntryImpl.setCreateDate(getCreateDate());
		shortLinkEntryImpl.setModifiedDate(getModifiedDate());
		shortLinkEntryImpl.setOriginalURL(getOriginalURL());
		shortLinkEntryImpl.setShortURL(getShortURL());
		shortLinkEntryImpl.setHttpStatusCode(getHttpStatusCode());
		shortLinkEntryImpl.setActive(isActive());

		shortLinkEntryImpl.resetOriginalValues();

		return shortLinkEntryImpl;
	}

	@Override
	public int compareTo(ShortLinkEntry shortLinkEntry) {
		long primaryKey = shortLinkEntry.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ShortLinkEntry)) {
			return false;
		}

		ShortLinkEntry shortLinkEntry = (ShortLinkEntry)obj;

		long primaryKey = shortLinkEntry.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		ShortLinkEntryModelImpl shortLinkEntryModelImpl = this;

		shortLinkEntryModelImpl._originalUuid = shortLinkEntryModelImpl._uuid;

		shortLinkEntryModelImpl._setModifiedDate = false;

		shortLinkEntryModelImpl._originalOriginalURL =
			shortLinkEntryModelImpl._originalURL;

		shortLinkEntryModelImpl._originalShortURL =
			shortLinkEntryModelImpl._shortURL;

		shortLinkEntryModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ShortLinkEntry> toCacheModel() {
		ShortLinkEntryCacheModel shortLinkEntryCacheModel =
			new ShortLinkEntryCacheModel();

		shortLinkEntryCacheModel.uuid = getUuid();

		String uuid = shortLinkEntryCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			shortLinkEntryCacheModel.uuid = null;
		}

		shortLinkEntryCacheModel.shortLinkEntryId = getShortLinkEntryId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			shortLinkEntryCacheModel.createDate = createDate.getTime();
		}
		else {
			shortLinkEntryCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			shortLinkEntryCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			shortLinkEntryCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		shortLinkEntryCacheModel.originalURL = getOriginalURL();

		String originalURL = shortLinkEntryCacheModel.originalURL;

		if ((originalURL != null) && (originalURL.length() == 0)) {
			shortLinkEntryCacheModel.originalURL = null;
		}

		shortLinkEntryCacheModel.shortURL = getShortURL();

		String shortURL = shortLinkEntryCacheModel.shortURL;

		if ((shortURL != null) && (shortURL.length() == 0)) {
			shortLinkEntryCacheModel.shortURL = null;
		}

		shortLinkEntryCacheModel.httpStatusCode = getHttpStatusCode();

		shortLinkEntryCacheModel.active = isActive();

		return shortLinkEntryCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<ShortLinkEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<ShortLinkEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ShortLinkEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((ShortLinkEntry)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<ShortLinkEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<ShortLinkEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ShortLinkEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((ShortLinkEntry)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, ShortLinkEntry>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private String _originalUuid;
	private long _shortLinkEntryId;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _originalURL;
	private String _originalOriginalURL;
	private String _shortURL;
	private String _originalShortURL;
	private int _httpStatusCode;
	private boolean _active;
	private long _columnBitmask;
	private ShortLinkEntry _escapedModel;

}