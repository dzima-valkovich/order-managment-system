package by.ihorosho.api.storage.domain;

public interface IEntity<ID> {
    ID getId();

    void setId(ID id);
}
