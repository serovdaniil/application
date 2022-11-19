package bsuir.kaf.electroniki.model;

public interface Entity {

    /**
     * Default id new entity.
     */
    long DEFAULT_ID_FOR_CREATE_ENTITY = -1;

    /**
     * Getting the entity's id.
     *
     * @return id
     */
    Long getId();

    default boolean isNew() {
        return getId() <= DEFAULT_ID_FOR_CREATE_ENTITY;
    }
}
