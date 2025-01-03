package com.m.e.diaf.madarsofttask.ui

import android.os.Bundle
import android.text.Editable
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.m.e.diaf.madarsofttask.R
import com.m.e.diaf.madarsofttask.databinding.FragmentHomeBinding
import com.m.e.diaf.madarsofttask.model.DataUser
import com.m.e.diaf.madarsofttask.viewmodel.DataUserViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


@AndroidEntryPoint
class HomeFragment : Fragment() {

    private  var _binding: FragmentHomeBinding?=null
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
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        getSexType()
        binding.btnSave.setOnClickListener{
            insertApplicantDataToLocal()
        }
        binding.btnNavigateToDataScreen.setOnClickListener {
            navigateToDataShow()
        }


        return binding.root

    }
    fun insertApplicantDataToLocal(){
        Log.d("stttep1", "1")
        lifecycleScope.launch {
            Log.d("stttep2", "2")
            if(validateFields()){
                Log.d("stttep3", "3")
                dataUserViewModel.insertApplicant(DataUser(
                    0,
                    binding.userName.text.toString() ,
                    binding.age.text.toString(),
                    binding.jobTitle.text.toString(),
                    binding.gender.selectedItem.toString()
                ))
                Log.d("stttep4", "4")
                Toast.makeText(requireContext(),"you applied successful",Toast.LENGTH_LONG).show()
                Log.d("stttep5", "5")
                binding.userName.text = Editable.Factory.getInstance().newEditable("")
                Log.d("stttep6", "6")
                binding.age.text = Editable.Factory.getInstance().newEditable("")
                Log.d("stttep7", "7")
                binding.jobTitle.text = Editable.Factory.getInstance().newEditable("")
                Log.d("stttep8", "8")
                binding.gender.setSelection(0)
                Log.d("stttep9" , "sucess")

            }
            Log.d("stttep10" , "10")
            dataUserViewModel.getAllApplicant()
            dataUserViewModel.allApplicant.collect{
                Log.d("stttepsss" , it.toString())
            }
        }
        Log.d("stttep11" , "11")
    }


    fun navigateToDataShow(){
        val action = HomeFragmentDirections.actionHomeFragmentToShowDataFragment()
        navControler.navigate(action)
    }
    private fun getSexType(){
        var sexTypeArray = arrayOf("choose","Male" , "Female")
        val sexAdapter = ArrayAdapter(requireContext(),
            R.layout.spicial_item_spinner , sexTypeArray)
        sexAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.gender.adapter = sexAdapter
    }

    private fun validateFields(): Boolean {
        var isValid = true

        if (binding.userName.text.isNullOrEmpty()) {
            binding.userName.error = "Please enter username"
            isValid = false
        }

        if (binding.age.text.isNullOrEmpty()) {
            binding.age.error = "Please enter your age"
            isValid = false
        } else if (binding.age.text.toString().toIntOrNull() == null) {
            binding.age.error = "Please enter your age correct"
            isValid = false
        }
        if (binding.jobTitle.text.isNullOrEmpty()) {
            binding.jobTitle.error = "Job title is required"
            isValid = false
        }

        if (binding.gender.selectedItem == null || binding.gender.selectedItem.toString() == "choose") {
            Toast.makeText(context, "Please select your gender", Toast.LENGTH_SHORT).show()
            isValid = false
        }

        return isValid
    }


}