package vn.edu.uit.managementforstudents.ui.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import vn.edu.uit.managementforstudents.module.models.*
import vn.edu.uit.managementforstudents.module.networks.ApiManager

class MainViewModel : ViewModel() {
    val listSubject = listOf(
        MonHoc("", "", "", "", "", true, "", "", "", "", "", "", 1),
        MonHoc("", "", "", "", "", true, "", "", "", "", "", "", 1),
        MonHoc("", "", "", "", "", true, "", "", "", "", "", "", 1),
        MonHoc("", "", "", "", "", true, "", "", "", "", "", "", 1)
    )

    private val compo by lazy { CompositeDisposable() }
    private val apiManager: ApiManager by lazy { ApiManager() }
    val listMonHoc = MutableLiveData<List<MonHoc>>().apply { value = mutableListOf() }

    var listLichSuMonHoc = MutableLiveData<List<LichSu>>().apply { value = itemsHis }
    var itemsHis = mutableListOf<LichSu>()
    var loadMoreHis = MutableLiveData<LoadMoreObject>()


    val listSchedule = MutableLiveData<List<ThoiKhoaBieu>>().apply { value = mutableListOf() }
    val listNotifyGeneral = MutableLiveData<List<NotifyGeneral>>().apply { value = mutableListOf() }
    val listNotifyPerson = MutableLiveData<List<NotifyPerson>>().apply { value = mutableListOf() }

    val listDangNhap= MutableLiveData<List<DangNhap>>().apply { value = mutableListOf() }
    lateinit var thongTinSinhVien: ThongTinSinhVien

    var isLoadSchedule = MutableLiveData<Boolean>().apply { value = false }

    init {
        loadDangNhap()
        loadDanhSachMonHoc()
        loadLichSuMonHoc()
        loadSchedule()
        loadNotifyGeneral()
        loadNotifyPerson()

    }
    fun loadDangNhap(){
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

    private fun loadSchedule() {
        compo.add(
            apiManager.getSchedule(17520700, 6)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    isLoadSchedule.value = true
                    listSchedule.value = it
                }, {
                    isLoadSchedule.value = true
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
                    data.add(0, MonHoc("-1", "Chọn môn học"))
                    listMonHoc.value = data
                }, {

                })
        )
    }

    fun loadLichSuMonHoc() {
        val loadMore = itemsHis.isNotEmpty()
        compo.add(
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
        )
    }

    fun loadNotifyGeneral() {
        compo.add(
            apiManager.getNotifyGeneral(17520700)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                        listNotifyGeneral.value = it
                }, {
                })
        )
    }

    fun loadNotifyPerson() {
        compo.add(
            apiManager.getNotifyPerson(17520700)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    listNotifyPerson.value = it
                }, {
                })
        )
    }
}