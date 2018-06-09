public class NWD {

    public int greatestCommonDivisor(int x, int y) {
        int gdc = 0;
        if( x < 0 || y < 0){
            throw new IllegalArgumentException("can't be less than zero");
        }
        else {
            while (y != x) {
                if(x > y){
                    x = x - y;
                }
                else{
                    y= y -x;
                }
                gdc = x;

            }
        }

        return gdc;
    }
}
