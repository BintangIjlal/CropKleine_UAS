package com.pnj.cropexchange.product

data class Product(
    var berat: String?= null,
    var deskripsi: String?= null,
    var gambar: String?= null,
    var harga: String?= null,
    var kategori: String?= null,
    var nama_product: String?= null,
    var pemilik: String?= null,
    var stok: String?= null,
    var tanggal_ditambahkan: String?= null,
){
    constructor(): this("","","","","","","","","")
}