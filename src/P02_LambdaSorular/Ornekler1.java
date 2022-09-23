package P02_LambdaSorular;

import P01_LambdaGiris.Utils_MethodClass;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ornekler1 {

    public static void main(String[] args) {

        List<String> liste = new ArrayList<>();
        liste.add("Ali");
        liste.add("Ali");
        liste.add("Mark");
        liste.add("Amanda");
        liste.add("Christopher");
        liste.add("Jackson");
        liste.add("Mariano");
        liste.add("Alberto");
        liste.add("Tucker");
        liste.add("Benjamin");
        System.out.println(liste);

        buyukHarfleYazdir(liste);
        System.out.println();
        // buyukHarfleYazdir2(liste);
        uzunlugaGoreYazdir(liste);
        System.out.println();
        uzunlugunaGoreTersYazdir(liste);
        System.out.println();
        sonKaraktereGoreTekrarsizYazdir(liste);
        System.out.println();
        uzunlukVeIlkHarfeGoreSiralaYazdir(liste);
        System.out.println();
        //bestenBuyukleriSil(liste);
        System.out.println();      // STRİNG MUTABLE OLDUGU İCİN SİLDİM KALICI DEGISIKLIK
        //baslangiciAYadaSonuNOlaniSil01(liste);
        System.out.println();
        //baslangiciAYadaSonuNOlaniSil02(liste);
        //uzunlugu8ile10arasiOileBiteniSil(liste);
        System.out.println("uzunlugu12denAzmi :" + uzunlugu12denAzmi(liste));
        System.out.println("xIleBaslamiyorMu :" + xIleBaslamiyorMu(liste));
        System.out.println("rIleBitiyorMu :" + rIleBitiyorMu(liste));




    }

//1) Tüm elemanları büyük harf ile yazdıran bir method oluşturun.

    public static void buyukHarfleYazdir(List<String>list) {

        list.stream().map(String::toUpperCase).forEach(Utils_MethodClass::ayniSatirdaBosluklaYazdir);
    }

    /*public static void buyukHarfleYazdir2(List<String> list){

        list.replaceAll(String::toUpperCase);  // Bu kalici degistiriyorrrrr  stream kullanmadigim icin forEach alamiyorum
        System.out.println(list);  // String mutable degistirilebilir kalici oldu


    }*/
//2) Elemanları uzunluklarına göre sıralayıp yazdıran bir method oluşturun
    public static void uzunlugaGoreYazdir(List<String> list){

        list.stream().sorted(Comparator.comparing(String::length)).forEach(Utils_MethodClass::ayniSatirdaBosluklaYazdir);
        //sorted yazmazsam sadece alfabetik siralar
        //Comparator.comparing()  bu sekilde method
        //siralama kosulum bu Comparator.comparing(String::length) buna gore sort yap

    }

    //3) Elemanları uzunluklarına göre ters sıralayıp yazdıran bir method oluşturun.
    public static void uzunlugunaGoreTersYazdir(List<String> list){

        list.stream().sorted(Comparator.comparing(String::length).reversed()).forEach(Utils_MethodClass::ayniSatirdaBosluklaYazdir);
    }

//4) Elemanları son karakterlerine göre sıralayıp tekrarsız yazdıran bir method oluşturun.

    public static void sonKaraktereGoreTekrarsizYazdir(List<String> list){

        list.stream().distinct().sorted(Comparator.comparing(Utils_MethodClass::sonKarakteriiAl)).forEach(Utils_MethodClass::ayniSatirdaBosluklaYazdir);
//once son karakter sonra eklenme sirasina gore yaziyor
    }

    //5) Elemanları önce uzunluklarına göre ve sonra ilk karakterine göre sıralayıp yazdıran bir method oluşturun.
    public static void uzunlukVeIlkHarfeGoreSiralaYazdir(List<String> list){  //kendi icinde siralama arka arkaya sirayla

        list.stream().distinct().sorted(Comparator.comparing(String::length).thenComparing(Utils_MethodClass::ilkKarakteriAl)).
                forEach(Utils_MethodClass::ayniSatirdaBosluklaYazdir);
        //ilk olcutum uzunluk sonra ilk harf sonra eklemme sirasiiiiiii

//thenComparing() :==>siralama icin 2. bir kosul daha belirtir

    }
//6) Uzunluğu 5'ten büyük olan elemanları silen bir method oluşturun.
/*public static void bestenBuyukleriSil(List<String> list){

        list.removeIf(t->t.length()>5);//stream() yazinca remove delete gelmiyor yazilmazzzzz
                                    // stream in yazilmadigi yerlerden biri silme

        System.out.println(list);
//NOOOOOTTT  LİST KALİCİ DEGİSTİİİİİ
//eger filter ile yaparsam baska liste atayip list e eklemeliyim
//List mutable oldugu icin elemanlari islem sonrasi kalici degistiginden comment-out yorum yapiyorum
}*/

    //7) ‘A’, ‘a’ ile başlayan yada ‘N’, ‘n’ ile biten elemanları silen bir method oluşturun.
    public static void baslangiciAYadaSonuNOlaniSil01(List<String> list) {
        //1.yollll
        //remove if() kosul dogruysa true ise sil

        list.removeIf(t->t.charAt(0) == 'A' || t.charAt(0) == 'a' || t.charAt(t.length()-1)=='N' || t.charAt(t.length()-1)=='n');
        System.out.println(list);



    }
    //2. yol
    public static void baslangiciAYadaSonuNOlaniSil02(List<String> list){

        list.removeIf(t->t.startsWith("A")||t.startsWith("a")||t.endsWith("N")||t.endsWith("n"));
        System.out.println(list);


    }

//8) Uzunluğu 8 ile 10 arası olan yada 'o' ile biten elemanları silen bir method oluşturun.
    // soruda ekstra bir bilgi verilmiyorsa 8 ve 10 dahildirr******

  /*  public static void uzunlugu8ile10arasiOileBiteniSil(List<String> list){

        list.removeIf(t->(t.length()>7 && t.length()<11) || (t.endsWith("o")));
        System.out.println(list);

    }*/

//9) Tüm elemanların uzunluklarının 12'den az olup olmadığını kontrol eden bir method oluşturun.

    public static boolean uzunlugu12denAzmi(List<String> list){
        return list.stream().allMatch(t->(t.length()<12));   // anyMatch  herhangi biri 12 den kucukse ama hepsi 12 den kucukse true olacak
// bu ifade t  f verdigi icin  return   removeIf almadik tek tek alir o

    }

    //10) Hiçbir elemanın 'X' ile başlamadığını kontrol eden bir method oluşturun.

    public static boolean xIleBaslamiyorMu(List<String> list){  // baslamadigini kontrol ediyorum

        return list.stream().noneMatch(t->(t.startsWith("X")));           //burda bir daha konteyner tanimlayip return u altta yazmama gerek yok
        // string buyuk kucuk duyarliligina sahiptir case sensitive
    }

//11) Herhangi bir elemanın 'r' ile bitip bitmediğini kontrol eden bir method oluşturun.

    public static boolean rIleBitiyorMu(List<String> list){

        return list.stream().anyMatch(t->(t.endsWith("r")));


    }



}
