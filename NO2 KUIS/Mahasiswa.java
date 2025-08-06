public class Mahasiswa implements Comparable<Mahasiswa> {
    String nama;
    int angkatan;
    double ipk;

    public Mahasiswa(String nama, int angkatan, double ipk){
        this.nama=nama;
        this.angkatan=angkatan;
        this.ipk=ipk;
    }

    public String getNama(){
        return nama;
    }

    public int getAngkatan(){
        return angkatan;
    }

    public double getIPK(){
        return ipk;
    }

    public String toString(){
        return "nama: "+nama+"\tangkatan: "+angkatan+"\tipk: "+ipk;
    }

    @Override
    public int compareTo(Mahasiswa other){
        
        if (this.ipk > other.ipk){
            return -1;
        }
        else if (this.ipk<other.ipk){
            return 1;
        }
        else{
            return 0;
        }

    }


}