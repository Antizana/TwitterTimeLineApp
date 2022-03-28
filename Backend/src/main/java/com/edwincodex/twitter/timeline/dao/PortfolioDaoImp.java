package com.edwincodex.twitter.timeline.dao;

import com.edwincodex.twitter.timeline.models.Portfolio;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class PortfolioDaoImp implements PortfolioDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Portfolio> getPortfolio(Long idPortfolio) {

        String query = "FROM Portfolio p WHERE p.idPortfolio LIKE :portfolioId";
        return entityManager.createQuery(query)
                .setParameter("portfolioId", idPortfolio)
                .getResultList();
    }

    @Override
    public List<Portfolio> getPortfolio() {

        String query = "FROM Portfolio";
        return entityManager.createQuery(query)
                .getResultList();
    }

    @Override
    public Portfolio updatePortfolio(Portfolio portfolio) {
        return entityManager.merge(portfolio);
    }

    @Override
    public Portfolio createPortfolio(Portfolio portfolio) {
        return entityManager.merge(portfolio);
    }

    @Override
    public void deletePortfolio(Long idPortfolio) {
        Portfolio portfolio = entityManager.find(Portfolio.class, idPortfolio);
        entityManager.remove(portfolio);
    }

}
