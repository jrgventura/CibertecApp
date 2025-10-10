package com.cibertec.cibertecapp.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.cibertec.cibertecapp.R

class NewsFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    companion object {
        fun newInstance(): NewsFragment = NewsFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbarNews = view.findViewById<Toolbar>(R.id.toolbarNews)
        toolbarNews.inflateMenu(R.menu.menu_options)
        toolbarNews.setOnMenuItemClickListener { item ->
            if (item.itemId == R.id.itemShared) {
                // Open SharedActivity
            } else if (item.itemId == R.id.itemSettings) {
                // Open SettingsActivity
            } else {
                //////
            }
            false
        }

    }

}