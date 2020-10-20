package com.example.weather.module.about


import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.navigation.Navigation
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.example.weather.R
import com.example.weather.common.checkUpdate
import com.example.weather.module.main.view.MainActivity
import kotlinx.android.synthetic.main.custom_bar.view.*

/**
 * @author: klaus
 * @date: 2020/10/19
 */
class AboutFragment : PreferenceFragmentCompat(),
    SharedPreferences.OnSharedPreferenceChangeListener {

    private lateinit var parentActivity: MainActivity

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //这里重写根据PreferenceFragmentCompat 的布局 ，往他的根布局插入了一个toolbar
        var containerView = view.findViewById<FrameLayout>(R.id.suggestion_list)
        containerView.let {
            var linearLayout = it.parent as? LinearLayout
            linearLayout?.run {
                var toolbarView =
                        LayoutInflater.from(activity).inflate(R.layout.custom_bar, null)
                toolbarView.detail_start.setOnClickListener {
                    Navigation.findNavController(it).navigateUp()
                }
                toolbarView.detail_end.visibility = View.INVISIBLE
                toolbarView.detail_title.text = "设置"

                addView(toolbarView, 0)
            }
        }
    }

    override fun onCreatePreferences(avedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.setting_fragment)
        parentActivity = activity as MainActivity
    }

    override fun onResume() {
        super.onResume()
        preferenceScreen.sharedPreferences.registerOnSharedPreferenceChangeListener(this)
    }

    override fun onPause() {
        super.onPause()
        preferenceScreen.sharedPreferences.unregisterOnSharedPreferenceChangeListener(this)
    }

    private fun init() {
        var version = "当前版本" + parentActivity.packageManager.getPackageInfo(
                parentActivity.packageName,
                0
        ).versionName

        findPreference<Preference>("version")?.setOnPreferenceClickListener {
            checkUpdate(parentActivity, true)
            false
        }

        findPreference<Preference>("csdn")?.setOnPreferenceClickListener {
            view?.let {
                Navigation.findNavController(it)
                        .navigate(R.id.action_aboutFragment_to_webFragment, Bundle().apply {
                            putString("title", "Klaus")
                            putString("url", "www.qq.com")
                        })
            }
            false
        }

        findPreference<Preference>("project")?.setOnPreferenceClickListener {
            view?.let {
                Navigation.findNavController(it)
                        .navigate(R.id.action_aboutFragment_to_webFragment, Bundle().apply {
                            putString("title", "Weather")
                            putString("url", "https://github.com/klaus_mai/Weather")
                        })
            }
            false
        }
    }
    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {
    }
}