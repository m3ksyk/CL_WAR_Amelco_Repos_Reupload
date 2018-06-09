package pl.coderslab.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Transactional
public class BookRepositoryImpl implements BookRepoCustom {

    @PersistenceUnit
    private EntityManagerFactory emFactory;

    public BookRepositoryImpl() {
    }

    @Override
    public void resetRating(int rating) {
        //the method crashed without transactional annotation and utilising joinTransaction;
        EntityManager entityManager = emFactory.createEntityManager();
        Query query = entityManager.createQuery("UPDATE Book b set b.rating = :rating");
        query.setParameter("rating", rating);
        entityManager.joinTransaction();
        query.executeUpdate();
    }

}

