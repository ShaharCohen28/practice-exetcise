package StringPractice;

public class Strings5 {
    public static void main(String[] args) {
        int[] parts=new int[2];

        for (int number = 1; number <10_000 ; number++) {
            parts[0]=0;
            parts[1]=0;
            if(isKaprekar(number,parts)){
                System.out.printf("*** %d (%d^2 = %d) %d -- %d\n"
                        ,number, number,number*number,parts[0],parts[1]);
            }
        }
    }

    public static boolean isKaprekar(int num, int[] parts){
        int sqrNum=num*num, temp=sqrNum, digit, place=10;
        while(temp>0){
            parts[1]=sqrNum%place;
            parts[0]=sqrNum/place;
            if(parts[0]+parts[1]==num){
                return true;
            }
            place*=10;
            temp/=10;
        }
        return false;
    }
}
