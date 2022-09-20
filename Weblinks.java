import java.util.*; 
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


	public class Weblinks {
		
		public static void main(String[] args) {
			int count = 0;
			try {
				Document doc = Jsoup.connect("https://en.wikipedia.org/wiki/Wikipedia:Vital_articles/Level/5").maxBodySize(0).get();
				Elements links = doc.select("a[href][title]");
				for(Element page: links) {
					if(!page.attr("abs:href").toString().contains(("index.php?")) && 
							!page.attr("abs:href").toString().contains("User") &&
							!page.attr("abs:href").toString().contains("Template") &&
							!page.attr("abs:href").toString().contains("Special") &&
							!page.attr("abs:href").toString().contains("About") &&
							!page.attr("abs:href").toString().contains("Main_Page") &&
							!page.attr("abs:href").toString().contains("Most-referenced_articles")&&
							!page.attr("abs:href").toString().contains("shop.wikimedia.org")&&
							!page.attr("abs:href").toString().contains("Category") &&
							!page.attr("abs:href").toString().contains("Portal") &&
							!page.attr("abs:href").toString().contains("%") &&
							!page.attr("abs:href").toString().contains("Featured_content") &&
							!page.attr("abs:href").toString().contains("Good_articles") &&
							!page.attr("abs:href").toString().contains("Contents") &&
							!page.attr("abs:href").toString().contains("Contact_us") &&
							!page.attr("abs:href").toString().contains("Community_portal") &&
							!page.attr("abs:href").toString().contains("File_Upload_Wizard") &&
							!page.attr("abs:href").toString().contains("Help") &&
							!page.attr("abs:href").toString().contains("Privacy_policy") &&
							!page.attr("abs:href").toString().contains("ru.wikipedia.org")) {
								System.out.println(page.attr("abs:href").toString());
								count++;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			

			System.out.println("Total links: " + count);
		}	
	}