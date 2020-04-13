package digital.equinox.interviewapp_2020.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import digital.equinox.interviewapp_2020.R
import digital.equinox.interviewapp_2020.databinding.MainFragmentBinding
import digital.equinox.interviewapp_2020.ui.EventObserver
import digital.equinox.interviewapp_2020.ui.main.viewmodels.MainViewModel

class MainFragment : Fragment() {

    private val vmodel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = MainFragmentBinding.inflate(inflater)

        if (vmodel.isLogged()) {
            binding.lifecycleOwner = this
            binding.vmodel = vmodel
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (vmodel.isLogged()) {
            initUI()
        } else {
            navigateToLogin()
        }
    }

    private fun initUI() {
        vmodel.logOutResult.observe(viewLifecycleOwner, EventObserver {
            if (it) {
                navigateToLogin()
            }
        })

        vmodel.toCamera.observe(viewLifecycleOwner, EventObserver {
            if (it) {
                findNavController().navigate(R.id.to_cameraFragment)
            }
        })
    }

    private fun navigateToLogin() {
        findNavController().navigate(R.id.to_loginFragment)
    }
}
