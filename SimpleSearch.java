import java.io.IOException;
import java.net.URI;

class Handler implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.
    String keyword;
    int num = 0;
    //int num2;
    String[] wordlist = new String[] {"football", "soccer", "basketball"};
    String newKeyword;
    /* (non-Javadoc)
     * @see URLHandler#handleRequest(java.net.URI)
     */
    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            return String.format("Simple Search Engine");

        } else if (url.getPath().equals(wordlist[0])) {
            keyword = wordlist[0];
            return String.format(keyword);
        } else if (url.getPath().equals(wordlist[1])) {
            keyword = wordlist[1];
            return String.format(keyword);
        } else if (url.getPath().equals("/testword")) {
            keyword = "test";
            return keyword;
        } 
        else {
                System.out.println("Path: " + url.getPath());
                if (url.getPath().contains("/add")) {
                    String[] parameters = url.getQuery().split("=");
                    if (parameters[num].equals(newKeyword)) {
                        newKeyword = String.format(parameters[num+1]);
                        return String.format("New search added", parameters[num+1]); 

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
