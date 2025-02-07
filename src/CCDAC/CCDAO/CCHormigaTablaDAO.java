package CCDAC.CCDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import CCDAC.CCDataHelperSqlite;
import CCDAC.CCDTO.CCHormigaTablaDTO;


public class CCHormigaTablaDAO extends CCDataHelperSqlite implements IVIEWDAO<CCHormigaTablaDTO> {
    @Override
    public CCHormigaTablaDTO readby(Integer id) throws Exception {
        CCHormigaTablaDTO registro = new CCHormigaTablaDTO();
        String query = "SELECT "
                        +"ID, "
                        +"TipoHormiga, "
                        +"SEXO, "
                        +"Alimento, "
                        +"Estado, "
                        +"Entrenado "
                        +"FROM CCVwHormiga WHERE ID = "+id;
        try {
            Connection conn = opConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                CCHormigaTablaDTO registro = new CCHormigaTablaDTO(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6));
            }
        } catch (SQLException e) {
            System.out.println("e");
        }
        return institution;
    }

    @Override
    public List<CCHormigaTablaDTO> readall(){
        List<CCHormigaTablaDTO> tabla = new ArrayList<>();
        String query = "SELECT "
                        +"ID, "
                        +"TipoHormiga, "
                        +"SEXO, "
                        +"Alimento, "
                        +"Estado, "
                        +"Entrenado "
                        +"FROM CCVwHormiga";
        try {
            Connection conn = opConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                CCHormigaTablaDTO registro = new CCHormigaTablaDTO(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6));
                tabla.add(registro);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return tabla;
    }

    @Override
    public List<CCHormigaTablaDTO> read_column() throws Exception {
        List<CCHormigaTablaDTO> columns = new ArrayList<>();
        String query = "PRAGMA table_info(CCVwHormiga) ";
        try {
            Connection connect = opConnection();
            Statement stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                CCHormigaTablaDTO column = new CCHormigaTablaDTO(
                        rs.getString(2)

                );
                columns.add(column);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return columns;
    }

    @Override
    public List<CCHormigaTablaDTO> search_read(String tipo) throws Exception {
        List<CCHormigaTablaDTO> tabla = new ArrayList<>();
        String query = "SELECT "
                        +"ID, "
                        +"TipoHormiga, "
                        +"SEXO, "
                        +"Alimento, "
                        +"Estado, "
                        +"Entrenado "
                        +"FROM CCVwHormiga "
                        + "WHERE TipoHormiga LIKE ? ";

        try {
            Connection connect = opConnection();
            PreparedStatement stmt = connect.prepareStatement(query);
            stmt.setString(1, "%"+tipo+"%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                    CCHormigaTablaDTO registro = new CCHormigaTablaDTO(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6));
                tabla.add(registro);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return tabla;
    }
}
