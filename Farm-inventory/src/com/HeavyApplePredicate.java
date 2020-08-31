package com;

import com.model.Apple;

public class HeavyApplePredicate implements ApplePredicate {

	@Override
	public boolean test(Apple apple) {
		return apple.getWeight() > 150;
	}

}
