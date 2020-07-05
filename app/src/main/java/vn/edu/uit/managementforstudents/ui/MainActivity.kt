package vn.edu.uit.managementforstudents.ui

import android.content.Context
import android.content.SharedPreferences
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.activity_main.*
import vn.edu.uit.managementforstudents.R
import vn.edu.uit.managementforstudents.ui.fragments.MainViewModel

class MainActivity : AppCompatActivity() {

    var backTime = 0L
    val sharedPref: SharedPreferences by lazy {
        getSharedPreferences("iUIT", Context.MODE_PRIVATE)
    }
    private val viewModelMain: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LOCKED
        setContentView(R.layout.activity_main)
        Navigation.findNavController(this, R.id.nav_host_fragment)
    }

    override fun onBackPressed() {
        if (nav_host_fragment.findNavController().currentDestination?.label != "Main Fragment") {
            super.onBackPressed()
            return
        }
        if (sharedPref != null) {
            if (sharedPref.getBoolean("MAIN", false)) {
                if (System.currentTimeMillis() - backTime > 2000) {
                    Toast.makeText(this, "Ấn lần nữa để thoát", Toast.LENGTH_SHORT).show()
                } else {
                    super.onBackPressed()
                }
                backTime = System.currentTimeMillis()
            } else
                super.onBackPressed()
        }
    }
}
