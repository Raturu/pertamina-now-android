package com.raturu.pertaminanow.data.source.remote.response

import com.google.gson.annotations.SerializedName
import com.raturu.pertaminanow.data.model.Location
import com.raturu.pertaminanow.data.model.Promo
import com.raturu.pertaminanow.data.model.Spbu
import com.raturu.pertaminanow.data.source.remote.toDate

/**
 * Created on : April 20, 2018
 * Author     : zetbaitsu
 * Name       : Zetra
 * GitHub     : https://github.com/zetbaitsu
 */
data class GetPromosResponse(
        @SerializedName("id_promo") val idPromo: String,
        @SerializedName("id_spbu") val idSpbu: String,
        @SerializedName("no_spbu") val noSpbu: String,
        @SerializedName("nama_spbu") val namaSpbu: String,
        @SerializedName("alamat_spbu") val alamatSpbu: String,
        @SerializedName("kota_spbu") val kotaSpbu: String,
        @SerializedName("provinsi_spbu") val provinsiSpbu: String,
        @SerializedName("latitude") val latitude: Double,
        @SerializedName("longitude") val longitude: Double,
        @SerializedName("poin") val poin: Int,
        @SerializedName("jumlah_prmo") val jumlahPrmo: Int,
        @SerializedName("used") val used: Int,
        @SerializedName("waktu_mulai") val waktuMulai: String,
        @SerializedName("waktu_selesai") val waktuSelesai: String,
        @SerializedName("judul") val judul: String,
        @SerializedName("deskripsi") val deskripsi: String,
        @SerializedName("gambar") val gambar: String,
        @SerializedName("id_kategori") val idKategori: String,
        @SerializedName("kategori") val kategori: String
) {
    fun toPromoModel(): Promo = Promo(
            idPromo,
            Promo.Category(idKategori, kategori),
            judul,
            deskripsi,
            gambar,
            waktuMulai.toDate(),
            waktuSelesai.toDate(),
            Spbu(idSpbu, namaSpbu, Location(alamatSpbu, kotaSpbu, provinsiSpbu, latitude, longitude)),
            poin
    )
}