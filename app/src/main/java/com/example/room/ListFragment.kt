package com.example.roomdb

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.room.ListAdapter
import com.example.room.OnClick
import com.example.room.R
import com.example.room.databinding.FragmentListBinding


class ListFragment : Fragment(), OnClick {

    private lateinit var binding: FragmentListBinding
    private val userViewModel by viewModels<UserViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentListBinding.inflate(inflater, container, false)
        (activity as MainActivity?)?.binding?.toolbar?.setTitle("Users")
       setUpAdapter()
        clicks()
        return (binding.root)
    }


    private fun clicks(){
        binding.floatingActionButton.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToAddFragment(null)
            findNavController().navigate(action)
        }
    }

    private fun setUpAdapter() {
        var adapter = ListAdapter(this )
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        userViewModel.readAllData?.observe(viewLifecycleOwner) {
            adapter.setData(it)
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.icDelete) {
            deleteData()

        }
        return super.onOptionsItemSelected(item)
    }

    fun deleteData() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") { _, _ ->
            userViewModel.deleteAllUsers()
        }
        builder.setNegativeButton("No") { _, _ ->

        }
        builder.setTitle("Delete Data")
        builder.setMessage("Are you sure want to delete data")
        builder.create().show()
    }

    fun deleteUser(user: User) {
        userViewModel.deleteUser(user)
    }

    override fun deleteUserItem(user: User) {
        userViewModel.deleteUser(user)
    }

}