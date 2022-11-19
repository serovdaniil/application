package bsuir.kaf.electroniki.api.common;

/**
 * The class provides two methods, each of which converts the model in the opposite direction.
 *
 * @param <Entity> model entity
 * @param <Model> web model entity
 */
public interface EntityModelConverter<Entity, Model> {

    /**
     * The method of translating a web model into an entity.
     *
     * @param model web model
     * @return  entity
     */
    Entity fromModel(Model model);

    /**
     * A method for translating an entity into a web model.
     *
     * @param entity entity
     * @return web model entity
     */
    Model toModel(Entity entity);

}
