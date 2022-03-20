package it.unibo.radarSystem22.domain;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.unibo.radarSystem22.domain.interfaces.ILed;
import it.unibo.radarSystem22.domain.mock.LedMock;
import it.unibo.radarSystem22.domain.models.LedModel;
import it.unibo.radarSystem22.domain.utils.BasicUtils;
import it.unibo.radarSystem22.domain.utils.DomainSystemConfig;

public class TestLed {
	
	@Before
	public void up() {
		System.out.println("up");
	}
	
	@After
	public void down() {
		System.out.println("down\n");
	}
	
	
	@Test
	public void testLedMock() {
		System.out.println("testLedMock");
		DomainSystemConfig.simulation = true;
		
		ILed led = LedModel.create();
		assertTrue(!led.getState());
		BasicUtils.delay(1000);
	}
	
	@Test
	public void testLedOn() {
		System.out.println("testLedOn");
		ILed led = new LedMock(); //Siccome non abbiamo ancora una DeviceFactory uso il costruttore new
		
		led.turnOn();
		assertTrue(led.getState());
	}

}
