package rpr.poc.swapiconcurrent.fixtures;

import rpr.poc.swapiconcurrent.vo.PeopleVo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Helper class to generate fake {@link PeopleVo} data.
 */
public class PeopleVoFixture {

    public static List<PeopleVo> getPeopleVoList(final int size) {
        return IntStream.range(0, size).mapToObj(PeopleVoFixture::getPeopleVo).collect(Collectors.toList());
    }

    public static String getPeopleJsonList(final int size) {
        return IntStream.range(0, size).mapToObj(PeopleVoFixture::getPeopleJson)
            .collect(Collectors.joining(",", "[", "]"));
    }

    private static PeopleVo getPeopleVo(final int index) {
        return new PeopleVo.Builder()
            .withName("Mocked Name " + index)
            .withHeight(170 + index)
            .withMass(70 + index)
            .build();
    }

    private static String getPeopleJson(final int index) {
        return "{\"name\": \"Mocked Name " + index + "\", " +
            "\"height\": " + (170 + index) + ", " +
            "\"mass\": " + (70 + index) + "}";

    }
}
