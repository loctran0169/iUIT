package vn.edu.uit.managementforstudents.module.models

import android.content.Context

val MSSV = "MSSV"
val HOTEN = "HOTEN"
val NGAYSINH = "NGAYSINH"
val GIOITINH = "GIOITINH"
val DIACHI = "DIACHI"
val SDT = "SDT"
val EMAIL = "EMAIL"
val NGANH = "NHANH"
val LOP = "LOP"
val FACEBOOK = "FACEBOOK"
val AVATAR = "AVATAR"

class MysharedPreferences(context: Context) {
    private val APP_NAME = "IUIT"
    val getShare = context.getSharedPreferences(APP_NAME, Context.MODE_PRIVATE)

    fun save(KEY_NAME: String, text: String) {
        val editor = getShare.edit()
        editor.putString(KEY_NAME, text)
        editor.apply()
    }

    fun removeValue(KEY_NAME: String) {

        val editor = getShare.edit()
        editor.remove(KEY_NAME)
        editor.apply()
    }

    fun removeAll() {
        val editor = getShare.edit()
        editor.clear()
        editor.apply()
    }

    fun saveData(data: ThongTinSinhVien) {
        val put = getShare.edit()
        put.putString(MSSV, data.maSinhVien)
        put.putString(HOTEN, data.hoTen)
        put.putString(EMAIL, data.email)
        put.putString(AVATAR, data.avatar)
        put.putString(NGAYSINH, data.ngaySinh)
        put.putString(GIOITINH, data.gioiTinh)
        put.putString(DIACHI, data.diaChi)
        put.putString(SDT, data.sdt)
        put.putString(EMAIL, data.email)
        put.putString(FACEBOOK, data.facebook)
        put.putString(NGANH, data.nganh)
        put.apply()
    }

    fun getStringValue(name : String) : String?{
        return getShare.getString(name, null)
    }

    fun loadData(): ThongTinSinhVien? {
        val data = ThongTinSinhVien(null, null, null, null, null, null, null, null, null, null, "")
        data.maSinhVien = getShare.getString(MSSV, null)
        if (data.maSinhVien == null)
            return null
        data.hoTen = getShare.getString(HOTEN, null)
        data.email = getShare.getString(EMAIL, null)
        data.avatar = getShare.getString(AVATAR, null)
        data.ngaySinh = getShare.getString(NGAYSINH, null)
        data.gioiTinh = getShare.getString(GIOITINH, null)
        data.diaChi = getShare.getString(DIACHI, null)
        data.sdt = getShare.getString(SDT, null)
        data.email = getShare.getString(EMAIL, null)
        data.facebook = getShare.getString(FACEBOOK, null)
        data.nganh = getShare.getString(NGANH, null)
        return data
    }
}