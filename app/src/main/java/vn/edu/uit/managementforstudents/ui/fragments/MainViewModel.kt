package vn.edu.uit.managementforstudents.ui.fragments

import androidx.lifecycle.ViewModel
import vn.edu.uit.managementforstudents.module.models.NotifyPerson
import vn.edu.uit.managementforstudents.module.models.MonHoc

class MainViewModel : ViewModel() {
    val listSubject = listOf(MonHoc("","", "", "", "", "", "", "", "", ""),
        MonHoc("","", "", "", "", "", "", "", "", ""),
        MonHoc("","", "", "", "", "", "", "", "", ""),
        MonHoc("", "","", "", "", "", "", "", "", ""))
    val listNotifyPerson = listOf(NotifyPerson("", "", "", "", "", "", "", "", "", "", "", true),
        NotifyPerson("", "", "", "", "", "", "", "", "", "", "", true),
        NotifyPerson("", "", "", "", "", "", "", "", "", "", "", true),
        NotifyPerson("", "", "", "", "", "", "", "", "", "", "", true))
    val listName = listOf("Bộ lọc","Kiến trúc máy tính","Cộng nghệ phần mềm chuyên sâu","Đồ án 1","Đặt tả hình thức")
}