package rpr.poc.swapiconcurrent.converter;

import org.junit.Test;
import rpr.poc.swapiconcurrent.dto.PeopleDto;
import rpr.poc.swapiconcurrent.fixtures.PeopleDtoFixture;
import rpr.poc.swapiconcurrent.vo.PeopleVo;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Test unit for {@link PeopleConverter}
 */
public class PeopleConverterTest {

    @Test(expected = IllegalArgumentException.class)
    public void testPeopleDtoVoExpectedException() throws Exception {
        final List<PeopleDto> peopleDtos = PeopleDtoFixture.getPeopleDtoInvalidList();
        try {
            PeopleConverter.peopleDtoToVo(peopleDtos);
        } catch (final IllegalArgumentException ex) {
            assertEquals("PeopleDto should not be null!", ex.getMessage());
            throw ex;
        }
        fail("Should throw an IllegalArgumentException.");
    }

    @Test
    public void testPeopleDtoToVoSuccess() throws Exception {
        final List<PeopleDto> peopleDtos = PeopleDtoFixture.getPeopleDtoList(3);
        final List<PeopleVo> peopleVos = PeopleConverter.peopleDtoToVo(peopleDtos);
        assertThat(peopleVos).hasSize(3).extracting(PeopleVo::getHeight).containsExactly(170, 171, 172);
        assertThat(peopleVos).extracting(PeopleVo::getMass).containsExactly(70, 71, 72);
        assertThat(peopleVos).extracting(PeopleVo::getName)
            .containsExactly("Mocked Name 0", "Mocked Name 1", "Mocked Name 2");
    }
}
