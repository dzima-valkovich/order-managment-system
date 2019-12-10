package by.ihorosho.api.storage.daos;

import java.util.List;

public interface IOmsCrudDao<T, ID> {
    List<T> getAll();

    List<T> getAll(int limit);

    List<T> getAll(int offset, int limit);

    T getById(ID id);

    T save(T entity);

    T update(T entity);

    Boolean deleteById(ID id);
}
