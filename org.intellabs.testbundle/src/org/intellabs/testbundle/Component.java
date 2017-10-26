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

import upm_bmp280.BMP280;

public class Component {

	// code below is taken from the UPM Java sample code for BMP280, licensed
	// under the terms of the MIT license.
	// https://github.com/intel-iot-devkit/upm/blob/master/examples/java/BMP280_Example.java
	protected void activate() {

		// Instantiate a BMP280 instance using default i2c bus and address
		BMP280 sensor = new BMP280();

		// For SPI, bus 0, you would pass -1 as the address, and a
		// valid pin for CS:
		// BMP280(0, -1, 10);

		while (true) {
			// update our values from the sensor
			sensor.update();

			System.out.println("Compensation Temperature: " + sensor.getTemperature() + " C / "
					+ sensor.getTemperature(true) + " F");

			System.out.println("Pressure: " + sensor.getPressure() + " Pa");

			System.out.println("Computed Altitude: " + sensor.getAltitude() + " m");

			System.out.println();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
