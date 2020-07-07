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

    var listLichSuMonHoc = MutableLiveData<List<LichSu>>().apply { value = itemsHis }
    var itemsHis = mutableListOf<LichSu>()
    var loadMoreHis = MutableLiveData<LoadMoreObject>()


    val listSchedule = MutableLiveData<List<ThoiKhoaBieu>>().apply { value = mutableListOf() }
    val listNotifyGeneral = MutableLiveData<List<NotifyGeneral>>().apply { value = mutableListOf() }
    var isLoadSchedule=MutableLiveData<Boolean>().apply { value=false }

    init {
        loadDanhSachMonHoc()
        loadLichSuMonHoc(null)
        loadSchedule()
        loadNotifyGeneral()
    }

    private fun loadSchedule() {
        compo.add(
            apiManager.getSchedule(17520700, 6)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    isLoadSchedule.value=true
                    listSchedule.value = it
                }, {
                    isLoadSchedule.value=true
                })
        )
    }

    private fun loadDanhSachMonHoc() {
        compo.add(
            apiManager.getDanhSachMonHoc(17520700)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    val data = it.toMutableList()
                    data.add(0, MonHoc(null, "Tất cả"))
                    listMonHoc.value = data
                }, {

                })
        )
    }

    fun loadLichSuMonHoc(id : String?) {
        val loadMore = itemsHis.isNotEmpty()
        compo.add(
            when(id){
               "SS006.K22" -> {
                   apiManager.getLichSuHocTapPLDC(17520700, null)
                       .subscribeOn(Schedulers.io())
                       .observeOn(AndroidSchedulers.mainThread())
                       .subscribe({
                           if (!loadMore) {
                               itemsHis.clear()
                               itemsHis.addAll(it)
                               listLichSuMonHoc.value = itemsHis
                           } else {
                               val start = itemsHis.lastIndex
                               val end = start + it.size
                               itemsHis.addAll(it)
                               this.loadMoreHis.value = LoadMoreObject(start, end)
                           }
                       }, {

                       })
               }
                "IT007.K22.PMCL" -> {
                    apiManager.getLichSuHocTapHeDieuHanh(17520700, null)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({
                            if (!loadMore) {
                                itemsHis.clear()
                                itemsHis.addAll(it)
                                listLichSuMonHoc.value = itemsHis
                            } else {
                                val start = itemsHis.lastIndex
                                val end = start + it.size
                                itemsHis.addAll(it)
                                this.loadMoreHis.value = LoadMoreObject(start, end)
                            }
                        }, {

                        })
                }
                "IT007.K22.PMCL.2" -> {
                    apiManager.getLichSuHocTapHeDieuHanhTH(17520700, null)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({
                            if (!loadMore) {
                                itemsHis.clear()
                                itemsHis.addAll(it)
                                listLichSuMonHoc.value = itemsHis
                            } else {
                                val start = itemsHis.lastIndex
                                val end = start + it.size
                                itemsHis.addAll(it)
                                this.loadMoreHis.value = LoadMoreObject(start, end)
                            }
                        }, {

                        })
                }
                "SE102.K21.PMCL" -> {
                    apiManager.getLichSuHocTapGame(17520700, null)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({
                            if (!loadMore) {
                                itemsHis.clear()
                                itemsHis.addAll(it)
                                listLichSuMonHoc.value = itemsHis
                            } else {
                                val start = itemsHis.lastIndex
                                val end = start + it.size
                                itemsHis.addAll(it)
                                this.loadMoreHis.value = LoadMoreObject(start, end)
                            }
                        }, {

                        })
                }
                else->{
                    apiManager.getLichSuHocTap(17520700, null)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({
                            if (!loadMore) {
                                itemsHis.clear()
                                itemsHis.addAll(it)
                                listLichSuMonHoc.value = itemsHis
                            } else {
                                val start = itemsHis.lastIndex
                                val end = start + it.size
                                itemsHis.addAll(it)
                                this.loadMoreHis.value = LoadMoreObject(start, end)
                            }
                        }, {

                        })
                }
            }
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