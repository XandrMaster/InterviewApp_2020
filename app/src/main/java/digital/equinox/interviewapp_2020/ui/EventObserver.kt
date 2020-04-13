package digital.equinox.interviewapp_2020.ui

import androidx.lifecycle.Observer

class EventObserver<T>(private val changed: (T) -> Unit) : Observer<T> {

    private var latch = false

    /**
     * just ignore first event
     *
     * @param t
     */
    override fun onChanged(t: T) {
        if (latch) {
            changed(t)
        }

        if (!latch) {
            latch = true
        }
    }
}