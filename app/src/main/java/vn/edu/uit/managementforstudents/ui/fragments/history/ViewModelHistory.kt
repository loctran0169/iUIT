package vn.edu.uit.managementforstudents.ui.fragments.history

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import vn.edu.uit.managementforstudents.module.models.LichSu
import vn.edu.uit.managementforstudents.module.models.MonHoc
import vn.edu.uit.managementforstudents.module.models.ThongTinSinhVien
import vn.edu.uit.managementforstudents.module.networks.ApiManager

class ViewModelHistory : ViewModel(){
    
    private val compo by lazy { CompositeDisposable() }
    private val apiManager: ApiManager by lazy { ApiManager() }
    val listMonHoc = MutableLiveData<List<MonHoc>>().apply { value = mutableListOf() }
    val listName = listOf("Bộ lọc","Kiến trúc máy tính","Cộng nghệ phần mềm chuyên sâu","Đồ án 1","Đặt tả hình thức","Kiến trúc máy tính","Cộng nghệ phần mềm chuyên sâu","Đồ án 1","Đặt tả hình thức","Kiến trúc máy tính","Cộng nghệ phần mềm chuyên sâu","Đồ án 1","Đặt tả hình thức")
    val listLichSuMonHoc = MutableLiveData<List<LichSu>>().apply { value = mutableListOf() }

    init {
//        loadDanhSachMonHoc()
//        loadLichSuMonHoc()
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
            apiManager.getLichSuHocTap(17520700,null)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    listLichSuMonHoc.value = it
                }, {

                })
        )
    }
}