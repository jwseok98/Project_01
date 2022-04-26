package sample.cwe259;

import java.sql.*;

public class KRD_207_getConnection_0101_bad {
    public void bad() throws Throwable
    {
        String data;

        /* FLAW: Set data to a hardcoded string */
        data = "7e5tc4s3";

        Connection conn2 = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        if (data != null)
        {
        	String pw = data.substring(0,7);
        	
            try
            {            	
                /* POTENTIAL FLAW: data used as password in database connection */
            	conn2 = DriverManager.getConnection("data-url", "root", pw);
                preparedStatement = conn2.prepareStatement("select * from test_table");
                resultSet = preparedStatement.executeQuery();
            }
            catch (SQLException exceptSql)
            {
            	sample.cwe.logger.Logger.writeLine("Error with database connection" + exceptSql);
            }
            finally
            {
                try
                {
                    if (resultSet != null)
                    {
                        resultSet.close();
                    }
                }
                catch (SQLException exceptSql)
                {
                	sample.cwe.logger.Logger.writeLine("Error with database connection" + exceptSql);
                }

                try
                {
                    if (preparedStatement != null)
                    {
                        preparedStatement.close();
                    }
                }
                catch (SQLException exceptSql)
                {
                	sample.cwe.logger.Logger.writeLine("Error with database connection" + exceptSql);
                }

                try
                {
                    if (conn2 != null)
                    {
                    	conn2.close();
                    }
                }
                catch (SQLException exceptSql)
                {
                	sample.cwe.logger.Logger.writeLine("Error with database connection" + exceptSql);
                }
            }
        }

    }
}
