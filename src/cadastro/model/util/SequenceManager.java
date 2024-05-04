/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.model.util;

/**
 *
 * @author italo
 */
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SequenceManager {

    public static int getValue(String sequenceName) {
        int nextValue = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = ConectorBD.getConnection();
            String sql = "SELECT NEXT VALUE FOR " + sequenceName + " AS next_value";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                nextValue = rs.getInt("next_value");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConectorBD.close(conn);
            ConectorBD.close(rs);
            ConectorBD.close(ps);
        }

        return nextValue;
    }

    public static int getNextValueA(String tableName, String idColumnName) {
        int nextId = 1;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = ConectorBD.getConnection();
            String sql = "SELECT MAX (" + idColumnName + ") AS max_id FROM " + tableName;
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                int maxId = rs.getInt("max_id");
                nextId = maxId + 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConectorBD.close(conn);
            ConectorBD.close(ps);
            ConectorBD.close(rs);
        }
        
        return nextId;
    }
}
