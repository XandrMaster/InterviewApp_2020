package digital.equinox.interviewapp_2020.ui.main

import android.view.View
import android.view.View.*

fun View.setEnable(isEnable: Boolean) {
    isEnabled = isEnable
}

fun View.setVisible() {
    visibility = VISIBLE
}

fun View.setGone() {
    visibility = GONE
}

fun View.setInvisible() {
    visibility = INVISIBLE
}