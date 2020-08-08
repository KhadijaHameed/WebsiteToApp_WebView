package com.example.bigoffer

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import com.techatmosphere.expandablenavigation.model.HeaderModel
import com.techatmosphere.expandablenavigation.view.ExpandableNavigationListView
import com.uhfSolution.ahlAndroid.fragments.WebViewFragment

class MainActivity : AppCompatActivity() {


    var currentFragment = ""
    var drawer: DrawerLayout? = null
    var snackbar: Snackbar? = null
    var navigationExpandableListView: ExpandableNavigationListView? = null
    private var toggle: ActionBarDrawerToggle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var bundle =Bundle()
         var  webviewfragment = WebViewFragment()
        //viewOrderFragment.getClass().getSimpleName()
        loadFragment(webviewfragment, false , bundle)

         window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_main)
        drawer = findViewById(R.id.drawer_layout)
       /* if (supportActionBar != null) supportActionBar!!.setTitle(getString(R.string.dashboard))
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)*/
        if (supportActionBar != null) supportActionBar!!.setDisplayShowTitleEnabled(false)
        val navigationView: NavigationView = findViewById(R.id.nav_view)
        val header_View = navigationView.getHeaderView(0)



        header_View.setOnClickListener { view: View? ->
            val dealerProfileFragment = WebViewFragment()
            if (!currentFragment.equals("test")) {

            }
            val drawer: DrawerLayout = findViewById(R.id.drawer_layout)
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START)
            }
        }
        initiateActionBarDrawerToggle()
//        navigationView.setNavigationItemSelectedListener(this);
        //        navigationView.setNavigationItemSelectedListener(this);
        navigationExpandableListView = findViewById(R.id.expandable_navigation)

        initNavigation()
    }


    protected fun initiateActionBarDrawerToggle() {
        val toolbar =
            findViewById<Toolbar>(R.id.toolbar)
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        toggle = ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer.addDrawerListener(this.toggle!!)
        toggle!!.syncState()
    }
    private fun initNavigation() {

        navigationExpandableListView?.init(this@MainActivity)
            ?.addHeaderModel(HeaderModel("Home", R.drawable.splash))


            ?.build()
            ?.addOnGroupClickListener({ parent, v, groupPosition, id ->
                navigationExpandableListView?.setSelected(groupPosition)
                openFragments(groupPosition)
                false
            })
            /*.addOnChildClickListener({ parent, v, groupPosition, childPosition, id ->
                navigationExpandableListView.setSelected(groupPosition)

                }
                false
            })*/
    }

    private fun openFragments(position: Int) {



      if (position == 1) {
            val webViewFragment = WebViewFragment()
            if (!currentFragment.equals("WebViewFragment")) {
                 loadFragment(webViewFragment, true, null)
                drawer!!.closeDrawer(GravityCompat.START)
            } else drawer!!.closeDrawer(GravityCompat.START)
        }
    }

    fun loadFragment(
        baseFragment: BaseFragment,
        addToBackStack: Boolean,
        bundle: Bundle?
    ) {
        if (currentFragment != "MainActivity") {
            currentFragment = "MainActivity"
            val fragmentTransaction =
                supportFragmentManager.beginTransaction()
            fragmentTransaction.setCustomAnimations(
                android.R.anim.fade_in,
                android.R.anim.fade_out,
                android.R.anim.fade_in,
                android.R.anim.fade_out
            )
            if (bundle != null) baseFragment.arguments = bundle
            fragmentTransaction.add(
                R.id.container, baseFragment, "MainActivity"
            )
            if (addToBackStack) fragmentTransaction.addToBackStack(baseFragment.toString())
            fragmentTransaction.commit()
        }
    }

}