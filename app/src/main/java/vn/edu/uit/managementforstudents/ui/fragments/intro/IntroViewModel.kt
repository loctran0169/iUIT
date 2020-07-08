package vn.edu.uit.managementforstudents.ui.fragments.intro

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import vn.edu.uit.managementforstudents.module.models.DangNhap
import vn.edu.uit.managementforstudents.module.networks.ApiManager

class IntroViewModel : ViewModel() {
    var isLogin = MutableLiveData<Boolean>().apply { value = false }
    private val compo by lazy { CompositeDisposable() }
    private val apiManager: ApiManager by lazy { ApiManager() }
    val listDangNhap = MutableLiveData<List<DangNhap>>().apply { value = mutableListOf() }

    fun loadDangNhap() {
        compo.add(
            apiManager.getLoginResponse(17520700)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    listDangNhap.value = it
                }, {

                })
        )
    }
}