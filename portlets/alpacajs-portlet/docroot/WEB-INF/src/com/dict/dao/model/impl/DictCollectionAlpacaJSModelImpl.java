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

package com.dict.dao.model.impl;

import com.dict.dao.model.DictCollectionAlpacaJS;
import com.dict.dao.model.DictCollectionAlpacaJSModel;
import com.dict.dao.model.DictCollectionAlpacaJSSoap;

import com.liferay.portal.LocaleException;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * The base model implementation for the DictCollectionAlpacaJS service. Represents a row in the &quot;opencps_dictcollection&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.dict.dao.model.DictCollectionAlpacaJSModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DictCollectionAlpacaJSImpl}.
 * </p>
 *
 * @author binhth
 * @see DictCollectionAlpacaJSImpl
 * @see com.dict.dao.model.DictCollectionAlpacaJS
 * @see com.dict.dao.model.DictCollectionAlpacaJSModel
 * @generated
 */
@JSON(strict = true)
public class DictCollectionAlpacaJSModelImpl extends BaseModelImpl<DictCollectionAlpacaJS>
	implements DictCollectionAlpacaJSModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a dict collection alpaca j s model instance should use the {@link com.dict.dao.model.DictCollectionAlpacaJS} interface instead.
	 */
	public static final String TABLE_NAME = "opencps_dictcollection";
	public static final Object[][] TABLE_COLUMNS = {
			{ "dictCollectionId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "collectionCode", Types.VARCHAR },
			{ "collectionName", Types.VARCHAR },
			{ "description", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table opencps_dictcollection (dictCollectionId LONG not null primary key,companyId LONG,groupId LONG,userId LONG,createDate DATE null,modifiedDate DATE null,collectionCode VARCHAR(75) null,collectionName STRING null,description VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table opencps_dictcollection";
	public static final String ORDER_BY_JPQL = " ORDER BY dictCollectionAlpacaJS.collectionName ASC";
	public static final String ORDER_BY_SQL = " ORDER BY opencps_dictcollection.collectionName ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.dict.dao.model.DictCollectionAlpacaJS"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.dict.dao.model.DictCollectionAlpacaJS"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.dict.dao.model.DictCollectionAlpacaJS"),
			true);
	public static long GROUPID_COLUMN_BITMASK = 1L;
	public static long COLLECTIONNAME_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static DictCollectionAlpacaJS toModel(
		DictCollectionAlpacaJSSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		DictCollectionAlpacaJS model = new DictCollectionAlpacaJSImpl();

		model.setDictCollectionId(soapModel.getDictCollectionId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setGroupId(soapModel.getGroupId());
		model.setUserId(soapModel.getUserId());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setCollectionCode(soapModel.getCollectionCode());
		model.setCollectionName(soapModel.getCollectionName());
		model.setDescription(soapModel.getDescription());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<DictCollectionAlpacaJS> toModels(
		DictCollectionAlpacaJSSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<DictCollectionAlpacaJS> models = new ArrayList<DictCollectionAlpacaJS>(soapModels.length);

		for (DictCollectionAlpacaJSSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.dict.dao.model.DictCollectionAlpacaJS"));

	public DictCollectionAlpacaJSModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _dictCollectionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDictCollectionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _dictCollectionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return DictCollectionAlpacaJS.class;
	}

	@Override
	public String getModelClassName() {
		return DictCollectionAlpacaJS.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dictCollectionId", getDictCollectionId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("collectionCode", getCollectionCode());
		attributes.put("collectionName", getCollectionName());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dictCollectionId = (Long)attributes.get("dictCollectionId");

		if (dictCollectionId != null) {
			setDictCollectionId(dictCollectionId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String collectionCode = (String)attributes.get("collectionCode");

		if (collectionCode != null) {
			setCollectionCode(collectionCode);
		}

		String collectionName = (String)attributes.get("collectionName");

		if (collectionName != null) {
			setCollectionName(collectionName);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	@JSON
	@Override
	public long getDictCollectionId() {
		return _dictCollectionId;
	}

	@Override
	public void setDictCollectionId(long dictCollectionId) {
		_dictCollectionId = dictCollectionId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
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

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getCollectionCode() {
		if (_collectionCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _collectionCode;
		}
	}

	@Override
	public void setCollectionCode(String collectionCode) {
		_collectionCode = collectionCode;
	}

	@JSON
	@Override
	public String getCollectionName() {
		if (_collectionName == null) {
			return StringPool.BLANK;
		}
		else {
			return _collectionName;
		}
	}

	@Override
	public String getCollectionName(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getCollectionName(languageId);
	}

	@Override
	public String getCollectionName(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getCollectionName(languageId, useDefault);
	}

	@Override
	public String getCollectionName(String languageId) {
		return LocalizationUtil.getLocalization(getCollectionName(), languageId);
	}

	@Override
	public String getCollectionName(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getCollectionName(),
			languageId, useDefault);
	}

	@Override
	public String getCollectionNameCurrentLanguageId() {
		return _collectionNameCurrentLanguageId;
	}

	@JSON
	@Override
	public String getCollectionNameCurrentValue() {
		Locale locale = getLocale(_collectionNameCurrentLanguageId);

		return getCollectionName(locale);
	}

	@Override
	public Map<Locale, String> getCollectionNameMap() {
		return LocalizationUtil.getLocalizationMap(getCollectionName());
	}

	@Override
	public void setCollectionName(String collectionName) {
		_columnBitmask = -1L;

		_collectionName = collectionName;
	}

	@Override
	public void setCollectionName(String collectionName, Locale locale) {
		setCollectionName(collectionName, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setCollectionName(String collectionName, Locale locale,
		Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(collectionName)) {
			setCollectionName(LocalizationUtil.updateLocalization(
					getCollectionName(), "CollectionName", collectionName,
					languageId, defaultLanguageId));
		}
		else {
			setCollectionName(LocalizationUtil.removeLocalization(
					getCollectionName(), "CollectionName", languageId));
		}
	}

	@Override
	public void setCollectionNameCurrentLanguageId(String languageId) {
		_collectionNameCurrentLanguageId = languageId;
	}

	@Override
	public void setCollectionNameMap(Map<Locale, String> collectionNameMap) {
		setCollectionNameMap(collectionNameMap, LocaleUtil.getDefault());
	}

	@Override
	public void setCollectionNameMap(Map<Locale, String> collectionNameMap,
		Locale defaultLocale) {
		if (collectionNameMap == null) {
			return;
		}

		setCollectionName(LocalizationUtil.updateLocalization(
				collectionNameMap, getCollectionName(), "CollectionName",
				LocaleUtil.toLanguageId(defaultLocale)));
	}

	@JSON
	@Override
	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		_description = description;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			DictCollectionAlpacaJS.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> collectionNameMap = getCollectionNameMap();

		for (Map.Entry<Locale, String> entry : collectionNameMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		return availableLanguageIds.toArray(new String[availableLanguageIds.size()]);
	}

	@Override
	public String getDefaultLanguageId() {
		String xml = getCollectionName();

		if (xml == null) {
			return StringPool.BLANK;
		}

		Locale defaultLocale = LocaleUtil.getDefault();

		return LocalizationUtil.getDefaultLanguageId(xml, defaultLocale);
	}

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException {
		prepareLocalizedFieldsForImport(null);
	}

	@Override
	@SuppressWarnings("unused")
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException {
		Locale defaultLocale = LocaleUtil.getDefault();

		String modelDefaultLanguageId = getDefaultLanguageId();

		String collectionName = getCollectionName(defaultLocale);

		if (Validator.isNull(collectionName)) {
			setCollectionName(getCollectionName(modelDefaultLanguageId),
				defaultLocale);
		}
		else {
			setCollectionName(getCollectionName(defaultLocale), defaultLocale,
				defaultLocale);
		}
	}

	@Override
	public DictCollectionAlpacaJS toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (DictCollectionAlpacaJS)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		DictCollectionAlpacaJSImpl dictCollectionAlpacaJSImpl = new DictCollectionAlpacaJSImpl();

		dictCollectionAlpacaJSImpl.setDictCollectionId(getDictCollectionId());
		dictCollectionAlpacaJSImpl.setCompanyId(getCompanyId());
		dictCollectionAlpacaJSImpl.setGroupId(getGroupId());
		dictCollectionAlpacaJSImpl.setUserId(getUserId());
		dictCollectionAlpacaJSImpl.setCreateDate(getCreateDate());
		dictCollectionAlpacaJSImpl.setModifiedDate(getModifiedDate());
		dictCollectionAlpacaJSImpl.setCollectionCode(getCollectionCode());
		dictCollectionAlpacaJSImpl.setCollectionName(getCollectionName());
		dictCollectionAlpacaJSImpl.setDescription(getDescription());

		dictCollectionAlpacaJSImpl.resetOriginalValues();

		return dictCollectionAlpacaJSImpl;
	}

	@Override
	public int compareTo(DictCollectionAlpacaJS dictCollectionAlpacaJS) {
		int value = 0;

		value = getCollectionName()
					.compareTo(dictCollectionAlpacaJS.getCollectionName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DictCollectionAlpacaJS)) {
			return false;
		}

		DictCollectionAlpacaJS dictCollectionAlpacaJS = (DictCollectionAlpacaJS)obj;

		long primaryKey = dictCollectionAlpacaJS.getPrimaryKey();

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
	public void resetOriginalValues() {
		DictCollectionAlpacaJSModelImpl dictCollectionAlpacaJSModelImpl = this;

		dictCollectionAlpacaJSModelImpl._originalGroupId = dictCollectionAlpacaJSModelImpl._groupId;

		dictCollectionAlpacaJSModelImpl._setOriginalGroupId = false;

		dictCollectionAlpacaJSModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<DictCollectionAlpacaJS> toCacheModel() {
		DictCollectionAlpacaJSCacheModel dictCollectionAlpacaJSCacheModel = new DictCollectionAlpacaJSCacheModel();

		dictCollectionAlpacaJSCacheModel.dictCollectionId = getDictCollectionId();

		dictCollectionAlpacaJSCacheModel.companyId = getCompanyId();

		dictCollectionAlpacaJSCacheModel.groupId = getGroupId();

		dictCollectionAlpacaJSCacheModel.userId = getUserId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			dictCollectionAlpacaJSCacheModel.createDate = createDate.getTime();
		}
		else {
			dictCollectionAlpacaJSCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			dictCollectionAlpacaJSCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			dictCollectionAlpacaJSCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		dictCollectionAlpacaJSCacheModel.collectionCode = getCollectionCode();

		String collectionCode = dictCollectionAlpacaJSCacheModel.collectionCode;

		if ((collectionCode != null) && (collectionCode.length() == 0)) {
			dictCollectionAlpacaJSCacheModel.collectionCode = null;
		}

		dictCollectionAlpacaJSCacheModel.collectionName = getCollectionName();

		String collectionName = dictCollectionAlpacaJSCacheModel.collectionName;

		if ((collectionName != null) && (collectionName.length() == 0)) {
			dictCollectionAlpacaJSCacheModel.collectionName = null;
		}

		dictCollectionAlpacaJSCacheModel.description = getDescription();

		String description = dictCollectionAlpacaJSCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			dictCollectionAlpacaJSCacheModel.description = null;
		}

		return dictCollectionAlpacaJSCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{dictCollectionId=");
		sb.append(getDictCollectionId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", collectionCode=");
		sb.append(getCollectionCode());
		sb.append(", collectionName=");
		sb.append(getCollectionName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.dict.dao.model.DictCollectionAlpacaJS");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>dictCollectionId</column-name><column-value><![CDATA[");
		sb.append(getDictCollectionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>collectionCode</column-name><column-value><![CDATA[");
		sb.append(getCollectionCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>collectionName</column-name><column-value><![CDATA[");
		sb.append(getCollectionName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = DictCollectionAlpacaJS.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			DictCollectionAlpacaJS.class
		};
	private long _dictCollectionId;
	private long _companyId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private String _collectionCode;
	private String _collectionName;
	private String _collectionNameCurrentLanguageId;
	private String _description;
	private long _columnBitmask;
	private DictCollectionAlpacaJS _escapedModel;
}