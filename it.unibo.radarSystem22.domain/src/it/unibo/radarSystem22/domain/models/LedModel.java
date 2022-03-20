package it.unibo.radarSystem22.domain.models;

import it.unibo.radarSystem22.domain.concrete.LedConcrete;
import it.unibo.radarSystem22.domain.interfaces.ILed;
import it.unibo.radarSystem22.domain.mock.LedMock;
import it.unibo.radarSystem22.domain.utils.DomainSystemConfig;

public abstract class LedModel implements ILed {
	public boolean state = false; //Viene portata a true quando il led � acceso
	
	
	//Factory methods il cui comportamento dipende dal valore del campo "simulation" del file di configurazione
	public static ILed create() {
		if ( DomainSystemConfig.simulation ) return createLedMock();
		else return createLedConcrete();
	}
	
	public static ILed createLedMock(){return new LedMock();  }
	public static ILed createLedConcrete(){return new LedConcrete();}
	
	//Abstract methods
	protected abstract void ledActivate( boolean val );
	
	protected void setState( boolean val ) {
		state = val;
		ledActivate( state );
	}
	
	@Override
	public void turnOn() {
		setState( true );
	}

	@Override
	public void turnOff() {
		setState( false );
	}

	@Override
	public boolean getState() {
		return state;
	}

}
