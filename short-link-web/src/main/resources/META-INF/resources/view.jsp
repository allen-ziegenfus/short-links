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

<%@ include file="/init.jsp" %>

<div class="link-shortener-content">
	<portlet:actionURL name="updateShortLinkEntry" var="updateShortLinkEntryURL">
		<portlet:param name="redirect" value="<%= portletURL.toString() %>" />
	</portlet:actionURL>

	<aui:form action="<%= updateShortLinkEntryURL %>" method="post" name="fm">
		<liferay-ui:error exception="<%= CannotOverrideLayoutException.class %>" message="a-short-link-may-not-override-an-existing-site-page" />
		<liferay-ui:error exception="<%= DuplicateShortLinkEntryException.class %>" message="the-short-link-is-already-used" />
		<liferay-ui:error exception="<%= ShortLinkEntryOriginalURLException.class %>" message="the-original-url-is-required-and-cannot-be-longer-than-4000-characters" />
		<liferay-ui:error exception="<%= ShortLinkEntryShortURLException.class %>" message="the-short-url-is-required-and-must-be-between-4-and-100-characters-long" />

		<aui:fieldset>
			<aui:input label="short-url" name="shortURL" prefix="<%= shortUrlHostname + StringPool.FORWARD_SLASH %>" />

			<aui:input label="original-url" name="originalURL">
				<aui:validator name="maxLength">
					<%= ShortLinkEntryConstants.ORIGINAL_URL_MAXIMUM_SIZE %>
				</aui:validator>

				<aui:validator name="required" />
				<aui:validator name="url" />
			</aui:input>

			<label><liferay-ui:message key="http-status-code" /></label>

			<%
			for (int httpStatusCode : shortUrlRedirectHttpStatusCodes) {
			%>

				<aui:input checked="<%= httpStatusCode == HttpStatus.SC_MOVED_TEMPORARILY %>" id="httpStatusCode" label="<%= httpStatusCode + StringPool.SPACE + HttpStatus.getStatusText(httpStatusCode) %>" name="httpStatusCode" type="radio" value="<%= httpStatusCode %>" />

			<%
			}
			%>

		</aui:fieldset>

		<aui:button-row>
			<aui:button type="submit" value="add-url" />
		</aui:button-row>
	</aui:form>

	<liferay-portlet:renderURL varImpl="iteratorURL" />

	<liferay-ui:search-container
		delta="<%= (int)request.getAttribute(ShortLinkPortletKeys.SHORT_LINK_LIST_PAGINATION_ATTR) %>"
		deltaConfigurable="true"
		emptyResultsMessage="there-are-no-short-links-defined"
		iteratorURL="<%= iteratorURL %>"
		total="<%= (int)request.getAttribute(ShortLinkPortletKeys.SHORT_LINKS_COUNT) %>"
	>
		<liferay-ui:search-container-results
			results="${short_links_list}"
		/>

		<liferay-ui:search-container-row
			className="com.liferay.osb.www.shortlink.model.ShortLinkEntry"
			escapedModel="<%= true %>"
			keyProperty="shortLinkEntryId"
			modelVar="shortLinkEntry"
		>
			<portlet:renderURL var="editURL">
				<portlet:param name="mvcPath" value="/edit_short_link_entry.jsp" />
				<portlet:param name="shortLinkEntryId" value="<%= String.valueOf(shortLinkEntry.getShortLinkEntryId()) %>" />
				<portlet:param name="redirect" value="<%= portletURL.toString() %>" />
			</portlet:renderURL>

			<liferay-ui:search-container-column-text
				href="<%= editURL %>"
				name="id"
				property="shortLinkEntryId"
			/>

			<%
			Format dateFormatDateTime = FastDateFormatFactoryUtil.getDateTime(locale, timeZone);
			%>

			<liferay-ui:search-container-column-text
				name="create-date"
				value="<%= dateFormatDateTime.format(shortLinkEntry.getCreateDate()) %>"
			/>

			<liferay-ui:search-container-column-text
				name="modified-date"
				value="<%= dateFormatDateTime.format(shortLinkEntry.getModifiedDate()) %>"
			/>

			<liferay-ui:search-container-column-text
				href='<%= "//" + shortUrlHostname + "/" + shortLinkEntry.getShortURL() %>'
				name="short-url"
				property="shortURL"
				target="_blank"
			/>

			<liferay-ui:search-container-column-text
				href="<%= shortLinkEntry.getOriginalURL() %>"
				name="original-url"
				property="originalURL"
				target="_blank"
			/>

			<liferay-ui:search-container-column-text
				name="http-status-code"
				property="httpStatusCode"
			/>

			<liferay-ui:search-container-column-text
				name="active"
			>
				<c:choose>
					<c:when test="<%= shortLinkEntry.isActive() %>">
						<liferay-ui:icon image="activate" />
					</c:when>
					<c:otherwise>
						<liferay-ui:icon image="deactivate" />
					</c:otherwise>
				</c:choose>
			</liferay-ui:search-container-column-text>

			<liferay-ui:search-container-column-text
				name="actions"
			>
				<liferay-ui:icon-menu>
					<liferay-ui:icon image="edit" url="<%= editURL %>" />

					<portlet:actionURL name="deleteShortLinkEntry" var="deleteShortLinkEntryURL">
						<portlet:param name="shortLinkEntryId" value="<%= String.valueOf(shortLinkEntry.getShortLinkEntryId()) %>" />
						<portlet:param name="redirect" value="<%= portletURL.toString() %>" />
					</portlet:actionURL>

					<liferay-ui:icon-delete url="<%= deleteShortLinkEntryURL %>" />
				</liferay-ui:icon-menu>
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</div>