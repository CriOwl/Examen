package CCBLC;

import java.util.List;
import java.util.function.Supplier;

import CCDAC.CCDAO.IDAO;

public class CCBlTable<T> {
    private final IDAO<T> dao;

    public CCBlTable(Supplier<IDAO<T>> suplier) {
        this.dao = suplier.get();
    }

    public List<T> read_elments() throws Exception {
        return dao.ccReadBox();
    }

    public boolean cretated_elements(T entity) throws Exception {
        return dao.created(entity);
    }

    public boolean update_elements(T entity) throws Exception {
        return dao.update(entity);
    }

    public boolean delete(Integer id) throws Exception {
        return dao.delete(id);
    }
}
