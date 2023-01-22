import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;

public class Main {
	static final String DB_URL = "jdbc:mysql://localhost:3306/maveindbms3";
	static final String USER = "root";
	static final String PASS = "root";
	static void choicesFunction1() {

		System.out.println("***************************");
		System.out.println("Welcome...Please Select one of the following options:");
		System.out.println("1. connect to database");
		System.out.println("2. Read from Api");
		System.out.println("3. Read from API by Books class");
		System.out.println("4. Read from API by Auther class");
		System.out.println("5. Read from API by Artical class");
		System.out.println("6. Creat books table");
		System.out.println("7. Insert to Table books");
		System.out.println("8. create Authors Table");
		System.out.println("9. update from Table (domains based in id)");
		System.out.println("10. delete from Table web based in id");
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		Scanner sc = new Scanner(System.in);
		choicesFunction1();

		do {
			/// hibkjbjkjguj
			int userInput = sc.nextInt();
			switch (userInput) {
			case 1:
				// this class to connect eclipes with my database
				System.out.println("==========Connect to database===================");
				DemoConnectMysql connectToDatabse1 = new DemoConnectMysql();
				connectToDatabse1.conToDataBase();
				System.out.println("================================================");
				choicesFunction1();
				//
				break;

			case 2:
				System.out.println("==========Read Api from Artical Table===================");
	              
				URL url = new URL("https://api.nytimes.com/svc/search/v2/articlesearch.json?fq=romney&facet_field=day_of_week&facet=true&begin_date=20120101&end_date=20120101&api-key=IO0i2IlGBNmzuUbAmzcAPdzPH5LcPss2\r\n"
						+ "");
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.connect();
				StringBuilder informationString = new StringBuilder();
				int responseCode = conn.getResponseCode();
				if (responseCode != 200) {
					throw new RuntimeException("HttpresponseCode");

				}

				else {
					Scanner scanner = new Scanner(url.openStream());
					while (scanner.hasNext()) {
						informationString.append(scanner.nextLine());
					}
					scanner.close();

					System.out.println(informationString.toString());

				}
				
				
				System.out.println("==========Read Api from Authors Table===================");
				URL url1 = new URL("https://api.nytimes.com/svc/books/v3/reviews.json?author=Stephen+King&api-key=IO0i2IlGBNmzuUbAmzcAPdzPH5LcPss2\r\n"
						+ "");
				HttpURLConnection conn1 = (HttpURLConnection) url1.openConnection();
				conn1.setRequestMethod("GET");
				conn1.connect();
				StringBuilder informationString1 = new StringBuilder();
				int responseCode1 = conn.getResponseCode();
				if (responseCode1 != 200) {
					throw new RuntimeException("HttpresponseCode");

				}

				else {
					Scanner scanner = new Scanner(url1.openStream());
					while (scanner.hasNext()) {
						informationString1.append(scanner.nextLine());
					}
					scanner.close();

					System.out.println(informationString1.toString());

				}
				System.out.println("===========================================");
				
				
				
				System.out.println("==========Read Api from Section Books Table===================");
				URL url11 = new URL("https://api.nytimes.com/svc/topstories/v2/books.json?api-key=IO0i2IlGBNmzuUbAmzcAPdzPH5LcPss2\r\n"
						+ "");
				HttpURLConnection conn11 = (HttpURLConnection) url11.openConnection();
				conn11.setRequestMethod("GET");
				conn11.connect();
				StringBuilder informationString11 = new StringBuilder();
				int responseCode11 = conn.getResponseCode();
				if (responseCode1 != 200) {
					throw new RuntimeException("HttpresponseCode");

				}

				else {
					Scanner scanner = new Scanner(url11.openStream());
					while (scanner.hasNext()) {
						informationString11.append(scanner.nextLine());
					}
					scanner.close();

					System.out.println(informationString11.toString());

				}
				System.out.println("===========================================");
				choicesFunction1();
				
				
				break;
				
			case 3:
				System.out.println("==========Read from API by Books class===================");
				URL url111 = new URL("https://api.nytimes.com/svc/topstories/v2/books.json?api-key=IO0i2IlGBNmzuUbAmzcAPdzPH5LcPss2");
				HttpURLConnection conn111 = (HttpURLConnection) url111.openConnection();
				conn111.setRequestMethod("GET");
				conn111.connect();
				StringBuilder informationString111 = new StringBuilder();
				int responseCode111 = conn111.getResponseCode();
				if (responseCode111 != 200) {
					throw new RuntimeException("HttpresponseCode");

				}

				else {
					Scanner scanner = new Scanner(url111.openStream());
					while (scanner.hasNext()) {
						informationString111.append(scanner.nextLine());
					}
					scanner.close();
					Gson gson = new Gson();
					// System.out.println(informationString1.toString());
					Root apiResult = gson.fromJson(informationString111.toString(), Root.class);
					//Result[] apiResult1 = gson.fromJson(informationString111.toString(), Result[].class);
				
					
							//System.out.println("STATUS : " + apiResult.getStatus());
							for (int i=0; i<informationString111.length();i++) {
								
							System.out.println("Section : " + apiResult.getSection());
							System.out.println("Title : " + apiResult.getResults()[0].getTitle());
							System.out.println("Published_date :"+ apiResult.getResults()[0].getPublished_date());
							System.out.println("Des_facet :"+ apiResult.getResults()[0].getDes_facet());


		
							System.out.println("|" + " ***************************** " + "|");
							}
					
				}

				System.out.println("===========================================");
				choicesFunction1();
				break;
				
			case 4:
				System.out.println("==========Read from API by Authors class===================");
				URL url1111 = new URL("https://api.nytimes.com/svc/books/v3/reviews.json?author=Stephen+King&api-key=IO0i2IlGBNmzuUbAmzcAPdzPH5LcPss2");
				HttpURLConnection conn1111 = (HttpURLConnection) url1111.openConnection();
				conn1111.setRequestMethod("GET");
				conn1111.connect();
				StringBuilder informationString1111 = new StringBuilder();
				int responseCode1111 = conn1111.getResponseCode();
				if (responseCode1111 != 200) {
					throw new RuntimeException("HttpresponseCode");

				}

				else {
					Scanner scanner = new Scanner(url1111.openStream());
					while (scanner.hasNext()) {
						informationString1111.append(scanner.nextLine());
					}
					scanner.close();
					Gson gson = new Gson();
					// System.out.println(informationString1.toString());
					Root apiResult = gson.fromJson(informationString1111.toString(), Root.class);
					//Result[] apiResult1 = gson.fromJson(informationString111.toString(), Result[].class);
				
					
							//System.out.println("STATUS : " + apiResult.getStatus());
							for (int i=0; i<informationString1111.length();i++) {
								
							System.out.println("Book Authors : " + apiResult.getResults()[0].getBook_author());
							

		
							System.out.println("|" + " ***************************** " + "|");
							}
					
				}

				System.out.println("===========================================");
				choicesFunction1();
				break;
				
			case 5:
				System.out.println("==========Read from API by Articals class===================");
				URL url11111 = new URL("https://api.nytimes.com/svc/search/v2/articlesearch.json?fq=romney&facet_field=day_of_week&facet=true&begin_date=20120101&end_date=20120101&api-key=IO0i2IlGBNmzuUbAmzcAPdzPH5LcPss2\r\n"
						+ ""
						+ "");
				HttpURLConnection conn11111 = (HttpURLConnection) url11111.openConnection();
				conn11111.setRequestMethod("GET");
				conn11111.connect();
				StringBuilder informationString11111 = new StringBuilder();
				int responseCode11111 = conn11111.getResponseCode();
				if (responseCode11111 != 200) {
					throw new RuntimeException("HttpresponseCode");

				}

				else {
					Scanner scanner = new Scanner(url11111.openStream());
					while (scanner.hasNext()) {
						informationString11111.append(scanner.nextLine());
					}
					scanner.close();
					Gson gson = new Gson();
					// System.out.println(informationString1.toString());
					Artical apiResult1 = gson.fromJson(informationString11111.toString(), Artical.class);
					//Result[] apiResult1 = gson.fromJson(informationString111.toString(), Result[].class);
					
					
							//System.out.println("STATUS : " + apiResult.getStatus());
							for (int i=0; i<=apiResult1.getResponse().getdocs().length;i++) {
								
							System.out.println("pub_date : "+apiResult1.getResponse().getdocs()[0].getPub_date());
							System.out.println("Document_type : "+apiResult1.getResponse().getdocs()[0].getDocument_type());
							System.out.println("Section_name : "+apiResult1.getResponse().getdocs()[0].getSection_name());
							System.out.println("Subsection_name : "+apiResult1.getResponse().getdocs()[0].getSubsection_name());
							System.out.println("fIRST name : "+apiResult1.getResponse().getdocs()[0].getByline().getperson()[0].getFirstname());
							System.out.println("last name : "+apiResult1.getResponse().getdocs()[0].getByline().getperson()[0].getMiddlename());
							System.out.println("|" + " ***************************** " + "|");
							}
					
				}

				System.out.println("===========================================");
				choicesFunction1();
				break;
				
			case 6:
				System.out.println("==========Create books Table===================");
				CrateAllTable CreateAllTable = new CrateAllTable();
				CreateAllTable.CreateTableToDB();
				System.out.println("================================================");
				choicesFunction1();
				break;
			
			case 7:
				System.out.println("==========Insert to  books Table===================");
				URL url111111 = new URL("https://api.nytimes.com/svc/topstories/v2/books.json?api-key=IO0i2IlGBNmzuUbAmzcAPdzPH5LcPss2");
				HttpURLConnection conn111111 = (HttpURLConnection) url111111.openConnection();
				conn111111.setRequestMethod("GET");
				conn111111.connect();
				StringBuilder informationString111111 = new StringBuilder();
				int responseCode111111 = conn111111.getResponseCode();
				if (responseCode111111 != 200) {
					throw new RuntimeException("HttpresponseCode");

				}

				else {
					Scanner scanner = new Scanner(url111111.openStream());
					while (scanner.hasNext()) {
						informationString111111.append(scanner.nextLine());
					}
					scanner.close();
					Gson gson = new Gson();
					// System.out.println(informationString1.toString());
					Root apiResult = gson.fromJson(informationString111111.toString(), Root.class);
					for (int i=0; i<=apiResult.getSection().length();i++) {
				
						
						String Section = apiResult.getSection();
						String Title = apiResult.getResults()[0].getTitle();
						String Published_date = apiResult.getResults()[0].getPublished_date();
						ArrayList<String> Des_facet = apiResult.getResults()[0].getDes_facet();
						

						Class.forName("com.mysql.cj.jdbc.Driver");
						String url1111111= "jdbc:mysql://localhost:3306/maveindbms3";
						String username = "root";
						String password = "root";

						Connection con1 = DriverManager.getConnection(url1111111, username, password);
						int id = 1;

						if (con1 != null) {
							String SQLqueryForInserting = "insert into books(Section,Title, Published_date,Des_facet)"
									+ " values('" + Section + "' ,'" + Title + "', '" + Published_date
									+ "','" + Des_facet +  "')";
							Statement st = con1.createStatement();
							//
							// Executing query
							int m = st.executeUpdate(SQLqueryForInserting);
							if (m >= 1) {
								System.out.println("inserted successfully : " + SQLqueryForInserting);

							} else {
								System.out.println("insertion failed");

								// Closing the connections
							}

						}

					}
				}

				
				break;
				
			case 8:
				System.out.println("==========Create Authors Table===================");
				try (Connection conn1111111 = DriverManager.getConnection(DB_URL, USER, PASS);
						Statement stmt = conn1111111.createStatement();) {
					String sql = "CREATE TABLE BookAuthor " + "(id int NOT NULL AUTO_INCREMENT, "
							+ " Book_author   VARCHAR(100) not NULL, " +
							" PRIMARY KEY ( id ))";
					String sql1 = "ALTER TABLE books AUTO_INCREMENT=1";
					stmt.executeUpdate(sql);
					stmt.executeUpdate(sql1);

					System.out.println(true + "===>Created Authors Table table in given database...");

				} catch (SQLException e) {
					System.out.println("Table Authors Table Already Build");
					System.out.println("***********************************");
				}
				
				break;
				
			}
		} while (true);
	}
}
