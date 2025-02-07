package CCDAC.CCDAO;

import CCDAC.CCDataHelperSqlite;
import CCDAC.CCDTO.CCGenomaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class CCGenomaDAO extends CCDataHelperSqlite implements IDAO<CCGenomaDTO> {
    @Override
    public boolean created(CCGenomaDTO entity)throws Exception{
        try {
            String query="INSERT INTO CCGenoma (Name,Estado) VALUES(?,?)";
            Connection cone = opConnection();
            PreparedStatement pst=cone.prepareStatement(query);
            pst.setString(1, entity.getName());
            pst.setString(2, entity.getEstado());
            pst.executeQuery();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    @Override
    public boolean update(CCGenomaDTO entity)throws Exception{
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        try {
            String query="UPDATE CCGenoma SET"
                        +",Name=?, "
                        +",Estado=?, "
                        +",FechaActua=? WHERE IdGenoma = ? ";
            Connection cone = opConnection();
            PreparedStatement pst=cone.prepareStatement(query);
            pst.setString(1, entity.getName());
            pst.setString(2, entity.getEstado());
            pst.setString(3, dtf.format(now).toString());
            pst.setInt(4, entity.getIdGenoma());
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    @Override
    public boolean delete(Integer ccId)throws Exception{
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        try {
            String query="UPDATE CCGenoma SET "
                        +"Estado=?, "
                        +"FechaActua=? WHERE IdGenoma = ? ";
            Connection cone = opConnection();
            PreparedStatement pst=cone.prepareStatement(query);
            pst.setString(1, "D");
            pst.setString(2, dtf.format(now).toString());
            pst.setInt(3, ccId);
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    public List<CCGenomaDTO> ccReadBox(){
        List<CCGenomaDTO> ccTabla=new ArrayList<>();
        String ccQuery="SELECT "
                        +"IdGenoma "      
                        +",Name "         
                        +"FROM CCGenoma WHERE Estado='A'";  
        try {
              Connection conec=opConnection();
              Statement stm=conec.createStatement();
              ResultSet rs=stm.executeQuery(ccQuery);
              while(rs.next()){
                CCGenomaDTO registro=new CCGenomaDTO(
                                    rs.getInt(1),
                                    rs.getString(2));
                                    ccTabla.add(registro);
                            }
                        return ccTabla;
            } catch (Exception e) {
            System.out.println(e);
            }
        return ccTabla;
      
    }
}
