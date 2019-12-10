package by.ihorosho.api.domain;

public interface IEntity<ID> {
    ID getId();

    void setId(ID id);
}
