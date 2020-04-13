package digital.equinox.interviewapp_2020.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import digital.equinox.interviewapp_2020.R
import digital.equinox.interviewapp_2020.databinding.LoginFragmentBinding
import digital.equinox.interviewapp_2020.ui.EventObserver
import digital.equinox.interviewapp_2020.ui.main.viewmodels.LoginViewModel
import kotlinx.android.synthetic.main.login_fragment.*

class LoginFragment : Fragment() {

    private val vmodel: LoginViewModel by viewModels()

    private lateinit var busyController: BusyProgressController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = LoginFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.vmodel = vmodel
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initUI()
    }

    private fun initUI() {
        busyController = BusyProgressControllerImpl(progress, login)

        vmodel.loginResult.observe(viewLifecycleOwner, EventObserver {
            if (it) {
                findNavController().navigate(R.id.to_mainFragment)
            } else {
                Snackbar.make(view!!, R.string.wrong_creds_msg, Snackbar.LENGTH_LONG).show()
            }
        })

        vmodel.showProgress.observe(viewLifecycleOwner, Observer {
            busyController.progress(it)
        })

        vmodel.noNetwork.observe(viewLifecycleOwner, EventObserver {
            if (it) {
                Snackbar.make(view!!, R.string.no_network, Snackbar.LENGTH_LONG).show()
            }
        })
    }
}
