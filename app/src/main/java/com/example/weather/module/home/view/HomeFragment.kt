package com.example.weather.module.home.view

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.example.weather.R
import com.example.weather.base.view.BaseLifeCycleFragment
import com.example.weather.databinding.HomeFragmentBinding
import com.example.weather.module.home.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.home_fragment.*

/**
 * @author: klaus
 * @date: 2020/10/15
 */
class HomeFragment : BaseLifeCycleFragment<HomeViewModel,HomeFragmentBinding>() {
    override fun getLayoutId(): Int= R.layout.home_fragment

    private val mPlaceNameList= arrayListOf<String>()

    override fun initView() {
        super.initView()
        initToolbar()
    }

    override fun onCreateOptionsMenu(menu:Menu,inflater:MenuInflater){
        inflater.inflate(R.menu.home_menu,menu)
    }

    override fun onOptionsItemSelected(item:MenuItem) : Boolean{
        when(item.itemId){
            R.id.action_city ->{
                Navigation.findNavController(home_bar)
                        .navigate(R.id.action_homeFragment_to_choosePlaceFragment)
            }
            R.id.action_more ->{
                Navigation.findNavController(home_bar)
                        .navigate(R.id.action_homeFragment_to_aboutFragment)
            }
        }
        return super.onOptionsItemSelected(item)
    }
    private fun initToolbar() {
        home_bar.title=""
        (requireActivity() as AppCompatActivity).setSupportActionBar(home_bar)
    }

    override fun initData() {
        super.initData()

    }
    override fun initDataObserver(){
        super.initDataObserver()
        mViewModel
    }

}