package dat.daos;

import java.util.List;

public interface IDAO<T, ID> {

    // Create an object of type T
    T create(T entity);

    // Update an existing object of type T
    T update(T entity);

    // Delete an object by its ID of type ID
    void delete(ID id);

    // Get all objects of type T
    List<T> getAll();

    // Get an object of type T by its ID of type ID
    T getById(ID id);
}
