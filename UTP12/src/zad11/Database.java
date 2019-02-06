package zad11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	private Connection connection;
	private TravelData travelData;
	private static String driverName = "org.apache.derby.jdbc.EmbeddedDriver";
	private String url;
	private Integer id = 1;
	
	public Database(String url, TravelData travelData) {
		this.url = url;
		this.travelData = travelData;
	}

	public void create() {
		try {
			Class.forName(driverName);
			connection = DriverManager.getConnection(url);
			if(connection != null) {
				System.out.println();
				System.out.println("Connected to derby!");
			}
		} catch (SQLException e) {
			System.err.println("Connection with DB exe");
			System.exit(2);
		} catch (ClassNotFoundException e) {
			System.err.println("Driver Class not found");
			e.printStackTrace();
			System.exit(2);
		}
		
		try {
			connection.createStatement().execute("CREATE TABLE Oferta("
					+ "id int PRIMARY KEY, "
					+ "kraj varchar(40), "
					+ "data_wyjazdu Date, "
					+ "data_powrotu Date, "
					+ "miejsce varchar(20), "
					+ "cena varchar(20), "
					+ "symbol_waluty varchar(10))"
					);
			
			for (String line : travelData.getResList()) {
				String[] tokens = line.split("\\t");
				connection.createStatement().execute(
						"INSERT INTO Oferta(id, kraj, data_wyjazdu, data_powrotu, miejsce, cena, symbol_waluty) VALUES "
						+ "("+id+", "+"'"+tokens[0]+"', " + "'"+tokens[1]+"', " + "'"+tokens[2]+"', " + "'"+tokens[3]+"'," + "'"+tokens[4]+"', " + "'"+tokens[5]+"')"
						);
				
				id++;
			}
			
		} catch (SQLException e) {
			System.err.println("DDL&DML exe");
			e.printStackTrace();
		}
	}

	public void show() {
		Statement statment;
		
		try {
			statment = connection.createStatement();
			ResultSet resSet = statment.executeQuery("SELECT * FROM Oferta");
			ResultSetMetaData resMeta = resSet.getMetaData();
			int columnCount = resMeta.getColumnCount();
			
			for (int i = 1; i <= columnCount; i++)
				System.out.format("%20s", resMeta.getColumnName(i) + " | ");
			
			while(resSet.next()) {
				System.out.println("");
				for (int i = 1; i <= columnCount; i++)
					System.out.format("%20s", resSet.getString(i) + " | ");
			}
			
			statment.close();
			connection.close();
		} catch (SQLException e) {
			System.err.println("Show data exe");
			e.printStackTrace();
			System.exit(2);
		}	
	}
}
