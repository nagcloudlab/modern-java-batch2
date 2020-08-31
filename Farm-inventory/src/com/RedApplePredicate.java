package com;

import com.model.Apple;
import com.model.Color;

public class RedApplePredicate implements ApplePredicate {

	@Override
	public boolean test(Apple apple) {
		return apple.getColor().equals(Color.RED);
	}

}
