package it.unibo.radarSystem22.domain.concrete;

import it.unibo.radarSystem22.domain.interfaces.ILed;

public class LedConcrete implements ILed {
	//Non implemento questa classe poichè il codice del domain non girerà sul raspberry dove ho il led fisico
	@Override
	public void turnOn() {
		// TODO Auto-generated method stub

	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean getState() {
		// TODO Auto-generated method stub
		return false;
	}

}
