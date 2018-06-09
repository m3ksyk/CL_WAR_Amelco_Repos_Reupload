
public class Main13 {

    public static void main(String[] args) {
        int points = 80;
        //zadanie wykonałem na dwa sposoby:

        //SPOSÓB 1: pętle if .. else if
        System.out.println("ilość punktów " + points);
        if(points < 0) {
            System.out.println("Ilość punktów nie może być mniejsza niż 0");
        }
        else if(points > 100){
            System.out.println("ilość punktów większa niż 100");
        }
        else if(points <= 39){
            System.out.println("ocena niedostateczna");
        }
        else if(points <=54){
            System.out.println("ocena dopuszczająca");
        }
        else if(points <=69){
            System.out.println("ocena dostateczna");
        }
        else if(points <=84){
            System.out.println("ocena dobra");
        }
        else if(points <=98){
            System.out.println("ocena bardzo dobra");
        }
        else {
            System.out.println(" ocena celująca");
        }

        //SPOSÓB 2 : pętle if .. else if + switch
        String mark;
        int result = 0;

        if(points < 0) {
            System.out.println("Ilość punktów nie może być mniejsza niż 0");
        }
        else if(points > 100){
            System.out.println("ilość punktów większa niż 100");
        }
        else if(points <= 39){
            result = 1;
        }
        else if(points <=54){
            result = 2;
        }
        else if(points <=69){
            result = 3;
        }
        else if(points <=84){
            result = 4;
        }
        else if(points <=98){
            result = 5;
        }
        else {
            result = 6;
        }

        switch (result){
            case 1: mark = "niedostateczna";
                break;
            case 2: mark = "dopuszczająca";
                break;
            case 3: mark = "dostateczna";
                break;
            case 4: mark = "dobra";
                break;
            case 5: mark = "bardzo dobra";
                break;
            case 6: mark = "celująca";
                break;
            default : mark = "błędna liczba punktów";
                break;
        }
        System.out.println("ocena " + mark);

    }

}
