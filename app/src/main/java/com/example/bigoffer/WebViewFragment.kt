package com.uhfSolution.ahlAndroid.fragments


import android.graphics.Bitmap
import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import android.widget.Toast
import com.example.bigoffer.BaseFragment
import com.example.bigoffer.R


/**
 * A simple [Fragment] subclass.
 */
class WebViewFragment : BaseFragment() ,View.OnKeyListener{

    override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
        if (event?.action === KeyEvent.ACTION_DOWN) {
            when (keyCode) {
                KeyEvent.KEYCODE_BACK -> if (webView.canGoBack()) {
                    webView.goBack()
                    return true
                }
            }
        }
        return false
    }


    lateinit var webView: WebView
    lateinit var progressBar: ProgressBar

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        setCurrentFragment(this.javaClass.simpleName)
        val view =inflater.inflate(R.layout.fragment_web_view, container, false)
        webView = view.findViewById(R.id.web_view)
        progressBar = view.findViewById(R.id.progress_bar)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
       activity!!.title = "Big Offer"
        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true
        webView.setOnKeyListener(this)
        webView.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                progressBar.progress = newProgress
            }
        }
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                webView.loadUrl(url)
                return true
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                progressBar.visibility = View.VISIBLE

            }

            override fun onPageFinished(view: WebView, url: String) {
                progressBar.visibility = View.INVISIBLE
            }

            override fun onReceivedError(view: WebView, errorCode: Int, description: String, failingUrl: String) {
               Toast.makeText(context, "Fail: "+description,Toast.LENGTH_LONG)
            }
        }
        webView.loadUrl("https://bigoffer.pk/")

        super.onViewCreated(view, savedInstanceState)
    }
}
