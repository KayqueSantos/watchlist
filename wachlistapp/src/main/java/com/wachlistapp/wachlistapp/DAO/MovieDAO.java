package com.wachlistapp.wachlistapp.DAO;

import com.wachlistapp.wachlistapp.model.Movie;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kayques
 */
@Repository
public class MovieDAO {

    @Autowired
    private EntityManager entityManager;
    
    
    public List<Movie> getAll() {
        List<Movie> list;
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Movie> query = currentSession.createQuery("from Movie", Movie.class);
        list = query.getResultList();
        return list;
    }

    
    public Movie getById(String id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Movie movieObj = currentSession.get(Movie.class, id);
        return movieObj;
    }

    
    public void save(Movie movie) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.save(movie);
    }
    
    
    public void update(Movie movie) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.update(movie);
    }

    
    public void delete(Movie movie) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.delete(movie);
    }
    
    
}
