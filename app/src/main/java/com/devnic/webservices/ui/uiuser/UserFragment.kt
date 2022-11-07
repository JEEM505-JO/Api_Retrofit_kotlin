package com.devnic.webservices.ui.uiuser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.devnic.webservices.R
import com.devnic.webservices.api.apiuser.HelperUser
import com.devnic.webservices.databinding.FragmentUserBinding
import com.devnic.webservices.repository.RepositoryUser

class UserFragment : Fragment() {
    private lateinit var viewModel: UserViewModel
    private lateinit var binding: FragmentUserBinding
    private lateinit var factory: UserFactory
    private lateinit var adapterUser: AdapterUser
    private var helper = HelperUser.getInstance()
    private val repository by lazy {
        helper?.let { RepositoryUser(it) }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_user, container, false)
        factory = repository?.let { UserFactory(it) }!!
        viewModel = ViewModelProvider(this, factory)[UserViewModel::class.java]
        binding.view = viewModel
        adapterUser = AdapterUser()

        viewModel.userlist.observeForever {
            it?.let { list ->
                adapterUser.submitList(list)
            }
        }

        viewModel.code.observeForever {
            binding.tvcodrsult.text = it
        }
        viewModel.sms.observeForever {
            binding.tvsmsresult.text = it
        }
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recycleruser.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapterUser
        }
    }

}
