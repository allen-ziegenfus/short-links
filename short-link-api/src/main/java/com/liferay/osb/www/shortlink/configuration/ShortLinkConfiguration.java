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

package com.liferay.osb.www.shortlink.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Allen Ziegenfus
 * @author Evandro Zeferino
 */
@ExtendedObjectClassDefinition(category = "osb-www-short-link")
@Meta.OCD(
	id = "com.liferay.osb.www.shortlink.configuration.ShortLinkConfiguration"
)
public interface ShortLinkConfiguration {

	@Meta.AD(deflt = "localhost", required = false)
	public String shortLinkHostname();

	@Meta.AD(deflt = "301,302", required = false)
	public int[] shortLinkRedirectHttpStatusCodes();

}