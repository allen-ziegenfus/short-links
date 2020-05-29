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

package com.liferay.osb.www.shortlink.hook.filter;

import com.liferay.osb.www.shortlink.configuration.ShortLinkConfiguration;
import com.liferay.osb.www.shortlink.model.ShortLinkEntry;
import com.liferay.osb.www.shortlink.model.ShortLinkEntryConstants;
import com.liferay.osb.www.shortlink.service.ShortLinkEntryLocalService;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.BaseFilter;
import com.liferay.portal.kernel.servlet.HttpHeaders;

import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Miroslav Ligas
 */
@Component(
	configurationPid = "com.liferay.osb.www.shortlink.configuration.ShortLinkConfiguration",
	immediate = true,
	property = {
		"before-filter=Valid Host Name Filter", "servlet-context-name=",
		"servlet-filter-name=OSB WWW Rewrite Short Link Filter",
		"url-pattern=/*"
	},
	service = Filter.class
)
public class RewriteShortLinkFilter extends BaseFilter {

	@Override
	public boolean isFilterEnabled(
		HttpServletRequest httpServletRequest,
		HttpServletResponse httpServletResponse) {

		String serverName = httpServletRequest.getServerName();

		if (_configuration != null) {
			String shortUrlHostname = _configuration.shortLinkHostname();

			if (shortUrlHostname.equals(serverName)) {
				return true;
			}
		}

		return false;
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_configuration = ConfigurableUtil.createConfigurable(
			ShortLinkConfiguration.class, properties);
	}

	@Override
	protected Log getLog() {
		return _log;
	}

	@Override
	protected void processFilter(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, FilterChain filterChain)
		throws Exception {

		String servletPath = httpServletRequest.getServletPath();

		String shortURL = servletPath.substring(1);

		if (shortURL.length() >=
				ShortLinkEntryConstants.SHORT_URL_MINIMUM_SIZE) {

			ShortLinkEntry shortLinkEntry =
				shortLinkEntryLocalService.fetchShortLinkEntry(shortURL);

			if ((shortLinkEntry != null) && shortLinkEntry.isActive()) {
				httpServletResponse.setHeader(
					HttpHeaders.LOCATION, shortLinkEntry.getOriginalURL());
				httpServletResponse.setStatus(
					shortLinkEntry.getHttpStatusCode());

				return;
			}
		}

		processFilter(
			getClass().getName(), httpServletRequest, httpServletResponse,
			filterChain);
	}

	@Reference
	protected ShortLinkEntryLocalService shortLinkEntryLocalService;

	private static Log _log = LogFactoryUtil.getLog(
		RewriteShortLinkFilter.class);

	private volatile ShortLinkConfiguration _configuration;

}