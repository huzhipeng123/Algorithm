package strategy.impl;

import strategy.Strategy;

public class DefaultStrategy implements Strategy {

	@Override
	public boolean equal(Object obj1, Object obj2) {
		return false;
	}

	@Override
	public int compare(Object obj1, Object obj2) {
		return 0;
	}

}
