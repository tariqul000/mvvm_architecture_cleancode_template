package com.simec.alet.activity

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.content.ContextCompat
import com.afollestad.materialdialogs.MaterialDialog
import com.google.android.material.textview.MaterialTextView
import com.simec.alet.extensions.BuildConfig
import com.simec.alet.extensions.R
import com.simec.alet.view.setStartDrawable


@Suppress("DEPRECATION")
fun Context.isNetworkAvailable(): Boolean {
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE)
            as ConnectivityManager?
    var hasOnline = false
    connectivityManager?.let {
        it.getNetworkCapabilities(connectivityManager.activeNetwork)?.apply {
            hasOnline = when {
                hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                else -> false
            }
        }
    }
    return hasOnline
}


fun Context.horizontalLinearLayout(): LinearLayoutCompat {
    return LinearLayoutCompat(this).apply {
        orientation = LinearLayoutCompat.HORIZONTAL
        layoutParams = LinearLayoutCompat.LayoutParams(
            LinearLayoutCompat.LayoutParams.MATCH_PARENT,
            LinearLayoutCompat.LayoutParams.WRAP_CONTENT
        )
        weightSum = 2.0f
    }
}


fun Context.isDarkThemeOn(): Boolean {
    return resources.configuration.uiMode and
            Configuration.UI_MODE_NIGHT_MASK == UI_MODE_NIGHT_YES
}

@ColorRes
fun Context.getColorId(): Int {
    return if (isDarkThemeOn()) R.color.white else R.color.black
}


fun Context.createChip(
    text: String
): View {
    val paddingDp = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP, 12.0F,
        resources.displayMetrics
    ).toInt()
    val drawablePaddingDp = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP, 8.0F,
        resources.displayMetrics
    ).toInt()

    val colors = ContextCompat.getColorStateList(this, getColorId())
    return MaterialTextView(
        this, null, R.attr.chipStyle
    ).apply {
        this.text = text
        setTextAppearance(R.style.TextAppearance_MaterialComponents_Caption)
        setPadding(0, paddingDp, 0, paddingDp)
        setTextColor(colors)
        setStartDrawable(
            R.drawable.bg_circular_grey
        )
        compoundDrawablePadding = drawablePaddingDp
        gravity = Gravity.START or Gravity.CENTER
    }
}

fun Context.share(articleId: Int, slug: String, lang: String) {
    val url = "${BuildConfig.DOMAIN}/$lang/articles/$articleId/$slug"
    val shareIntent: Intent = Intent.createChooser(
        Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, url)
            putExtra(Intent.EXTRA_TITLE, slug)
            type = "text/plain"
        },
        "Share Link"
    )
    startActivity(shareIntent)
}


fun Context.showDialog(
    title: String,
    message: String,
    isAutoClose: Boolean = false,
    duration: Long = 2000L,
    closeListener: () -> Unit = {}
) {

    val dialog = MaterialDialog(this)
        .cornerRadius(6f)

    dialog.title(text = title)
    dialog.message(text = message)

    if (!isAutoClose) {
        dialog.positiveButton(R.string.okay) {
            it.dismiss()
            closeListener()
        }
    }

    dialog.show()

    if (isAutoClose) {
        dialog.view.postDelayed({
            dialog.dismiss()
            closeListener()
        }, duration)
    }
}

fun Context.toast(message: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, length).show()
}

fun Context.toast(@StringRes messageId: Int, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, messageId, length).show()
}