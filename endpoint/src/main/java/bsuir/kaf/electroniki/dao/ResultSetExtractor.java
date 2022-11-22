package bsuir.kaf.electroniki.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import bsuir.kaf.electroniki.model.Entity;

/**
 * An interface that contains a method for processing the received records from the database.
 *
 * @author Daniil Serov
 * @version 20220504-1
 * @since 20220303-1
 *
 * @param <T> entity
 */
public interface ResultSetExtractor<T extends Entity> {

    /**
     * Method of processing received records from the database.
     *
     * @param resultSet elements from the database
     * @return list of elements from the database of the corresponding entity
     * @throws SQLException                    DB-related error
     * @throws EntityExtractionFailedException Error processing an entity when getting it from the database
     */
    List<T> extractAll(ResultSet resultSet) throws SQLException, EntityExtractionFailedException;
}
