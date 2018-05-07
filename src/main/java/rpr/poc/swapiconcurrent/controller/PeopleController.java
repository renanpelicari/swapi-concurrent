package rpr.poc.swapiconcurrent.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rpr.poc.swapiconcurrent.service.PeopleService;
import rpr.poc.swapiconcurrent.vo.PeopleVo;

import java.util.List;

/**
 * The People Controller exposes endpoint for Star Wars characters.
 */
@RestController
@Api(value = "api-star-wars-people")
@RequestMapping(value = "/application/api/people", produces = MediaType.APPLICATION_JSON_VALUE)
public class PeopleController {

    private final PeopleService peopleService;

    /**
     * Instantiate a new People Controller.
     *
     * @param peopleService the {@link PeopleService} injection.
     */
    public PeopleController(final PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    private static final Logger logger = Logger.getLogger(PeopleController.class);

    /**
     * This endpoint fetch all Star Wars characters.
     *
     * @return the {@link PeopleVo} list.
     */
    @GetMapping
    @ApiOperation(value = "Find all Star Wars characters", nickname = "findAll")
    public List<PeopleVo> findAll() throws InterruptedException {
        logger.debug("BEGIN findAll.");
        final List<PeopleVo> response = peopleService.findAll();
        logger.debug(String.format("END findAll, response={%s}", response));
        return response;
    }

}
