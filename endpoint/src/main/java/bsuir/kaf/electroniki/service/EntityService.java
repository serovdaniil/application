package bsuir.kaf.electroniki.service;

import java.util.List;



import bsuir.kaf.electroniki.model.Entity;
import bsuir.kaf.electroniki.repository.EntityExtractionFailedException;

/**
 * A common set of functions available for each entity individually.
 *
 * @param <T> entity
 * @author Daniil Serov
 * @version 20220504-1
 * @since 20220303-1
 */
public interface EntityService<T extends Entity> {

    /**
     * A service layer method that calls a method in the dao layer to create an entity.
     *
     * @param entity class object
     * @throws ServiceException    DB-related error
     * @return id new entity
     */
    long create(T entity) throws ServiceException;

    /**
     * The function of the search service for all objects to call the dao.
     *
     * @return a collection consisting of all entities in the database
     * @throws ServiceException                DB-related error
     * @throws EntityExtractionFailedException Error processing an entity when getting it from the database
     */
    List<T> findAll() throws ServiceException, EntityExtractionFailedException;
}
