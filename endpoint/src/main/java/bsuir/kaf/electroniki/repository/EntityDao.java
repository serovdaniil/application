package bsuir.kaf.electroniki.repository;

import java.sql.Connection;
import java.util.List;

import bsuir.kaf.electroniki.model.Entity;

/**
 * A common set of functions available for each entity individually.
 *
 * @param <T> entity
 * @author Daniil Serov
 * @version 20220504-1
 * @since 20220303-1
 */
public interface EntityDao<T extends Entity> {

    /**
     * The method creates an entry in the entity in the database.
     *
     * @param connection object connection database
     * @param entity class object
     * @throws DaoException DB-related error
     * @return id new entity
     */
    long create(Connection connection, T entity) throws DaoException;

    /**
     * Method of searching for all records of the entity in the database.
     *
     * @param connection object connection database
     * @return a collection consisting of all entity in the database
     * @throws DaoException                    DB-related error
     * @throws EntityExtractionFailedException Error processing an entity when getting it from the database
     */
    List<T> findAll(Connection connection) throws DaoException, EntityExtractionFailedException;
}
