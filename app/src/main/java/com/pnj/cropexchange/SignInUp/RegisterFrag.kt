package com.pnj.cropexchange.SignInUp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.pnj.cropexchange.databinding.ActivityRegisterBinding
import com.pnj.cropexchange.user.User
import com.pnj.cropexchange.util.Resource
import com.pnj.cropexchange.viewmodel.RegisterViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings

private val TAG = "RegisterFrag"
@AndroidEntryPoint
class RegisterFrag : Fragment() {

    private lateinit var binding: ActivityRegisterBinding
    private val viewModel by viewModels<RegisterViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityRegisterBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply{
            registerBtn.setOnClickListener {
                val user = User(
                    editNama.text.toString().trim(),
                    editEmail.text.toString().trim()
                )
                val password = editPassword.text.toString()
                viewModel.createAccountwithEmailandPassword(user, password)
            }
        }

        lifecycleScope.launchWhenStarted {
            viewModel.register.collect {
                when (it) {
                    is Resource.Success -> {
                        Log.d("test", it.message.toString())
                    }
                    is Resource.Error -> {
                        Log.e(TAG,it.message.toString())
                    }
                    is Resource.Loading -> {

                    }

                }
            }
        }
    }



}