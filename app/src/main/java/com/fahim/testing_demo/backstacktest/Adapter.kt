package com.fahim.testing_demo.backstacktest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.fahim.testing_demo.R
import com.fahim.testing_demo.databinding.StackEntryBinding

class Adapter(private val data: List<Int>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<StackEntryBinding>(
            LayoutInflater.from(parent.context),
            R.layout.stack_entry, parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemBinding.textView.text = "Fragment ${data[position]}"
    }

    override fun getItemCount(): Int = data.size

    inner class ViewHolder(val itemBinding: StackEntryBinding) :
        RecyclerView.ViewHolder(itemBinding.root)
}