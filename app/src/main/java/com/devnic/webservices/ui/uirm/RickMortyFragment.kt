package com.devnic.webservices.ui.uirm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.devnic.webservices.AdapterRM
import com.devnic.webservices.R
import com.devnic.webservices.RickMortyFactory
import com.devnic.webservices.RickMortyViewModel
import com.devnic.webservices.api.apirm.HelperRM
import com.devnic.webservices.databinding.FragmentRickMortyBinding
import com.devnic.webservices.repository.RepositoryRM

class RickMortyFragment : Fragment() {
    private lateinit var binding: FragmentRickMortyBinding
    private lateinit var viewModel: RickMortyViewModel
    private lateinit var factory: RickMortyFactory
    private lateinit var adapterrm : AdapterRM
    private val helper = HelperRM.getInstance()
    
    private val respository by lazy {
        helper?.let { RepositoryRM(it) }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_rick_morty, container, false)
        factory = respository?.let { RickMortyFactory(it) }!!
        viewModel = ViewModelProvider(this, factory)[RickMortyViewModel::class.java]
        adapterrm = AdapterRM()
        binding.view = viewModel

        viewModel.characters.observeForever {
            it?.let { list ->  adapterrm.submitList(list) }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.recyclerRM.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapterrm
        }
    }
}