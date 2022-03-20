package it.unibo.radarSystem22.domain.models;

import it.unibo.radarSystem22.domain.Distance;
import it.unibo.radarSystem22.domain.interfaces.IDistance;
import it.unibo.radarSystem22.domain.interfaces.ISonar;
import it.unibo.radarSystem22.domain.mock.SonarMock;
import it.unibo.radarSystem22.domain.utils.DomainSystemConfig;

public abstract class SonarModel implements ISonar {
	
	protected boolean stopped = false; //il sonar si ferma quando la variabile "stopped" diventa true
	protected IDistance curVal;
	
	//Factory methods
	public static ISonar create() {
		if ( DomainSystemConfig.simulation ) return createSonarMock();
		else return createSonarConcrete();
	}
	
	public static ISonar createSonarMock(){return new SonarMock();}
	public static ISonar createSonarConcrete(){return new SonarConcrete();}
	
	protected SonarModel() { //hidden costructor, to force setup
	    sonarSetUp();
	}
	
	protected void updateDistance(int dist) {
		curVal = new Distance(dist);
	}
	
	//Abstract methods
	protected abstract void sonarSetUp() ;
	protected abstract void sonarProduce( );
	
	//Activate attiva un thread interno per la produzione dei dati
	@Override
	public void activate() {
		stopped = false;
		new Thread() {
			public void run() {
				while(!stopped) {
					sonarProduce();
				}
			}
		}.start(); 
	}

	@Override
	public void deactivate() {
		stopped = true;
	}

	//Il metodo getDistance() è invocato dal consumatore dei dati prodotti
	@Override
	public IDistance getDistance() {
		return curVal;
	}

	@Override
	public boolean isActive() {
		return !stopped;
	}

}
