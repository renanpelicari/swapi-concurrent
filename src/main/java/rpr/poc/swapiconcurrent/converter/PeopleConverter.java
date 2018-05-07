package rpr.poc.swapiconcurrent.converter;

import org.springframework.util.Assert;
import rpr.poc.swapiconcurrent.dto.PeopleDto;
import rpr.poc.swapiconcurrent.vo.PeopleVo;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Helper class to convert {@link PeopleDto} to {@link PeopleVo}.
 */
public class PeopleConverter {

    private PeopleConverter() {
    }

    /**
     * Convert list of entity {@link PeopleDto} into {@link PeopleVo}.
     *
     * @param peopleDtos the list of PeopleDto
     * @return the {@link PeopleVo} list.
     */
    public static List<PeopleVo> peopleDtoToVo(final List<PeopleDto> peopleDtos) {
        return peopleDtos.stream().map(PeopleConverter::peopleDtoToVo).collect(Collectors.toList());
    }

    private static PeopleVo peopleDtoToVo(final PeopleDto peopleDto) {
        Assert.notNull(peopleDto, "PeopleDto should not be null!");
        return new PeopleVo.Builder()
            .withName(peopleDto.getName())
            .withHeight(peopleDto.getHeight())
            .withMass(peopleDto.getMass())
            .build();
    }
}
