import java.sql.*;

/**
 * Created by qzin on 02.12.16.
 */
public class HSQL_Connector
{
    public static Connection connection;
    public static Statement statement;
    public static ResultSet resultSet;

//    connection = DriverManager.getConnection("jdbc:hsqldb:file:testdb", "SA", "");

    public static void SqlConn() throws ClassNotFoundException, SQLException
    {
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver" );

        } catch (Exception e) {
            System.err.println("ERROR: failed to load HSQLDB JDBC driver.");
            e.printStackTrace();
            return;
        }
        connection = DriverManager.getConnection("jdbc:hsqldb:file:./DB/hyperTula", "SA", "secret");
        statement = connection.createStatement();
        System.out.println("Base connected");
    }

    public static void createDB() throws SQLException, ClassNotFoundException
    {



     //   statement.execute("DROP TABLE IF EXISTS TagValues;");
     //   statement.execute("DROP TABLE IF EXISTS Tags;");


        statement.execute("CREATE TABLE if not exists Tags (TagId INTEGER GENERATED BY DEFAULT AS IDENTITY UNIQUE, TagName VARCHAR(64) NOT NULL UNIQUE, TagDesc VARCHAR(512);");
        statement.execute("CREATE TABLE if not exists TagValues (TagId INTEGER NOT NULL, Value REAL, iData INTEGER, Status BOOLEAN , FOREIGN KEY(TagId) REFERENCES Tags(TagId));");

        System.out.println("Table created or exists");

    }

    public static void writeDB() throws SQLException
    {
        if (true) {
            statement.execute("Insert into Tags (TagName) values\n" +
                    " ('Tag001'),\n" +
                    " ('Tag002'),\n" +
                    " ('Tag003'),\n" +
                    " ('Tag004'),\n" +
                    " ('Tag005'),\n" +
                    " ('Tag006'),\n" +
                    " ('Tag007'),\n" +
                    " ('Tag008'),\n" +
                    " ('Tag009'),\n" +
                    " ('Tag010'),\n" +
                    " ('Tag011'),\n" +
                    " ('Tag012'),\n" +
                    " ('Tag013'),\n" +
                    " ('Tag014'),\n" +
                    " ('Tag015');");
        }
        for (int i = 0; i <10000 ; i++) {


        statement.execute("Insert into TagValues(TagId,Value,iData) values\n" +
                "\n" +
                "((Select TagId from Tags where TagName = 'Tag001'),1,20161201),\n" +
                "((Select TagId from Tags where TagName = 'Tag001'),1,20161202),\n" +
                "((Select TagId from Tags where TagName = 'Tag001'),1,20161203),\n" +
                "((Select TagId from Tags where TagName = 'Tag001'),1,20161204),\n" +
                "((Select TagId from Tags where TagName = 'Tag001'),1,20161205),\n" +
                "((Select TagId from Tags where TagName = 'Tag001'),1,20161206),\n" +
                "\n" +
                "\n" +
                "((Select TagId from Tags where TagName = 'Tag002'),2,20161201),\n" +
                "((Select TagId from Tags where TagName = 'Tag002'),2,20161202),\n" +
                "((Select TagId from Tags where TagName = 'Tag002'),2,20161203),\n" +
                "((Select TagId from Tags where TagName = 'Tag002'),2,20161204),\n" +
                "((Select TagId from Tags where TagName = 'Tag002'),2,20161205),\n" +
                "((Select TagId from Tags where TagName = 'Tag002'),2,20161206),\n" +
                "\n" +
                "((Select TagId from Tags where TagName = 'Tag003'),3,20161201),\n" +
                "((Select TagId from Tags where TagName = 'Tag003'),3,20161202),\n" +
                "((Select TagId from Tags where TagName = 'Tag003'),3,20161203),\n" +
                "((Select TagId from Tags where TagName = 'Tag003'),3,20161204),\n" +
                "((Select TagId from Tags where TagName = 'Tag003'),3,20161205),\n" +
                "((Select TagId from Tags where TagName = 'Tag003'),3,20161206),\n" +
                "\n" +
                "((Select TagId from Tags where TagName = 'Tag004'),4,20161201),\n" +
                "((Select TagId from Tags where TagName = 'Tag004'),4,20161202),\n" +
                "((Select TagId from Tags where TagName = 'Tag004'),4,20161203),\n" +
                "((Select TagId from Tags where TagName = 'Tag004'),4,20161204),\n" +
                "((Select TagId from Tags where TagName = 'Tag004'),4,20161205),\n" +
                "((Select TagId from Tags where TagName = 'Tag004'),4,20161206),\n" +
                "\n" +
                "((Select TagId from Tags where TagName = 'Tag005'),5,20161201),\n" +
                "((Select TagId from Tags where TagName = 'Tag005'),5,20161202),\n" +
                "((Select TagId from Tags where TagName = 'Tag005'),5,20161203),\n" +
                "((Select TagId from Tags where TagName = 'Tag005'),5,20161204),\n" +
                "((Select TagId from Tags where TagName = 'Tag005'),5,20161205),\n" +
                "((Select TagId from Tags where TagName = 'Tag005'),5,20161206),\n" +
                "\n" +
                "\n" +
                "((Select TagId from Tags where TagName = 'Tag006'),6,20161201),\n" +
                "((Select TagId from Tags where TagName = 'Tag006'),6,20161202),\n" +
                "((Select TagId from Tags where TagName = 'Tag006'),6,20161203),\n" +
                "((Select TagId from Tags where TagName = 'Tag006'),6,20161204),\n" +
                "((Select TagId from Tags where TagName = 'Tag006'),6,20161205),\n" +
                "((Select TagId from Tags where TagName = 'Tag006'),6,20161206),\n" +
                "\n" +
                "\n" +
                "((Select TagId from Tags where TagName = 'Tag007'),7,20161201),\n" +
                "((Select TagId from Tags where TagName = 'Tag007'),7,20161202),\n" +
                "((Select TagId from Tags where TagName = 'Tag007'),7,20161203),\n" +
                "((Select TagId from Tags where TagName = 'Tag007'),7,20161204),\n" +
                "((Select TagId from Tags where TagName = 'Tag007'),7,20161205),\n" +
                "((Select TagId from Tags where TagName = 'Tag007'),7,20161206),\n" +
                "\n" +
                "\n" +
                "((Select TagId from Tags where TagName = 'Tag008'),8,20161201),\n" +
                "((Select TagId from Tags where TagName = 'Tag008'),8,20161202),\n" +
                "((Select TagId from Tags where TagName = 'Tag008'),8,20161203),\n" +
                "((Select TagId from Tags where TagName = 'Tag008'),8,20161204),\n" +
                "((Select TagId from Tags where TagName = 'Tag008'),8,20161205),\n" +
                "((Select TagId from Tags where TagName = 'Tag008'),8,20161206),\n" +
                "\n" +
                "\n" +
                "((Select TagId from Tags where TagName = 'Tag009'),9,20161201),\n" +
                "((Select TagId from Tags where TagName = 'Tag009'),9,20161202),\n" +
                "((Select TagId from Tags where TagName = 'Tag009'),9,20161203),\n" +
                "((Select TagId from Tags where TagName = 'Tag009'),9,20161204),\n" +
                "((Select TagId from Tags where TagName = 'Tag009'),9,20161205),\n" +
                "((Select TagId from Tags where TagName = 'Tag009'),9,20161206),\n" +
                "\n" +
                "((Select TagId from Tags where TagName = 'Tag010'),10,20161201),\n" +
                "((Select TagId from Tags where TagName = 'Tag010'),10,20161202),\n" +
                "((Select TagId from Tags where TagName = 'Tag010'),10,20161203),\n" +
                "((Select TagId from Tags where TagName = 'Tag010'),10,20161204),\n" +
                "((Select TagId from Tags where TagName = 'Tag010'),10,20161205),\n" +
                "((Select TagId from Tags where TagName = 'Tag010'),10,20161206),\n" +
                "\n" +
                "((Select TagId from Tags where TagName = 'Tag011'),11,20161201),\n" +
                "((Select TagId from Tags where TagName = 'Tag011'),11,20161202),\n" +
                "((Select TagId from Tags where TagName = 'Tag011'),11,20161203),\n" +
                "((Select TagId from Tags where TagName = 'Tag011'),11,20161204),\n" +
                "((Select TagId from Tags where TagName = 'Tag011'),11,20161205),\n" +
                "((Select TagId from Tags where TagName = 'Tag011'),11,20161206),\n" +
                "\n" +
                "((Select TagId from Tags where TagName = 'Tag012'),12,20161201),\n" +
                "((Select TagId from Tags where TagName = 'Tag012'),12,20161202),\n" +
                "((Select TagId from Tags where TagName = 'Tag012'),12,20161203),\n" +
                "((Select TagId from Tags where TagName = 'Tag012'),12,20161204),\n" +
                "((Select TagId from Tags where TagName = 'Tag012'),12,20161205),\n" +
                "((Select TagId from Tags where TagName = 'Tag012'),12,20161206),\n" +
                "\n" +
                "\n" +
                "((Select TagId from Tags where TagName = 'Tag013'),13,20161201),\n" +
                "((Select TagId from Tags where TagName = 'Tag013'),13,20161202),\n" +
                "((Select TagId from Tags where TagName = 'Tag013'),13,20161203),\n" +
                "((Select TagId from Tags where TagName = 'Tag013'),13,20161204),\n" +
                "((Select TagId from Tags where TagName = 'Tag013'),13,20161205),\n" +
                "((Select TagId from Tags where TagName = 'Tag013'),13,20161206),\n" +
                "\n" +
                "\n" +
                "((Select TagId from Tags where TagName = 'Tag014'),14,20161201),\n" +
                "((Select TagId from Tags where TagName = 'Tag014'),14,20161202),\n" +
                "((Select TagId from Tags where TagName = 'Tag014'),14,20161203),\n" +
                "((Select TagId from Tags where TagName = 'Tag014'),14,20161204),\n" +
                "((Select TagId from Tags where TagName = 'Tag014'),14,20161205),\n" +
                "((Select TagId from Tags where TagName = 'Tag014'),14,20161206),\n" +
                "\n" +
                "\n" +
                "((Select TagId from Tags where TagName = 'Tag015'),15,20161201),\n" +
                "((Select TagId from Tags where TagName = 'Tag015'),15,20161202),\n" +
                "((Select TagId from Tags where TagName = 'Tag015'),15,20161203),\n" +
                "((Select TagId from Tags where TagName = 'Tag015'),15,20161204),\n" +
                "((Select TagId from Tags where TagName = 'Tag015'),15,20161205),\n" +
                "((Select TagId from Tags where TagName = 'Tag015'),15,20161206);");
        }


        System.out.println("Table filled");
    }

    public static void   ReadDB() throws ClassNotFoundException, SQLException
    {

        resultSet = statement.executeQuery("Select MAX(TagValues.iData) as Date, \n" +
                "       Tags.TagName as Name,\n" +
                "       sum(TagValues.Value) AS Value\n" +
                "       From TagValues LEFT OUTER JOIN Tags ON Tags.TagId = tagValues.TagId" +
                "       Where(TagValues.iData >= 20161201 and TagValues.iData <= 20161206)\n" +
                "       Group BY Tags.TagId\n" +
                "       ORDER BY Tags.TagID;");
        //String[][] data = new String[50][3];

      //  int i =0;
        System.out.println("||====================================================||");
        while(resultSet.next())
        {

            Integer date = resultSet.getInt("Date");
            String  name = resultSet.getString("Name");
            Double  value = resultSet.getDouble("Value");
   //         data[i][0] = date.toString();
   //         data[i][1] = name;
   //         data[i][2] = value.toString();

 //           i++;

            System.out.print( "|| Date = " + date + "  " );
            System.out.print( "| Name = " + name  + "  " );
            System.out.print( "| Value = " + value + "   ||"  );
            System.out.println();
        }
        System.out.println("||====================================================||");
          System.out.println("Table printed");
       // return data;
    }

    public static void closeDB() throws SQLException, ClassNotFoundException
    {
        connection.commit();
        connection.close();
        statement.close();
        resultSet.close();


        System.out.println("All connection closed");
    }
}