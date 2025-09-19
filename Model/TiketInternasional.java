package Model;

public class TiketInternasional extends Model {
    private String kategori = "Internasional";
    private String negaraTujuan;

    public TiketInternasional(String kode, String maskapai, String asal, String tujuan, String armada, String negaraTujuan) {
        super(kode, maskapai, asal, tujuan, armada);
        this.negaraTujuan = negaraTujuan;
    }

    @Override
    public String toString() {
        return super.toString() + " " + "Kategori: " + kategori + ", Negara Tujuan: " + negaraTujuan;
    }
    @Override
    public String getJenis() {
        return "Internasional";
    }    
}