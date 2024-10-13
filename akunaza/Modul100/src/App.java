class Mahasiswa {
    String Nama;
    int Usia;

    Mahasiswa (String Nama, int Usia) {
        this.Nama= Nama;
        this.Usia= Usia;
    }
    void Name () {
        System.out.println("Nama: "+ this.Nama);
        System.out.println("Usia: "+ this.Usia);
    }
  
 }
        public class App {
            public static void main(String[] args) {
                Mahasiswa mahasiswa1= new Mahasiswa("Fayyadl", 12);
                mahasiswa1.Name();
                Mahasiswa mahasiswa2= new Mahasiswa("Ireng bogor", 78);
                mahasiswa2.Name();
    }
}