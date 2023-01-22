import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CrateAllTable {
	static final String DB_URL = "jdbc:mysql://localhost:3306/maveindbms3";
	static final String USER = "root";
	static final String PASS = "root";

	public boolean CreateTableToDB() {
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();) {
			String sql = "CREATE TABLE books " + "(id int NOT NULL AUTO_INCREMENT, "
					+ " Section   VARCHAR(100) not NULL, " + " Title VARCHAR(100) , "
					+ " Published_date VARCHAR(100) , " + " Des_facet  VARCHAR(10000)  , " +
					" PRIMARY KEY ( id ))";
			String sql1 = "ALTER TABLE books AUTO_INCREMENT=1";
			stmt.executeUpdate(sql);
			stmt.executeUpdate(sql1);

			System.out.println(true + "===>Created books Table table in given database...");

		} catch (SQLException e) {
			System.out.println("Table Web Table Already Build");
			System.out.println("***********************************");
		}
		return false;
	}
}
