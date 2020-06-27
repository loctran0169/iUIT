package vn.edu.uit.managementforstudents.ui.fragments.account_edit

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import vn.edu.uit.managementforstudents.module.models.ThongTinSinhVien
import vn.edu.uit.managementforstudents.module.networks.ApiManager

class ViewModelAccountEdit  : ViewModel(){
    private val compo by lazy { CompositeDisposable() }
    private val apiManager: ApiManager by lazy { ApiManager() }
    val loadingThongTin = MutableLiveData<ThongTinSinhVien>().apply { value = null }

    init {
        loadThongTinSinhVien()
    }

    private fun loadThongTinSinhVien() {
        compo.add(
            apiManager.getThongTinSinhVien(17520700)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    loadingThongTin.value = it
                }, {

                })
        )
    }
}