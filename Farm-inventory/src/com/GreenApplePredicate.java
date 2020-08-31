package com;

import com.model.Apple;
import com.model.Color;

// behavior implementation
public class GreenApplePredicate implements ApplePredicate{
	@Override
	public boolean test(Apple apple) {
		return apple.getColor().equals(Color.GREEN);
	}

}
