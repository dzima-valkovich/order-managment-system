package by.ihorosho.storage.adapters.daos;

import by.ihorosho.api.storage.daos.IWorkTypeDao;
import by.ihorosho.api.storage.domain.order.IWorkType;
import by.ihorosho.storage.adapters.domain.order.WorkTypeAdapter;
import by.ihorosho.storage.daos.WorkTypeDao;
import by.ihorosho.storage.domain.order.WorkType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component("workTypeDaoAdapter")
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class WorkTypeDaoAdapter implements IWorkTypeDao {
    private WorkTypeDao workTypeDao;

    @Override
    public List<IWorkType> getAll() {
        return workTypeDao.getAll().stream()
                .map(WorkTypeAdapter::new).collect(Collectors.toList());
    }

    @Override
    public List<IWorkType> getAll(int limit) {
        return workTypeDao.getAll(limit).stream()
                .map(WorkTypeAdapter::new).collect(Collectors.toList());
    }

    @Override
    public List<IWorkType> getAll(int offset, int limit) {
        return workTypeDao.getAll(offset, limit).stream()
                .map(WorkTypeAdapter::new).collect(Collectors.toList());
    }

    @Override
    public IWorkType getById(Long aLong) {
        return new WorkTypeAdapter(workTypeDao.getById(aLong));
    }

    @Override
    public IWorkType save(IWorkType entity) {
        WorkType w = workTypeDao.save(((WorkTypeAdapter) entity).getWorkType());
        return new WorkTypeAdapter(w);
    }

    @Override
    public IWorkType update(IWorkType entity) {
        WorkType w = workTypeDao.update(((WorkTypeAdapter) entity).getWorkType());
        return new WorkTypeAdapter(w);
    }

    @Override
    public Boolean deleteById(Long aLong) {
        return workTypeDao.deleteById(aLong);
    }

    public WorkTypeDao getWorkTypeDao() {
        return workTypeDao;
    }

    @Autowired
    public void setWorkTypeDao(WorkTypeDao workTypeDao) {
        this.workTypeDao = workTypeDao;
    }
}
