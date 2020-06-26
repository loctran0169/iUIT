package vn.edu.uit.managementforstudents.ui.dialogs.score

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

import vn.edu.uit.managementforstudents.module.models.ScoreTerm
import vn.edu.uit.managementforstudents.module.networks.ApiManager

class ViewModelScore  : ViewModel(){
    private val compo by lazy { CompositeDisposable() }
    private val apiManager: ApiManager by lazy { ApiManager() }
    val loadingScore = MutableLiveData<List<ScoreTerm>>().apply { value = mutableListOf() }

    init {
        loadListScore()
    }

    private fun loadListScore() {
        compo.add(
            apiManager.getScoreBoard(17520700)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    loadingScore.value = it
                }, {

                })
        )
    }
}
