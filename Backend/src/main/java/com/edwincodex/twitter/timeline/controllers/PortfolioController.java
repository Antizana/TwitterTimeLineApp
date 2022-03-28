/**
 * Spring Boot - React Twitter Timeline
 */
package com.edwincodex.twitter.timeline.controllers;

import com.edwincodex.twitter.timeline.dao.PortfolioDao;
import com.edwincodex.twitter.timeline.models.Portfolio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin(origins = "*")
public class PortfolioController {

    @Autowired
    private PortfolioDao portfolioDao;

    @RequestMapping(value = "api/v1/profile/{idPortfolio}", method = RequestMethod.GET)
    public List<Portfolio> getPortfolio(@PathVariable Long idPortfolio) {
        return portfolioDao.getPortfolio(idPortfolio);
    }

    @RequestMapping(value = "api/v1/profile", method = RequestMethod.PUT)
    public Portfolio updatePortfolio(@RequestBody Portfolio portfolio) {
        return portfolioDao.updatePortfolio(portfolio);
    }

    @RequestMapping(value = "api/v1/profiles", method = RequestMethod.GET)
    public List<Portfolio> getProfiles() {
        return portfolioDao.getPortfolio();
    }

    @RequestMapping(value = "api/v1/profile", method = RequestMethod.POST)
    public Portfolio createPortfolio(@RequestBody Portfolio portfolio) {
        return portfolioDao.createPortfolio(portfolio);
    }

    @RequestMapping(value = "api/v1/profile/{idPortfolio}", method = RequestMethod.DELETE)
    public void deletePortfolio(@PathVariable Long idPortfolio) {
        portfolioDao.deletePortfolio(idPortfolio);
    }

}
