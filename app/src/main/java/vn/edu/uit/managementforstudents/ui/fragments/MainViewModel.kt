package vn.edu.uit.managementforstudents.ui.fragments

import androidx.lifecycle.ViewModel
import vn.edu.uit.managementforstudents.data.Model.Subject
import java.util.*

class MainViewModel : ViewModel(){
    val listSubject = listOf(Subject("","","","","","","","",""),
        Subject("","","","","","","","",""),
        Subject("","","","","","","","",""),
        Subject("","","","","","","","",""))
}