package com;

import com.model.Apple;

// behavior abstraction
@FunctionalInterface
public interface ApplePredicate {
	 boolean test(Apple apple);
}
