package NadimIF4A.example.pertemuan7.models;

import android.os.Parcel;
import android.os.Parcelable;

public class food implements Parcelable {
    private int id;
    private String nama;
    private String deskripsi;
    private String kategori;
    private int thumbnail;
    private String lokasi;
    private int vote;
    private float rate;
    private String tanggalRilis;

    //Generate Konstruktor wajib untuk Parcelable
    public food() {
    }

    protected food(Parcel in) {
        id = in.readInt();
        nama = in.readString();
        deskripsi = in.readString();
        kategori = in.readString();
        thumbnail = in.readInt();
        lokasi = in.readString();
        vote = in.readInt();
        rate = in.readFloat();
        tanggalRilis = in.readString();
    }

    public static final Creator<food> CREATOR = new Creator<food>() {
        @Override
        public food createFromParcel(Parcel in) {
            return new food(in);
        }

        @Override
        public food[] newArray(int size) {
            return new food[size];
        }
    };

    //Generate Setter Getter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public String getTanggalRilis() {
        return tanggalRilis;
    }

    public void setTanggalRilis(String tanggalRilis) {
        this.tanggalRilis = tanggalRilis;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(nama);
        parcel.writeString(deskripsi);
        parcel.writeString(kategori);
        parcel.writeInt(thumbnail);
        parcel.writeString(lokasi);
        parcel.writeInt(vote);
        parcel.writeFloat(rate);
        parcel.writeString(tanggalRilis);
    }
}
