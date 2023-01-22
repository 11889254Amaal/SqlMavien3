import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Root {
	  public String status;
	    public String copyright;
	    public String section;
	    public Date last_updated;
	    
	    
	    
	    public Result[] getResults() {
			return results;
		}
		public void setResults(Result[] results) {
			this.results = results;
		}

		public Result[] results;
	    public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getCopyright() {
			return copyright;
		}
		public void setCopyright(String copyright) {
			this.copyright = copyright;
		}
		public String getSection() {
			return section;
		}
		public void setSection(String section) {
			this.section = section;
		}
		public Date getLast_updated() {
			return last_updated;
		}
		public void setLast_updated(Date last_updated) {
			this.last_updated = last_updated;
		}
		public int getNum_results() {
			return num_results;
		}
		public void setNum_results(int num_results) {
			this.num_results = num_results;
		}
		
		public int num_results;
		


	
	

	

}
