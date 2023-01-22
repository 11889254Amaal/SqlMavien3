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
		System.out.println("3. Read from API by Books class");
		System.out.println("4. Read from API by Auther class");
		System.out.println("5. Read from API by Artical class");
		System.out.println("6. Creat all table");
		System.out.println("7. Insert to Table");
		System.out.println("8. Read from Table");
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
							System.out.println(    "created_date :"+ apiResult.getResults()[0].getPublished_date());
							System.out.println(    "created_date :"+ apiResult.getResults()[0].getDes_facet());


		
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
				System.out.println("==========Read from API by Authors class===================");
				URL url11111 = new URL("https://api.nytimes.com/svc/search/v2/articlesearch.json?fq=romney&facet_field=day_of_week&facet=true&begin_date=20120101&end_date=20120101&api-key=IO0i2IlGBNmzuUbAmzcAPdzPH5LcPss2\r\n"
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
							for (int i=0; i<informationString11111.length();i++) {
								
							System.out.println("pub_date : "+apiResult1.getResponse().getdocs()[0].getPub_date());
							System.out.println("Document_type : "+apiResult1.getResponse().getdocs()[0].getDocument_type());
							System.out.println("Section_name : "+apiResult1.getResponse().getdocs()[0].getSection_name());
							System.out.println("Subsection_name : "+apiResult1.getResponse().getdocs()[0].getSubsection_name());
							System.out.println("fIRST name : "+apiResult1.getResponse().getdocs()[0].getByline().getperson()[0].getFirstname());
		
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
