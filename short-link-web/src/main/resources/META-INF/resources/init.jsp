<%--
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
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.osb.www.shortlink.configuration.ShortLinkConfiguration" %><%@
page import="com.liferay.osb.www.shortlink.exception.CannotOverrideLayoutException" %><%@
page import="com.liferay.osb.www.shortlink.exception.DuplicateShortLinkEntryException" %><%@
page import="com.liferay.osb.www.shortlink.exception.ShortLinkEntryOriginalURLException" %><%@
page import="com.liferay.osb.www.shortlink.exception.ShortLinkEntryShortURLException" %><%@
page import="com.liferay.osb.www.shortlink.model.ShortLinkEntry" %><%@
page import="com.liferay.osb.www.shortlink.model.ShortLinkEntryConstants" %><%@
page import="com.liferay.osb.www.shortlink.service.ShortLinkEntryLocalServiceUtil" %><%@
page import="com.liferay.osb.www.shortlink.web.constants.ShortLinkPortletKeys" %><%@
page import="com.liferay.petra.string.StringPool" %><%@
page import="com.liferay.portal.kernel.util.FastDateFormatFactoryUtil" %><%@
page import="com.liferay.portal.kernel.util.GetterUtil" %><%@
page import="com.liferay.portal.kernel.util.ParamUtil" %>

<%@ page import="java.text.Format" %>

<%@ page import="javax.portlet.PortletURL" %>

<%@ page import="org.apache.commons.httpclient.HttpStatus" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
	PortletURL portletURL = renderResponse.createRenderURL();

	Object configurationAttribute = renderRequest.getAttribute(ShortLinkConfiguration.class.getName());
	String shortUrlHostname = StringPool.BLANK;
	int[] shortUrlRedirectHttpStatusCodes = {};

	if (configurationAttribute != null) {
		ShortLinkConfiguration configuration = (ShortLinkConfiguration)GetterUtil.getObject(configurationAttribute);

		shortUrlHostname = configuration.shortLinkHostname();
		shortUrlRedirectHttpStatusCodes = configuration.shortLinkRedirectHttpStatusCodes();
	}
%>