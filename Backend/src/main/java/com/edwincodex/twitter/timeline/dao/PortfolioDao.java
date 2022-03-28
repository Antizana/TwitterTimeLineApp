package com.edwincodex.twitter.timeline.dao;

import com.edwincodex.twitter.timeline.models.Portfolio;

import java.util.List;

public interface PortfolioDao {
    List<Portfolio> getPortfolio(Long idPortfolio);

    List<Portfolio> getPortfolio();

    Portfolio updatePortfolio(Portfolio portfolio);

    Portfolio createPortfolio(Portfolio portfolio);

    void deletePortfolio(Long idPortfolio);
}
