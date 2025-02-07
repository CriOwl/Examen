package CCDAC.CCDAO;

import CCDAC.CCDTO.CCHormigaDTO;
import CCDAC.CCDataHelperSqlite;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CCHormigaDAO extends CCDataHelperSqlite implements IDAO<CCHormigaDTO>{

    public CCHormigaDTO readby(Integer id) throws Exception {
        CCHormigaDTO registro = new CCHormigaDTO();
        String query = " SELECT "
                + " h.IdHormiga,    "
                + " h.IdTipoHormiga,"
                + " h.IdSexo,       "
                + " h.Estado,       "
                + " h.IdIngestaNativa,   "
                + " h.IdGenoma,   "
                + " h.Entrenada     "
                + " FROM    CCHormiga   c WHERE h.IdHormiga = ?";
        try {
            Connection conn = opConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                registro = new CCHormigaDTO(
                    rs.getInt(1), 
                    rs.getInt(2), 
                    rs.getInt(3), 
                    rs.getString(4),
                    rs.getInt(5), 
                    rs.getInt(6), 
                    rs.getString(7));
            }
        } catch (SQLException e) {
            throw e;
        }
        return registro;
    }

    public List<CCHormigaDTO> readall() {
        List<CCHormigaDTO> tabla = new ArrayList<>();
        String query = " SELECT "
                + " h.IdHormiga,    "
                + " h.IdTipoHormiga,"
                + " h.IdSexo,       "
                + " h.Estado,       "
                + " h.IdIngestaNativa,   "
                + " h.IdGenoma,   "
                + " h.Entrenada     "
                + " FROM    CCHormiga ";
        try {
            Connection conect = opConnection();
            Statement stm = conect.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                CCHormigaDTO registro = new CCHormigaDTO(
                    rs.getInt(1), 
                    rs.getInt(2), 
                    rs.getInt(3), 
                    rs.getString(4),
                    rs.getInt(5), 
                    rs.getInt(6), 
                    rs.getString(7));
                tabla.add(registro);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return tabla;
    }
@Override
    public boolean created(CCHormigaDTO entity) {
        String query = " INSERT INTO CCHormiga (IdTipoHormiga, IdSexo)"
                + " VALUES(?,?)";
        try {
            Connection conect = opConnection();
            PreparedStatement pstm = conect.prepareStatement(query);
            pstm.setInt(1,entity.getIdTipoHormiga());
            pstm.setInt(2,entity.getIdSexo());
            pstm.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
@Override
    public boolean update(CCHormigaDTO entity) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE CCHormiga SET "
                        + " IdTipoHormiga = ?"
                        + " ,IdSexo = ?       "
                        + " ,Estado = ?       "
                        + " ,IdIngestaNativa = ?   "
                        + " ,IdGenoma = ?   "
                        + " ,FechaActua = ?"
                        + " WHERE IdHormiga = "+entity.getIdHormiga();    
        try {
            Connection conect = opConnection();
            PreparedStatement pstm = conect.prepareStatement(query);
            pstm.setInt(1, entity.getIdTipoHormiga());
            pstm.setInt(2, entity.getIdSexo());
            pstm.setString(3, entity.getEstado());
            pstm.setInt(4, entity.getIdIngestaNativa());
            pstm.setInt(5, entity.getIdGenoma());
            pstm.setString(6, dtf.format(now).toString());
            pstm.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
@Override
    public boolean delete(Integer id) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE CCHormiga SET "
                         + " Estado = ?       "
                         + " ,FechaActua = ?"
                        +  " WHERE IdHormiga = "+id;    
        try {
            Connection conect = opConnection();
            PreparedStatement pstm = conect.prepareStatement(query);
            pstm.setString(1,"MUERTA");
            pstm.setString(2, dtf.format(now).toString());
            pstm.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    @Override
    public List<CCHormigaDTO> ccReadBox(){
        List<CCHormigaDTO> tabla = new ArrayList<>();
        String query = " SELECT "
                + " h.IdHormiga,    "
                + " h.IdTipoHormiga,"
                + " h.IdSexo,       "
                + " h.Estado,       "
                + " h.IdIngestaNativa,   "
                + " h.IdGenoma,   "
                + " h.Entrenada     "
                + " FROM    CCHormiga ";
        try {
            Connection conect = opConnection();
            Statement stm = conect.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                CCHormigaDTO registro = new CCHormigaDTO(
                    rs.getInt(1), 
                    rs.getInt(2), 
                    rs.getInt(3), 
                    rs.getString(4),
                    rs.getInt(5), 
                    rs.getInt(6), 
                    rs.getString(7));
                tabla.add(registro);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return tabla;
    }
    public boolean entrenar(Integer id) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE CCHormiga SET "
                         + " Entrenada = ?       "
                         + " ,FechaActua = ?"
                        +  " WHERE IdHormiga = "+id;    
        try {
            Connection conect = opConnection();
            PreparedStatement pstm = conect.prepareStatement(query);
            pstm.setString(1,"SI");
            pstm.setString(2, dtf.format(now).toString());
            pstm.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    
}
