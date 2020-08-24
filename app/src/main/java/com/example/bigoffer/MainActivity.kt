package com.example.bigoffer

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import android.widget.Toast
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
    var toolb: Toolbar? = null
    var snackbar: Snackbar? = null
    var navigationExpandableListView: ExpandableNavigationListView? = null
    private var toggle: ActionBarDrawerToggle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        if (isNetworkConnected() == false) {
            Toast.makeText(this, "Check your internet connection..", Toast.LENGTH_SHORT).show()
        }
        var bundle = Bundle()
        var webviewfragment = WebViewFragment()
        webviewfragment.url = "https://bigoffer.pk/"
        loadFragment(webviewfragment, true,null)

        window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        drawer = findViewById(R.id.drawer_layout)
        /* if (supportActionBar != null) supportActionBar!!.setTitle(getString(R.string.dashboard))
         val toolbar: Toolbar = findViewById(R.id.toolbar)
         setSupportActionBar(toolbar)*/
        if (supportActionBar != null) supportActionBar!!.setDisplayShowTitleEnabled(false)
        val navigationView: NavigationView = findViewById(R.id.nav_view)
        val header_View = navigationView.getHeaderView(0)

        header_View.findViewById<ImageView>(R.id.fb).setOnClickListener {
            getOpenFacebookIntent()
        }
        header_View.findViewById<ImageView>(R.id.insta).setOnClickListener {
            getOpenInstaIntent()
        }
        header_View.findViewById<ImageView>(R.id.twitter).setOnClickListener {
            getOpenTwitterIntent()
        }




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
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        toggle = ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer.addDrawerListener(this.toggle!!)
        toolbar.setTitle("Dashboard")
        toggle!!.syncState()
    }

    private fun initNavigation() {

        navigationExpandableListView?.init(this@MainActivity)
                ?.addHeaderModel(HeaderModel("Home ", R.drawable.ic_baseline_home_24))
                ?.addHeaderModel(HeaderModel("Shop ", R.drawable.ic_baseline_shopping_cart_24))
                ?.addHeaderModel(
                        HeaderModel(
                                "Sport Nutritions ",
                                R.drawable.ic_baseline_sports_volleyball_24
                        )
                )
                ?.addHeaderModel(
                        HeaderModel(
                                "Health & Wellness ",
                                R.drawable.ic_baseline_person_add_24
                        )
                )
                ?.addHeaderModel(HeaderModel("Electronics ", R.drawable.ic_baseline_devices_other_24))
                ?.addHeaderModel(HeaderModel("Alam Pickels ", R.drawable.ic_baseline_eco_24))
                ?.addHeaderModel(HeaderModel("Blog ", R.drawable.ic_baseline_book_24))
                ?.addHeaderModel(HeaderModel("About ", R.drawable.ic_baseline_question_answer_24))
                ?.addHeaderModel(HeaderModel("Contact us ", R.drawable.ic_baseline_perm_phone_msg_24))


                //  ,,, ,  , ,  , , ", R.drawable.splash)


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


    private fun isNetworkConnected(): Boolean {
        val cm =
                getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return cm.activeNetworkInfo != null && cm.activeNetworkInfo.isConnected
    }

    private fun openFragments(position: Int) {

        Toast.makeText(applicationContext, "Loading.. ", Toast.LENGTH_LONG).show()
        val webViewFragment = WebViewFragment()

        if (isNetworkConnected() == false) {
            Toast.makeText(this, "Check your internet connection..", Toast.LENGTH_SHORT).show()
        }
        when (position) {


           0 -> webViewFragment.url = "https://bigoffer.pk/"
            1 ->webViewFragment.url = "https://bigoffer.pk/shop/"
            2 ->  webViewFragment.url = "https://bigoffer.pk/product-category/sports-nutrition/"
            3 -> webViewFragment.url = "https://bigoffer.pk/product-category/health-wellness/"
            4 -> webViewFragment.url = "https://bigoffer.pk/product-category/electronics/"
            5 -> webViewFragment.url = "https://bigoffer.pk/product-category/pickle/"
            6 -> webViewFragment.url = "https://bigoffer.pk/blog/"
            7 -> webViewFragment.url = "https://bigoffer.pk/about/"
            8 -> webViewFragment.url = "https://bigoffer.pk/contact-us/"
            else -> Log.d("test", "else position " + position)
        }

        //load fragment and close drawer
        if (position!=9){ loadFragment(webViewFragment, false, null)}
        drawer!!.closeDrawer(GravityCompat.START)
    }

    fun loadFragment(baseFragment: BaseFragment, addToBackStack: Boolean, bundle: Bundle?) {
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out)
            if (bundle != null) baseFragment.arguments = bundle
            fragmentTransaction.add(R.id.container, baseFragment, "MainActivity")
          //  if (addToBackStack)
           // fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()

    }


    //facebook url load
     fun getOpenFacebookIntent(){
        var id = 977307522399638;
        try {
             val intent = Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/" + id))
            startActivity(intent)
        } catch (e: java.lang.Exception) {
           val intent =  Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/" + id))
            startActivity(intent)
        }
    }
     fun getOpenInstaIntent(){
        //https://www.instagram.com/bigoffer.pk/
         val uri = Uri.parse("http://instagram.com/bigoffer.pk/")
         val likeIng = Intent(Intent.ACTION_VIEW, uri)

         likeIng.setPackage("com.instagram.android")

         try {
             startActivity(likeIng)
         } catch (e: ActivityNotFoundException) {
             startActivity(
                 Intent(
                     Intent.ACTION_VIEW,
                     Uri.parse("http://instagram.com/bigoffer.pk/")
                 )
             )
         }





    }
     fun getOpenTwitterIntent(){
         var twitter_user_name:  String = "@ElonMusk"
         try {
             startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?screen_name=$twitter_user_name")))
         } catch (e: Exception) {
             startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/#!/$twitter_user_name"))
             )
         }
         }





}

