String html = "<p>An <a href='http://example.com/'><b>example</b></a> link.</p>";
Document doc = Jsoup.parse(html); 
String text = doc.body().text(); // "An example link"
