package com.fahim.base

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.google.android.material.appbar.AppBarLayout

abstract class BaseFragment : Fragment() {

    private val titleTextView: TextView by lazy {
        (activity as AppCompatActivity).findViewById(R.id.title)
    }
    private val subTitleTextView: TextView by lazy {
        (activity as AppCompatActivity).findViewById(R.id.subTitle)
    }
    private val toolbar: Toolbar by lazy {
        (activity as AppCompatActivity).findViewById(R.id.toolbar)
    }

    protected fun setTitleAndSubTitle(
        title: String? = null,
        subtitle: String? = null
    ) {
        titleTextView.visibility = if (title == null) View.GONE else View.VISIBLE
        subTitleTextView.visibility = if (subtitle == null) View.GONE else View.VISIBLE
        titleTextView.text = title
        subTitleTextView.text = subtitle
    }

    protected fun setActionAndStatusBarColor(color: Int?) {
        setToolbarTheme(color == Color.WHITE)
        (activity as AppCompatActivity).supportActionBar?.setBackgroundDrawable(color?.let {
            ColorDrawable(it)
        })
        if (color != null) {
            (activity as AppCompatActivity).window.statusBarColor = color
        }
    }

    protected fun setActionBarVisibility(isVisible: Boolean) {
        if (isVisible)
            (activity as AppCompatActivity).findViewById<AppBarLayout>(R.id.app_bar_layout).visibility =
                View.VISIBLE
        else
            (activity as AppCompatActivity).findViewById<AppBarLayout>(R.id.app_bar_layout).visibility =
                View.GONE
    }

    private fun setToolbarTheme(state: Boolean) {
        toolbar.navigationIcon =
            if (state)
                ResourcesCompat.getDrawable(resources, R.drawable.ic_back_arrow_black, context?.theme)
            else
                ResourcesCompat.getDrawable(resources, R.drawable.ic_back_arrow_white, context?.theme)
    }
}