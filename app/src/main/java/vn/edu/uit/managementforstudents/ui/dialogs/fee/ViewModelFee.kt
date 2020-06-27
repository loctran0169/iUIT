package vn.edu.uit.managementforstudents.ui.dialogs.fee

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import vn.edu.uit.managementforstudents.module.models.Diem
import vn.edu.uit.managementforstudents.module.models.HocPhi
import vn.edu.uit.managementforstudents.module.networks.ApiManager

class ViewModelFee  : ViewModel(){
    private val compo by lazy { CompositeDisposable() }
    private val apiManager: ApiManager by lazy { ApiManager() }
    val loadingFee = MutableLiveData<List<HocPhi>>().apply { value = mutableListOf() }

    init {
        loadListScore()
    }

    fun loadListScore() {
        compo.add(
            apiManager.getHocPhi(17520700)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    loadingFee.value = it
                }, {

                })
        )
    }
}