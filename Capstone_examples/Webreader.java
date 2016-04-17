String html = "<p>An <a href='http://example.com/'><b>example</b></a> link.</p>";
Document doc = Jsoup.parse(html); 
String text = doc.body().text(); // "An example link"

Document doc = Jsoup.connect("http://www.uefa.com/uefa/aboutuefa/organisation/congress/news/newsid=1772321.html#uefa+moving+with+tide+history").get(); 
String textContents = doc.select(".newsText").first().text();
