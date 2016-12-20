import java.io.*;
import java.util.LinkedList;

public class Parser {

  public LinkedList<Movie> getMovies(String filename) {
    LinkedList<Movie> movies = new LinkedList<Movie>();
    String[] html = htmlToString(filename);


    for(int i = 0; i != html.length; i++) {
      if(html[i].startsWith("<span class=\"lister-item-year text-muted unbold\">")) {
        System.out.println(html[i]);
      }
    }

    return movies;
  }

  private String[] htmlToString(String filename) {
    StringBuilder contentBuilder = new StringBuilder();
    try {
      BufferedReader in = new BufferedReader(new FileReader(filename));
      String str;
      while ((str = in.readLine()) != null) {
        contentBuilder.append(str);
      }
      in.close();
    } catch (IOException e) { }

    String rawText = contentBuilder.toString();
    return rawText.split("\n");
  }


  public static void main(String[] args) {
    Parser parser = new Parser();
    parser.getMovies(args[0]);
  }
}
