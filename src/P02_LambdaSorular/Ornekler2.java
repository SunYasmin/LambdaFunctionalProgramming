package P02_LambdaSorular;

import P01_LambdaGiris.Utils_MethodClass;

import java.util.stream.IntStream;

public class Ornekler2 {
    public static void main(String[] args) {

        System.out.println(get7den100eToplam());
        System.out.println(get2den11eCarpim());
        System.out.println(faktoriyelHesapla(5));
        System.out.println(verilenIkiSayiArasindakiCiftSayilarinToplami(5, 9));
        System.out.println(ikiSayiArasindakiTumSayilarinRakamlariToplami(10, 12));
    }

//1) 7'den 100'e kadar integer değerlerinin toplamını bulan bir method oluşturun.

    public static int get7den100eToplam() {   //IntStream   bu bir Interface

        return IntStream.range(7, 101).reduce(0, Math::addExact);  // get olmadi diye getli de olur

        //return IntStream.range(7,101).reduce(Math::addExact).getAsInt(); // getAsInt  ile getle aliriz

        //return IntStream.rangeClosed(7,100).reduce(Math::addExact).getAsInt(); // rangeClosed()  ikisi de dahil
    }

    //2) 2'den 11'e kadar integer değerlerinin çarpımını bulan bir method oluşturun.

    public static int get2den11eCarpim() {

        return IntStream.rangeClosed(2, 11).reduce(Math::multiplyExact).getAsInt();
    }

    //3) Verilen bir sayının faktoriyelini hesaplayan bir method oluşturun. (5 factorial = 1*2*3*4*5  ==> 5! = 1*2*3*4*5)

    public static int faktoriyelHesapla(int x) {// method parantezine kaca kadarsa kac fakoriyel yazilir

        if (x > 0) {

            return IntStream.rangeClosed(1, x).reduce(Math::multiplyExact).getAsInt();  // sayi15 olunca calismaz faktoriyeli int siniri disinda

        }  // return yaptiysa yukarda else gerek yok alttaki return break gibi calisir
        System.out.println("0'dan buyuk deger giriniz");

        return 0;// bisey donsun donmek orunda hata vermesin

    }

    //4) Verilen iki sayı arasındaki çift sayıların toplamını bulan bir method oluşturun.

    public static int verilenIkiSayiArasindakiCiftSayilarinToplami(int x, int y) {  // ya y kucukse
        //kucukten buyuge gidiyor tersi degil

        if (x > y) {
            x += y;
            y = x - y;
            x = x - y;
        }

        return IntStream.rangeClosed(x, y).filter(Utils_MethodClass::ciftElemaniSec).sum();



    }

//5) Verilen iki sayı arasındaki tüm sayıların rakamlarının toplamını hesaplayan bir method oluşturun.
    //  23 and 32 ==> 2+3  +  2+4  +  2+5  +  2+6  +  2+7  +   2+8  +   2+9  +   3+0  +   3+1  +   3+2 ==> 68

    public static int ikiSayiArasindakiTumSayilarinRakamlariToplami(int x, int y) {


        if (x > y) {
            x += y;
            y = x - y;
            x = x - y;


        }
        return IntStream.rangeClosed(x, y).map(Utils_MethodClass::rakamlarToplaminiAl).sum();  //ınt value yok sum yazana kadar
        // sum IntStream de daginik olarak gelen rakamlar toplamini aldi topladi
    }





}
