package rpr.poc.swapiconcurrent.service;

import com.google.common.util.concurrent.Callables;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import rpr.poc.swapiconcurrent.client.StarWarsClient;
import rpr.poc.swapiconcurrent.dto.PeopleDto;
import rpr.poc.swapiconcurrent.fixtures.PeopleDtoFixture;
import rpr.poc.swapiconcurrent.vo.PeopleVo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.BDDMockito.given;

/**
 * Unit test for {@link PeopleService}.
 */
@RunWith(MockitoJUnitRunner.class)
public class PeopleServiceTest {

    @InjectMocks
    private PeopleService peopleService;

    @Mock
    private StarWarsClient starWarsClient;

    @Mock
    private ExecutorService executorService;

    @Ignore
    @Test
    //FIXME - need to mock the async executor
    public void testFindAllSuccess() throws InterruptedException, ExecutionException {

        final List<PeopleDto> peopleDtosA = PeopleDtoFixture.getPeopleDtoList(2, 0);
        final List<PeopleDto> peopleDtosB = PeopleDtoFixture.getPeopleDtoList(2, 2);
        final List<PeopleDto> peopleDtosC = PeopleDtoFixture.getPeopleDtoList(2, 4);

        given(starWarsClient.fetchCharacters(1)).willReturn(peopleDtosA);
        given(starWarsClient.fetchCharacters(2)).willReturn(peopleDtosB);
        given(starWarsClient.fetchCharacters(3)).willReturn(peopleDtosC);

        final List<PeopleVo> returnedPeopleVos = peopleService.findAll();

        assertNotNull(returnedPeopleVos);
        assertNotEquals(Collections.emptyList(), returnedPeopleVos);
        assertThat(returnedPeopleVos).hasSize(6).extracting(PeopleVo::getMass).containsExactly(70, 71, 72, 73, 74, 75);
        assertThat(returnedPeopleVos).extracting(PeopleVo::getHeight).containsExactly(170, 171, 172, 173, 174, 175);
        assertThat(returnedPeopleVos).extracting(PeopleVo::getName)
            .containsExactly(getName(0), getName(1), getName(2), getName(3), getName(4), getName(5));
    }

    private static List<Callable<List<PeopleDto>>> getTasks(final int size) {
        final List<Callable<List<PeopleDto>>> callables = new ArrayList<>();
        IntStream.range(0, size).forEach(counter -> {
            final List<PeopleDto> peopleDtos = PeopleDtoFixture.getPeopleDtoList(2, counter * 2);
            callables.add(Callables.returning(peopleDtos));
        });
        return callables;
    }

    private String getName(final int id) {
        return "Mocked Name " + id;
    }

}
