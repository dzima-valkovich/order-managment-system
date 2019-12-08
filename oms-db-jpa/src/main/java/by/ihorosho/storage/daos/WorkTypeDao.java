package by.ihorosho.storage.daos;

import by.ihorosho.storage.AbstractOmsCrudDao;
import by.ihorosho.storage.domain.order.WorkType;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository("workTypeDao")
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class WorkTypeDao extends AbstractOmsCrudDao<WorkType, Long> {

    public WorkTypeDao() {
        super.setClazz(WorkType.class);
    }
}
