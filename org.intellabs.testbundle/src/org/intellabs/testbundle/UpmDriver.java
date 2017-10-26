/**
 * Copyright (c) 2017 Eclipse Foundation and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Benjamin Cabé <benjamin.cabe@eclipse-foundation.org> - initial creation
 */
package org.intellabs.testbundle;

import java.util.List;
import java.util.Map;

import org.eclipse.kura.channel.ChannelRecord;
import org.eclipse.kura.channel.listener.ChannelListener;
import org.eclipse.kura.configuration.ConfigurableComponent;
import org.eclipse.kura.driver.ChannelDescriptor;
import org.eclipse.kura.driver.Driver;
import org.eclipse.kura.driver.PreparedRead;

public class UpmDriver implements Driver, ConfigurableComponent {

	@Override
	public void connect() throws ConnectionException {
		
	}

	@Override
	public void disconnect() throws ConnectionException {
		
	}

	@Override
	public ChannelDescriptor getChannelDescriptor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void read(List<ChannelRecord> records) throws ConnectionException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerChannelListener(Map<String, Object> channelConfig, ChannelListener listener)
			throws ConnectionException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unregisterChannelListener(ChannelListener listener) throws ConnectionException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write(List<ChannelRecord> records) throws ConnectionException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PreparedRead prepareRead(List<ChannelRecord> records) {
		// TODO Auto-generated method stub
		return null;
	}

}
