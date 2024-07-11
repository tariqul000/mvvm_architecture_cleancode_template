package com.simec.gfs.view

import android.view.View
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import com.google.android.material.progressindicator.LinearProgressIndicator


fun View.isVisible(): Boolean {
    return visibility == View.VISIBLE
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}

fun ConstraintLayout.addPI(pi: LinearProgressIndicator) {
    val constrainSet = ConstraintSet()
    pi.id = View.generateViewId()
    addView(pi, 0)
    constrainSet.clone(this)
    constrainSet.connect(pi.id, ConstraintSet.TOP, id, ConstraintSet.TOP, 4)
    constrainSet.applyTo(this)
}

fun TextView.setStartDrawable(@DrawableRes drawableId: Int) {
    setCompoundDrawablesWithIntrinsicBounds(
        drawableId, 0, 0, 0
    )
}

fun TextView.setEndDrawable(@DrawableRes drawableId: Int) {
    setCompoundDrawablesWithIntrinsicBounds(
        0, 0, drawableId, 0
    )
}
