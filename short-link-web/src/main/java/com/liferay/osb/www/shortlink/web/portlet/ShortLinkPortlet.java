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

package com.liferay.osb.www.shortlink.web.portlet;

import com.liferay.osb.www.shortlink.configuration.ShortLinkConfiguration;
import com.liferay.osb.www.shortlink.exception.DuplicateShortLinkEntryException;
import com.liferay.osb.www.shortlink.exception.ShortLinkEntryOriginalURLException;
import com.liferay.osb.www.shortlink.exception.ShortLinkEntryShortURLException;
import com.liferay.osb.www.shortlink.model.ShortLinkEntry;
import com.liferay.osb.www.shortlink.service.ShortLinkEntryLocalService;
import com.liferay.osb.www.shortlink.web.constants.ShortLinkPortletKeys;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.dao.search.SearchPaginationUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;

import java.util.List;
import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Miroslav Ligas
 * @author Joan H. Kim
 */
@Component(
	configurationPid = "com.liferay.osb.www.shortlink.configuration.ShortLinkConfiguration",
	immediate = true,
	property = {
		"com.liferay.portlet.control-panel-entry-weight=9.0",
		"com.liferay.portlet.css-class-wrapper=short-link-portlet",
		"com.liferay.portlet.display-category=category.hidden",
		"com.liferay.portlet.instanceable=false",
		"com.liferay.portlet.preferences-company-wide=true",
		"com.liferay.portlet.preferences-unique-per-layout=false",
		"com.liferay.portlet.system=true",
		"javax.portlet.display-name=OSB Short Links",
		"javax.portlet.expiration-cache=0",
		"javax.portlet.info.keywords=Short Link",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ShortLinkPortletKeys.SHORT_LINK_WEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=administrator",
		"javax.portlet.supports.mime-type=text/html",
		"javax.portlet.version=3.0"
	},
	service = Portlet.class
)
public class ShortLinkPortlet extends MVCPortlet {

	@Override
	public void render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		int count = _shortLinkEntryLocalService.getShortLinkEntriesCount();

		int delta = ParamUtil.getInteger(
			renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, 10);

		int currentPage = ParamUtil.getInteger(
			renderRequest, SearchContainer.DEFAULT_CUR_PARAM,
			SearchContainer.DEFAULT_CUR);

		int[] startAndEnd = SearchPaginationUtil.calculateStartAndEnd(
			currentPage, delta);

		int start = startAndEnd[0];

		int end = startAndEnd[1];

		if (end > count) {
			end = count;
		}

		List<ShortLinkEntry> shortLinkEntries =
			_shortLinkEntryLocalService.getShortLinkEntries(start, end);

		renderRequest.setAttribute(
			ShortLinkConfiguration.class.getName(), _configuration);

		renderRequest.setAttribute(
			ShortLinkPortletKeys.SHORT_LINKS_LIST_ATTR, shortLinkEntries);

		renderRequest.setAttribute(
			ShortLinkPortletKeys.SHORT_LINK_LIST_PAGINATION_ATTR, delta);

		renderRequest.setAttribute(
			ShortLinkPortletKeys.SHORT_LINKS_COUNT, count);

		renderRequest.setAttribute(
			SearchContainer.DEFAULT_CUR_PARAM, currentPage);

		renderRequest.setAttribute(SearchContainer.DEFAULT_DELTA_PARAM, delta);

		super.render(renderRequest, renderResponse);
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_configuration = ConfigurableUtil.createConfigurable(
			ShortLinkConfiguration.class, properties);
	}

	@Override
	protected boolean isSessionErrorException(Throwable cause) {
		if (cause instanceof DuplicateShortLinkEntryException ||
			cause instanceof ShortLinkEntryOriginalURLException ||
			cause instanceof ShortLinkEntryShortURLException) {

			return true;
		}

		return super.isSessionErrorException(cause);
	}

	private volatile ShortLinkConfiguration _configuration;

	@Reference
	private ShortLinkEntryLocalService _shortLinkEntryLocalService;

}