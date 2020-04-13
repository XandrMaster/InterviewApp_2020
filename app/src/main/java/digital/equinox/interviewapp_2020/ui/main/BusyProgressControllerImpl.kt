package digital.equinox.interviewapp_2020.ui.main

import android.view.View
import digital.equinox.interviewapp_2020.ui.main.Utils.runInMainThread

class BusyProgressControllerImpl(
    private val progress: View,
    private vararg val blockedViews: View
) : BusyProgressController {

    override fun progress(isProgress: Boolean) {
        runInMainThread {
            if (isProgress) {
                progress.setVisible()
            } else {
                progress.setGone()
            }
            blockedViews.forEach {
                it.setEnable(!isProgress)
            }
        }
    }
}