import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TravelDAO {
    private Connection conn;
    String url = "jdbc:mysql://localhost:3306/travel_db";
    String user = "root";
    String password = "1234";

    TravelDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("DB 연결 완료");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("오류: "+e.getMessage());
        }
    }

    public List<TravelVO> findByDistrict(String district){
        List<TravelVO> travelLists = new ArrayList<TravelVO>();
        ResultSet rs = null;
        Statement stmt = null;
        String sql = "select * from travel";

        if(district != null){
            sql += (" where district ='" + district + "'");
        }

        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                TravelVO travel = new TravelVO(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)
                );
                travelLists.add(travel);
            }
        } catch (SQLException e) {
            System.out.println("에러: "+e.getMessage());
        } finally {
            if(rs != null) {try {rs.close();} catch(SQLException e) {}}
            if (stmt != null) {try {stmt.close();} catch (SQLException e) {}}
        }
        return travelLists;
    }

    public List<TravelVO> findByKeyword(String keyword){
        List<TravelVO> travelLists = new ArrayList<>();
        ResultSet rs = null;
        Statement stmt = null;
        String sql = "select * from travel where description like '%"+keyword+"%'";

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                TravelVO travel = new TravelVO(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)
                );
                travelLists.add(travel);
            }
        } catch (SQLException e) {
            System.out.println("에러: "+e.getMessage());
        } finally {
            if(rs != null) {try {rs.close();} catch(SQLException e) {}}
            if (stmt != null) {try {stmt.close();} catch (SQLException e) {}}
        }

        return travelLists;
    }
}
