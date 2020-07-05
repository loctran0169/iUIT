package vn.edu.uit.managementforstudents.ui.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import vn.edu.uit.managementforstudents.module.models.*
import vn.edu.uit.managementforstudents.module.networks.ApiManager

class MainViewModel : ViewModel() {
    val listSubject = listOf(MonHoc("", "", "", "", "", true, "", "", "", "", "", "", 1),
        MonHoc("", "", "", "", "", true, "", "", "", "", "", "", 1),
        MonHoc("", "", "", "", "", true, "", "", "", "", "", "", 1),
        MonHoc("", "", "", "", "", true, "", "", "", "", "", "", 1))
    val listNotifyPerson = listOf(NotifyPerson("", "", "", "", "", "", "", "", "", "", "", true),
        NotifyPerson("", "", "", "", "", "", "", "", "", "", "", true),
        NotifyPerson("", "", "", "", "", "", "", "", "", "", "", true),
        NotifyPerson("", "", "", "", "", "", "", "", "", "", "", true))
    private val compo by lazy { CompositeDisposable() }
    private val apiManager: ApiManager by lazy { ApiManager() }
    val listMonHoc = MutableLiveData<List<MonHoc>>().apply { value = mutableListOf() }
    val listLichSuMonHoc = MutableLiveData<List<LichSu>>().apply { value = mutableListOf() }
    val listSchedule = MutableLiveData<List<ThoiKhoaBieu>>().apply { value = mutableListOf() }
    val listNotifyGeneral = MutableLiveData<List<NotifyGeneral>>().apply { value = mutableListOf() }
    var b=MutableLiveData<Boolean>().apply { value=false }
    init {
        loadDanhSachMonHoc()
        loadLichSuMonHoc()
        loadSchedule()
        loadNotifyGeneral()
    }

    private fun loadSchedule() {
        compo.add(
            apiManager.getSchedule(17520700, 6)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    b.value=true
                    listSchedule.value = it

                }, {
                    b.value=true
                })
        )
    }

    private fun loadDanhSachMonHoc() {
        compo.add(
            apiManager.getDanhSachMonHoc(17520700)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    listMonHoc.value = it
                }, {

                })
        )
    }

    private fun loadLichSuMonHoc() {
        compo.add(
            apiManager.getLichSuHocTap(17520700, null)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    listLichSuMonHoc.value = it
                }, {

                })
        )
    }
    private fun loadNotifyGeneral() {
        compo.add(
            apiManager.getNotifyGeneral(17520700)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    listNotifyGeneral.value=it
                }, {
                })
        )
    }
}