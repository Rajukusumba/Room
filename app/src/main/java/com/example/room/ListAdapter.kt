package com.example.room

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.room.databinding.CustomRowBinding
import com.example.roomdb.ListFragmentDirections
import com.example.roomdb.User


class ListAdapter(private val onClick: OnClick) : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var userList = emptyList<User>()


    class MyViewHolder(private val binding: CustomRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        // val mListener:OnClick?=mListner
        fun bindData(currentItem: User, onClick: OnClick) {

            binding.firstName.text = currentItem.firstName
            binding.id.text = currentItem.id.toString()
            binding.lastName.text = currentItem.lastName
            binding.age.text = currentItem.age


            binding.deleteList.setOnClickListener {
                // itemView.findNavController().navigate(R.id.action_listFragment_to_addFragment)
                //  }

                val builder = AlertDialog.Builder(it.context)
                builder.setPositiveButton("Yes") { _, _ ->
                    onClick?.deleteUserItem(currentItem)
                }
                builder.setNegativeButton("No") { _, _ ->

                }
                builder.setTitle("Delete Data")
                builder.setMessage("Are you sure want to delete data")
                builder.create().show()
            }
            binding.Edit.setOnClickListener {
                currentItem.editMode = true;
                //  itemView.findNavController().navigate(R.id.action_listFragment_to_addFragment,)
                val action = ListFragmentDirections.actionListFragmentToAddFragment(currentItem)
                itemView.findNavController().navigate(action)
            }
            binding.linearlayout.setOnClickListener {

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = CustomRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//val binding= CustomRowBinding.inflate(R.layout.custom_row, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItemPosition = userList[position]
        holder.bindData(currentItemPosition, onClick)

        //  onClick?.deleteUserItem(currentItemPosition)

    }


    override fun getItemCount(): Int {
        return userList.size
    }


    @SuppressLint("NotifyDataSetChanged")
    fun setData(user: List<User>) {
        this.userList = user
        notifyDataSetChanged()
    }

}

interface OnClick {
    fun deleteUserItem(user: User)
}

