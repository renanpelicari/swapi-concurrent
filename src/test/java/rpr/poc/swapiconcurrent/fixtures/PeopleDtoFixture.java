package rpr.poc.swapiconcurrent.fixtures;

import rpr.poc.swapiconcurrent.dto.PeopleDto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Helper class to generate fake {@link PeopleDto} data.
 */
public class PeopleDtoFixture {

    public static List<PeopleDto> getPeopleDtoList(final int size) {
        return getPeopleDtoList(size, 0);
    }

    public static List<PeopleDto> getPeopleDtoList(final int size, final int startsWith) {
        return IntStream.range(startsWith, size).mapToObj(PeopleDtoFixture::getPeopleDto).collect(Collectors.toList());
    }

    public static List<PeopleDto> getPeopleDtoInvalidList() {
        return Arrays.asList(PeopleDtoFixture.getPeopleDto(1), null);
    }

    private static PeopleDto getPeopleDto(final int index) {
        final PeopleDto peopleDto = new PeopleDto();
        peopleDto.setName("Mocked Name " + index);
        peopleDto.setHeight(170 + index);
        peopleDto.setMass(70 + index);
        return peopleDto;
    }
}
