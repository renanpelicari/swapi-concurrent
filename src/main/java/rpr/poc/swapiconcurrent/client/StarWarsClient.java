package rpr.poc.swapiconcurrent.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import rpr.poc.swapiconcurrent.dto.PeopleDto;

import java.util.List;

/**
 * REST interface for Star Wars API.
 *
 * @see <a href="https://swapi.co/">SWAPI</a>.
 */
@FeignClient("swapi-client")
public interface StarWarsClient {

    /**
     * Request Star Wars characters.
     *
     * @param pageNumber the number of page (default is 1).
     * @return the {@link PeopleDto} list.
     */
    @GetMapping(value = "/api/people", consumes = MediaType.APPLICATION_JSON_VALUE)
    List<PeopleDto> fetchCharacters(
        @RequestParam(value = "page", required = false, defaultValue = "1") final int pageNumber);
}
