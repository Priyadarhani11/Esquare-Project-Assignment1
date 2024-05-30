/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.custom.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchMyEntityException extends NoSuchModelException {

	public NoSuchMyEntityException() {
	}

	public NoSuchMyEntityException(String msg) {
		super(msg);
	}

	public NoSuchMyEntityException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchMyEntityException(Throwable throwable) {
		super(throwable);
	}

}