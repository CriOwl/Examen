package CCBLC;

import java.util.List;
import java.util.function.Supplier;

import CCDAC.CCDAO.IVIEWDAO;

public class CCBlView<T> {
    private final IVIEWDAO<T> dao;

    public CCBlView(Supplier<IVIEWDAO<T>> supplier) {
        this.dao = supplier.get();
    }

    public List<T> getAll() throws Exception {
        return dao.readall();
    }

    public T getBy(Integer id) throws Exception {
        return dao.readby(id);
    }

    public List<T> getColumn() throws Exception {
        return dao.read_column();
    }
    public List<T> search(String Tipo) throws Exception {
        return dao.search_read(Tipo);
    }
}
