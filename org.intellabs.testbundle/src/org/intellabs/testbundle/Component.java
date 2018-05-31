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

import upm_th02.TH02;

public class Component {

    private Thread t;
    private boolean running = true;

    // code below is taken from the UPM Java sample code for TH02, licensed
    // under the terms of the MIT license.
    // https://github.com/intel-iot-devkit/upm/blob/master/examples/java/TH02_Example.java
    protected void activate() {
        TH02 sensor = new TH02();

        Runnable task = () -> {

            float temperature = 0;
            float humidity = 0;

            System.out.println("START");

            while (running) {
                temperature = sensor.getTemperature();
                humidity = sensor.getHumidity();

                System.out.println("Temperature = " + temperature + ", Humidity = " + humidity);

                System.out.println();
                try {
                    Thread.sleep(30000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            System.out.println("STOP");
        };

        t = new Thread(task);
        t.start();

    }

    protected void deactivate() {
        running = false;
        System.out.println("Deactivating component");

    }

}
