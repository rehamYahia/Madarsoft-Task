package com.m.e.diaf.madarsofttask.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.m.e.diaf.madarsofttask.databinding.FragmentShowDataBinding
import com.m.e.diaf.madarsofttask.ui.adapter.DataUserAdapter
import com.m.e.diaf.madarsofttask.viewmodel.DataUserViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ShowDataFragment : Fragment() {
    private  var _binding: FragmentShowDataBinding?=null
    private val binding get()= _binding!!
    private lateinit var navControler: NavController
    private val dataUserViewModel : DataUserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navControler = findNavController()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentShowDataBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initApplicantRecycle()
    }

    fun initApplicantRecycle(){
        lifecycleScope.launch {
            dataUserViewModel.getAllApplicant()
            dataUserViewModel.allApplicant.collect{dataUser->
                dataUser.let {
                    if (dataUser != null) {
                       val  dataUserAdapter :DataUserAdapter= DataUserAdapter(dataUser)
                        binding.dataRecycle.adapter = dataUserAdapter
                        binding.dataRecycle.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

                    }
                }
            }

        }
    }

}