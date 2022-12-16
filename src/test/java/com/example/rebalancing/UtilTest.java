package com.example.rebalancing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.stream.Stream;

public class UtilTest {

	@ParameterizedTest
	@MethodSource("generateChangeArgument")
	void changeTest(Float start, Float end, Float expect) {
		Assertions.assertThat(Util.getChange(start, end)).isEqualTo(expect);
	}

	private static Stream<Arguments> generateChangeArgument() {
		return Stream.of(
				Arguments.of(100f, 120f, 0.2f),
				Arguments.of(100f, 121f, 0.21f),
				Arguments.of(100f, 80f, -0.2f),
				Arguments.of(100f, 79f, -0.21f),
				Arguments.of(149.2f, 152.09f, 0.0194f)
				);
	}

	@Test
	void myTest() {
		float a = 0.099999964f;
		System.out.println(Math.round(a * 10) / 10.0);
	}
}
