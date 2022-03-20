package it.unibo.radarSystem22.domain;

import it.unibo.radarSystem22.domain.interfaces.IDistance;

public class Distance implements IDistance {
	
	private int value;
	
	public Distance(int value) {
		this.value = value;
	}
	
	@Override
	public int getVal() {
		return value;
	}
	
	@Override
	public String toString() {
		return ""+value;
	}

}
