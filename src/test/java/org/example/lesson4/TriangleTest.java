package org.example.lesson4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Треугольник")
public class TriangleTest {

    public static Stream<Arguments> triangles() {
        return Stream.of(
                Arguments.of(new Triangle(3, 4, 5), 6),
                Arguments.of(new Triangle(3, 4, 6), 5.33),
                Arguments.of(new Triangle(5, 5, 5), 10.83)
                );
    }

    @ParameterizedTest(name = "Площадь треугольника {0} равен {1}")
    @MethodSource("triangles")
    public void countTriangleSquareTest(Triangle triangle, double expectedSquare) {
        double square = triangle.countSquare();
        assertEquals(expectedSquare, square);
    }
}
