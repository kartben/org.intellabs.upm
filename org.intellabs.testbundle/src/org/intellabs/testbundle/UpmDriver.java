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

import org.eclipse.kura.channel.ChannelFlag;
import org.eclipse.kura.channel.ChannelRecord;
import org.eclipse.kura.channel.ChannelStatus;
import org.eclipse.kura.channel.listener.ChannelListener;
import org.eclipse.kura.configuration.ConfigurableComponent;
import org.eclipse.kura.configuration.metatype.Option;
import org.eclipse.kura.core.configuration.metatype.Tad;
import org.eclipse.kura.core.configuration.metatype.Toption;
import org.eclipse.kura.core.configuration.metatype.Tscalar;
import org.eclipse.kura.driver.ChannelDescriptor;
import org.eclipse.kura.driver.Driver;
import org.eclipse.kura.driver.PreparedRead;
import org.eclipse.kura.type.TypedValues;
import org.eclipse.kura.util.collection.CollectionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import upm_th02.TH02;

public class UpmDriver implements Driver, ConfigurableComponent {

    private static final Logger logger = LoggerFactory.getLogger(UpmDriver.class);

    private static final String SENSOR_NAME = "sensor.name";

    // private BMP280 _bmp280;
    private TH02 _th02;

    protected synchronized void activate(final Map<String, Object> properties) {
        System.out.println("activating upm driver");
        // _bmp280 = new BMP280();
        _th02 = new TH02();
    }

    protected synchronized void deactivate() {
        System.out.println("deactivating upm driver");
    }

    public synchronized void updated(final Map<String, Object> properties) {
        System.out.println("updating upm driver");
    }

    @Override
    public void connect() throws ConnectionException {
    }

    @Override
    public void disconnect() throws ConnectionException {
    }

    @Override
    public ChannelDescriptor getChannelDescriptor() {
        return new ChannelDescriptor() {

            @Override
            public Object getDescriptor() {
                final List<Tad> elements = CollectionUtil.newArrayList();

                final Tad sensorName = new Tad();
                sensorName.setName(SENSOR_NAME);
                sensorName.setId(SENSOR_NAME);
                sensorName.setDescription(SENSOR_NAME);
                sensorName.setType(Tscalar.STRING);
                sensorName.setRequired(true);
                sensorName.setDefault("temperature");

                // TODO we can prob generate the options from the UPM json files(?)

                final List<Option> options = sensorName.getOption();

                Toption option = new Toption();
                option.setLabel("temperature");
                option.setValue("temperature");
                options.add(option);

                option = new Toption();
                option.setLabel("humidity");
                option.setValue("humidity");
                options.add(option);

                elements.add(sensorName);

                return elements;
            }
        };
    }

    @Override
    public void read(List<ChannelRecord> records) throws ConnectionException {
        for (final ChannelRecord record : records) {
            // _th02.update();
            String sensorName = (String) record.getChannelConfig().get(SENSOR_NAME);
            if ("temperature".equals(sensorName)) {
                record.setValue(TypedValues.newFloatValue(_th02.getTemperature()));
            } else if ("humidity".equals(sensorName)) {
                record.setValue(TypedValues.newFloatValue(_th02.getHumidity()));

            }
            record.setChannelStatus(new ChannelStatus(ChannelFlag.SUCCESS));
            record.setTimestamp(System.currentTimeMillis());
        }

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
