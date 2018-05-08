package rpr.poc.swapiconcurrent.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import rpr.poc.swapiconcurrent.client.StarWarsClient;
import rpr.poc.swapiconcurrent.controller.PeopleController;
import rpr.poc.swapiconcurrent.converter.PeopleConverter;
import rpr.poc.swapiconcurrent.dto.PeopleDto;
import rpr.poc.swapiconcurrent.vo.PeopleVo;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * The People service layer.
 */
@Service
public class PeopleService {

    private final StarWarsClient starWarsClient;

    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

    private static final Logger logger = Logger.getLogger(PeopleController.class);

    /**
     * Instantiate a new People Service.
     *
     * @param starWarsClient the {@link StarWarsClient} injection.
     */
    public PeopleService(final StarWarsClient starWarsClient) {
        this.starWarsClient = starWarsClient;
    }

    /**
     * This method call many times the <a href="https://swapi.co/">Star Wars API</a> simultaneously,
     * process all data, and response at once.
     *
     * @return the {@link PeopleVo} list.
     */
    public List<PeopleVo> findAll() throws InterruptedException {
        logger.debug("BEGIN findAll.");

        final List<Callable<List<PeopleDto>>> callables = Arrays.asList(
            () -> starWarsClient.fetchCharacters(1),
            () -> starWarsClient.fetchCharacters(2),
            () -> starWarsClient.fetchCharacters(3));

        final List<PeopleDto> peopleDtos = getPeopleDtosByCallables(callables);
        return PeopleConverter.peopleDtoToVo(peopleDtos);
    }

    private List<PeopleDto> getPeopleDtosByCallables(final List<Callable<List<PeopleDto>>> callables)
        throws InterruptedException {
        return executorService.invokeAll(callables).stream().map(future -> {
            try {
                return future.get();
            } catch (final Exception e) {
                throw new IllegalStateException(e);
            }
        }).flatMap(Collection::stream).collect(Collectors.toList());
    }

}
