import java.io.IOException;
import java.net.URI;
import java.util.Scanner;

class Handler implements URLHandler {

    String keyword;
    Scanner searchInput = new Scanner(System.in);
    int num = 0;
    int num2 = 0;
    String[] keyWordlist;
    String newKeyword;
    /* (non-Javadoc)
     * @see URLHandler#handleRequest(java.net.URI)
     */
    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            return String.format("Welcome to the Simple Search Engine!!!");

        } else if (url.getPath().equals(keyWordlist[0])) {
            keyword = keyWordlist[0];
            return String.format(keyword);
        } else if (url.getPath().equals(keyWordlist[1])) {
            keyword = keyWordlist[1];
            return String.format(keyword);
        } else if (url.getPath().equals("/dapple")) {
            keyword = "dapple";
            return keyword;
        } else{
                System.out.println("Path: " + url.getPath());
                if (url.getPath().contains("/add")) {
                    String[] parameters = url.getQuery().split("=");
                    if (parameters[num].equals("newKeyword")) {
                        newKeyword = String.format(parameters[num+1]);
                        return String.format("A New Keyword Has Been Added: s%.", parameters[num+1]); 

                    }

                }
            }
                return "404 Not Found!";
        }
    }

class SimpleSearch {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
