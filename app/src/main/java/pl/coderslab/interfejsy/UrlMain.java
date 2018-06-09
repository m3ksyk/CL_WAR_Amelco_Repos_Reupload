package pl.coderslab.interfejsy;

public class UrlMain {
    public static void main(String[] args) {
        Url url = new StandardUrl();
        StandardUrl su1 = new StandardUrl();
        StandardUrl su2 = new StandardUrl();
        System.out.println(su1.getParam("param1","http://wp.pl?param2=hello&param1=catch"));
        System.out.println(su1.getParam("param2","http://wp.pl?param2=hello&param1=catch"));
        System.out.println(su1.getParam("param1","http://wp.pl?param2=hello&param1=catchIT"));

        ExtendedUrl eu1 = new ExtendedUrl();

        System.out.println(eu1.getParam("param1","url_example/param1.99/param2.string"));


    }
}
