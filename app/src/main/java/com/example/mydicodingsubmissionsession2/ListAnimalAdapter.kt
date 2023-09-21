package com.example.mydicodingsubmissionsession2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListAnimalAdapter(private val listAnimal: ArrayList<Animal>) :
    RecyclerView.Adapter<ListAnimalAdapter.ListViewHolder>() {

    interface OnItemClickCallback {
        fun onItemClicked(data: Animal)
    }

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val photo: ImageView = itemView.findViewById(R.id.card_image)
        val title: TextView = itemView.findViewById(R.id.card_title)
        val description: TextView = itemView.findViewById(R.id.card_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.animal_card_item, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listAnimal.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listAnimal[position]
        holder.title.text = name
        holder.description.text = description
        Glide.with(holder.itemView.context).load(photo).into(holder.photo)
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked((listAnimal[holder.adapterPosition])) }
    }

}