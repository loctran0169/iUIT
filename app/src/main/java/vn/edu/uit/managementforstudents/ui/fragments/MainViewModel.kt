package vn.edu.uit.managementforstudents.ui.fragments

import androidx.lifecycle.ViewModel
import vn.edu.uit.managementforstudents.data.models.NotifyPerson
import vn.edu.uit.managementforstudents.data.models.Subject

class MainViewModel : ViewModel() {
    val listSubject = listOf(Subject("", "", "", "", "", "", "", "", ""),
        Subject("", "", "", "", "", "", "", "", ""),
        Subject("", "", "", "", "", "", "", "", ""),
        Subject("", "", "", "", "", "", "", "", ""))
    val listNotifyPerson = listOf(NotifyPerson("", "", "", "", "", "", "", "", "", "", "", true),
        NotifyPerson("", "", "", "", "", "", "", "", "", "", "", true),
        NotifyPerson("", "", "", "", "", "", "", "", "", "", "", true),
        NotifyPerson("", "", "", "", "", "", "", "", "", "", "", true))
}