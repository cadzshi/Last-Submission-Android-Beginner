package com.dicoding.lastsubmission

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.lastsubmission.databinding.ItemRowKeyboardBinding


class ListKeyboardAdapter(private val listKeyboard: ArrayList<Keyboard>) : RecyclerView.Adapter<ListKeyboardAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val binding = ItemRowKeyboardBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {

        val (name, description, price, photo) = listKeyboard[position]
        holder.binding.imgItemPhoto.setImageResource(photo)
        holder.binding.tvItemName.text = name
        holder.binding.tvItemDescription.text = description
        holder.binding.tvItemPrice.text = price

        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailKeyboard::class.java)
            intentDetail.putExtra("key_keyboard", listKeyboard[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }

    override fun getItemCount(): Int = listKeyboard.size

    class ListViewHolder(var binding: ItemRowKeyboardBinding) : RecyclerView.ViewHolder(binding.root)


}