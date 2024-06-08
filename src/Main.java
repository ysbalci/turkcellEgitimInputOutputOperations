import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Streamler veri akışını temsil eder.
        //Veri okumak için giriş(input) streami, veri almak için çıkış(output) streami kullanılır
        //Bilgi almak için program kaynağa bir stream açar
        //Bilgi göndermek için program hedefe bir bir stream açar ve bilgiyi yazar
        //Java da veri ile çalışmak için 2 tip stream sınıfı bulunur
            //1-Yüksek seviyeli karakter tabanlı soyut sınıflar
                // Reader and Writer
            //2-Düşük seviyeli byte tabanlı soyut sınıflar
                // InputStream and OutputStream,
        //Veri okuma-yazma algoritrması;
        /* Stream açılır
            While içerisinde akış sonuna kadar okuma-Yazma işlemi yaptırılır
            Stream kapatılır
        */

        //yaz();
        oku();


    }
    public static void yaz() {
        //Erişmek istediğimiz kaynağı tanıtmak için file nesnesi kullanılır.
        File file = new File("hello.txt");
        //Uygulamadan dışarı doğru bir stream olıuşturucaz
        //FileOutpuStream sınıfı bir checked exception bulundurduğu için try-catch blogu içerisinde instance alma işlemi gercekleştirilir
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            // low level bir işlem yani byte tabanalı yazma ve okuma işlemi yapıyoruz / veri gönderiyoruz
            fileOutputStream.write("Merhaba".getBytes());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            //fileoutputstream null değilse yani oluşturmada bir sorun yoksa kapatama işlemini gerçekleştirdik
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void oku(){
        File file = new File("hello.txt");
        FileInputStream fileInputStream=null;
        try {
            fileInputStream = new FileInputStream(file);
            int c = 0;
            while ((c=fileInputStream.read())!= -1){
                System.out.print((char)c);
            }

        }catch (IOException e){
            System.out.println(e.getMessage());
        } finally {
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}