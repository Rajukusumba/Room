package com.example.roomdb

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.room.R
import com.example.room.databinding.FragmentAddBinding


class AddFragment : Fragment() {

     lateinit var binding: FragmentAddBinding

    private val userViewModel by viewModels<UserViewModel>()

    private val args by navArgs<AddFragmentArgs>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBinding.inflate(inflater, container, false)

        (activity as MainActivity?)?.binding?.toolbar?.setTitle("Add User")
        binding.button.setText("Add User")
        if (args.currentUser?.editMode != null) {
            binding.editTextText1.setText(args.currentUser!!.firstName)
            binding.editTextText2.setText(args.currentUser!!.lastName)
            binding.editTextText3.setText(args.currentUser!!.age)
            binding.button.setText("Update")
            (activity as MainActivity?)?.binding?.toolbar?.setTitle("Update User")

        }

        binding.button.setOnClickListener {
            if (args.currentUser?.editMode == true) {
                updateUsers()
                val action = AddFragmentDirections.actionAddFragmentToListFragment()
                findNavController().navigate(action)
            } else {
                insertDataToDb()
            }
        }
        return binding.root
    }

    private fun updateUsers() {
        val firstName = binding.editTextText1.text.toString()
        val lastName = binding.editTextText2.text.toString()
        val age = binding.editTextText3.text.toString()
        if (inputCheck(firstName, lastName, age)) {
            val user = args.currentUser?.id?.let { User(it, firstName, lastName, age, true) }
            //add into db
            if (user != null) {
                userViewModel.updateUser(user)
            }
            Toast.makeText(requireContext(), "Successfully Updated User", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(requireContext(), "Please enter data", Toast.LENGTH_SHORT).show()
        }
    }


    private fun insertDataToDb() {

        val firstName = binding.editTextText1.text.toString()
        val lastName = binding.editTextText2.text.toString()
        val age = binding.editTextText3.text.toString()
        if (inputCheck(firstName, lastName, age)) {
            val user = User(0, firstName, lastName, age, false)
            //add into db
            userViewModel.addUser(user)
            Toast.makeText(requireContext(), "Success fully data added", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "Please enter data", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(firstName: String, lastName: String, age: String): Boolean {
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && TextUtils.isEmpty(
            age
        ))
    }


}

