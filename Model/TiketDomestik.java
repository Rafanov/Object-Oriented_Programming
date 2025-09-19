package Model;

public class TiketDomestik extends Model {
    private String kategori = "Domestik";

    public TiketDomestik(String kode, String maskapai, String asal, String tujuan, String armada) {
        super(kode, maskapai, asal, tujuan, armada);
    }

    @Override
    public String toString() {
        return super.toString() + " " + " Kategori: " + kategori;
    }
    
    @Override
    public String getJenis() {
        return "Domestik";
    }
}