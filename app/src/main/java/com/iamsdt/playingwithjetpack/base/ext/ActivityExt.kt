/*
 * Developed By Shudipto Trafder
 * at 9/1/18 12:18 AM
 * Copyright (c) 9/1/18 12:18 AM Shudipto Trafder
 */

package com.iamsdt.playingwithjetpack.base.ext

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import kotlin.reflect.KClass


/*
    run thread and go to the next activity
    better use case in splash activity
 */
fun AppCompatActivity.runThread(timer: Long, clazz: KClass<out AppCompatActivity>) =
        Thread {
            try {
                Thread.sleep(timer)
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                toNextActivity(clazz)
                finish()
            }
        }.start()

/*
 Go to next activity with intent
 just pass the next activity class
 more option is available
 */

fun AppCompatActivity.toNextActivity(
        clazz: KClass<out AppCompatActivity>,
        extraKey: String = "",
        extra: String = "",
        finish: Boolean = false) {
    val intent = Intent(this, clazz.java)

    if (extraKey.isNotEmpty()) {
        intent.putExtra(extraKey, extra)
    }

    startActivity(intent)

    if (finish) {
        finish()
    }
}

/*
    Chrome custom tabs
 */
//fun AppCompatActivity.customTab(link: String) {
//    val builder = CustomTabsIntent.Builder()
//    builder.setToolbarColor(R.attr.colorPrimary)
//    builder.setShowTitle(true)
//    builder.addDefaultShareMenuItem()
//    //builder.setCloseButtonIcon(BitmapFactory.decodeResource(
//    //resources, R.drawable.dialog_back))
//    val customTabsIntent = builder.build()
//    customTabsIntent.launchUrl(this, Uri.parse(link))
//}

/*
Send email with activity extension function
 */
fun AppCompatActivity.sendEmail(
        email: String,
        subject: String) {

    val intent = Intent(Intent.ACTION_SENDTO)
    intent.type = "text/plain"
    intent.data = Uri.parse("mailto:$email")
    intent.putExtra(Intent.EXTRA_SUBJECT, subject)
    startActivity(Intent.createChooser(intent, "Send Email"))
}



