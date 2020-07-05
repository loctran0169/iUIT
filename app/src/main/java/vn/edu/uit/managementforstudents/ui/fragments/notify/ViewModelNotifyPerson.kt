package vn.edu.uit.managementforstudents.ui.fragments.notify

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import vn.edu.uit.managementforstudents.module.models.NotifyPerson
import vn.edu.uit.managementforstudents.module.networks.ApiManager
import java.util.*
import kotlin.collections.ArrayList

class ViewModelNotifyPerson : ViewModel(){
    private val compo by lazy { CompositeDisposable() }
    private val apiManager: ApiManager by lazy { ApiManager() }
    val loadNotifyPerson = MutableLiveData<List<NotifyPerson>>().apply { value = mutableListOf() }

    init {
        loadNotify()
    }

    fun loadNotify() {
        compo.add(
            apiManager.getNotifyPerson(17520700)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    loadNotifyPerson.value=it
                }, {
                })
        )
    }
}
