package CCDAC.CCDAO;
import java.util.List;
public interface IDAO<T>{
    public boolean created(T entity)throws Exception;
    public boolean update(T entity)throws Exception;
    public List<T> ccReadBox()throws Exception;
    public boolean delete(Integer id)throws Exception;
}