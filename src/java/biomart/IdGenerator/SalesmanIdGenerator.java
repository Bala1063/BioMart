/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biomart.IdGenerator;

import biomart.Util.DBUtil;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author bala
 */
public class SalesmanIdGenerator  {

    
    public String generateSalesmanId(String userName){

        ResultSet resultSet = null;
        Statement statement = null;

        try {
            Connection con = DBUtil.getDBConnection();
            statement = con.createStatement();
            String prefix = "SAL_";
            int x = 0;
            try {

                resultSet = statement.executeQuery("Select Salesman_Seq.nextval from dual");
            } catch (Exception e) {
                statement.execute("create sequence Salesman_Seq start with 1 increment by 1 nocycle nocache");
                resultSet = statement.executeQuery("Select Salesman_Seq.nexttval from dual");
            }
            if (resultSet.next()) {
                x = (Integer) resultSet.getInt(1);
                String suffix = String.format("%03d", x);
                return prefix.concat(suffix);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
