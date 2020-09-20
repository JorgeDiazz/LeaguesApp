package com.jorge_diaz.leagues.UIutils

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class FragmentUtils {

    companion object {

        fun openLinkInBrowser(fragment: Fragment, link: String) {
            val uri: Uri = Uri.parse(link)
            fragment.startActivity(Intent(Intent.ACTION_VIEW, uri))
        }

        fun AppCompatActivity.addFragment(fragment: Fragment, frameId: Int) {
            supportFragmentManager.inTransaction { add(frameId, fragment) }
        }

        fun AppCompatActivity.replaceFragment(fragment: Fragment, frameId: Int) {
            supportFragmentManager.inTransaction { replace(frameId, fragment) }
        }

        fun Fragment.removeFragmentFromStack(fragment: Fragment) {
            activity!!.supportFragmentManager.beginTransaction().remove(fragment).commit();
        }

        private inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
            beginTransaction().func().commitAllowingStateLoss()
        }
    }
}