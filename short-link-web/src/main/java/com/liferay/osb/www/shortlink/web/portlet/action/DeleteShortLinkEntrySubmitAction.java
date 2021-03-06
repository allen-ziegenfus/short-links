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

package com.liferay.osb.www.shortlink.web.portlet.action;

import com.liferay.osb.www.shortlink.service.ShortLinkEntryLocalServiceUtil;
import com.liferay.osb.www.shortlink.web.constants.ShortLinkPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Evandro Zeferino
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + ShortLinkPortletKeys.SHORT_LINK_WEB,
		"mvc.command.name=deleteShortLinkEntry"
	},
	service = MVCActionCommand.class
)
public class DeleteShortLinkEntrySubmitAction extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		long shortLinkEntryId = ParamUtil.getLong(
			actionRequest, "shortLinkEntryId");

		ShortLinkEntryLocalServiceUtil.deleteShortLinkEntry(shortLinkEntryId);
	}

}