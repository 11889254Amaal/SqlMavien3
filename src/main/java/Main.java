import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.util.Scanner;

import com.google.gson.Gson;

public class Main {
	static void choicesFunction1() {

		System.out.println("***************************");
		System.out.println("Welcome...Please Select one of the following options:");
		System.out.println("1. connect to database");
		System.out.println("2. Read from Api");
		System.out.println("3. Read from API by class");
		System.out.println("4. Creat all table");
		System.out.println("5. Insert to Table");
		System.out.println("6. Read from Table");
		System.out.println("7. update from Table (domains based in id)");
		System.out.println("8. delete from Table web based in id");
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
				System.out.println("==========Get api from URL===================");
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

	//						System.out.println("state_province : " + x.getPublished_date());
//							System.out.println("alpha_two_code : " + x.getPublished_date());
//							System.out.println("name : " + x.getTitle());
		
							System.out.println("|" + " ***************************** " + "|");
							}
					
				}

				System.out.println("===========================================");
				choicesFunction1();
				break;
				
			}
		} while (true);
	}
}
