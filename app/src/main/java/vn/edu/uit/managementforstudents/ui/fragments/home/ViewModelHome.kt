package vn.edu.uit.managementforstudents.ui.fragments.home

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.michalsvec.singlerowcalendar.utils.DateUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import vn.edu.uit.managementforstudents.module.models.MonHoc
import vn.edu.uit.managementforstudents.module.networks.ApiManager
import java.util.*
import kotlin.collections.ArrayList

class ViewModelHome: ViewModel(){
    private val compo by lazy { CompositeDisposable() }
    private val apiManager: ApiManager by lazy { ApiManager() }
    private val calendar = Calendar.getInstance()
    val loadMonHoc = MutableLiveData<List<MonHoc>>().apply { value = mutableListOf() }

    init {
       // loadHome()
    }

//    fun loadHome() {
//        compo.add(
//            apiManager.getLichHoc(calendar.get(Calendar.DAY_OF_WEEK))
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({
//
//                    var list = ArrayList<MonHoc>()
//                    it.forEach{
////                        if(it.thu==calendar.get(Calendar.DAY_OF_WEEK))
//                        if(it.thu==3)
//                            list.add(it)
//                    }
//                    loadMonHoc.value=list
//
//                }, {
//
//                })
//        )
//    }
}
