package com.crispy.guide

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.util.Log


object Util {

    fun Activity.canOpenUrl(eventLink: String) {
        try {
            if (eventLink.startsWith("sattva://")) {
                if (appInstalledOrNot("com.meditation.tracker.android")) {
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(eventLink)))
                }
            } else if (eventLink.startsWith("cosmicinsight://")) {
                if (appInstalledOrNot("gman.vedicastro")) {
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(eventLink)))
                }
            } else if (eventLink.startsWith("align27://")) {
                if (appInstalledOrNot("com.dailyinsights")) {
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(eventLink)))
                }
            } else if (eventLink.startsWith("japa108://")) {
                if (appInstalledOrNot("com.gman.japa")) {
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(eventLink)))
                }
            } else if (eventLink.startsWith("seven://")) {
                if (appInstalledOrNot("aol.meditation.tracker.android")) {
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(eventLink)))
                }
            } else if (eventLink.startsWith("prajnayoga://")) {
                if (appInstalledOrNot("com.gmanlabs.prajnayoga")) {
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(eventLink)))
                }
            } else {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(eventLink)))
            }
        } catch (e: Exception) {
            Log.e("crispy-utils error", e.message ?: "error")
        }
    }

    fun Activity.appInstalledOrNot(uri: String): Boolean {
        try {
            packageManager.getPackageInfo(uri, PackageManager.GET_ACTIVITIES)
            return true
        } catch (e: PackageManager.NameNotFoundException) {
            try {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$uri")))
            } catch (e: Exception) {
                Log.e("crispy-utils error", e.message ?: "error")
            }
            return false
        }
    }

}