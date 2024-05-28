package com.example.tema1_android

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tema1_android.database.Animal

class AnimalAdapter(
    private var animals: List<Animal>,
    private val itemClickListener: OnItemClickListener
) : RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(animal: Animal)
        fun onItemDelete(animal: Animal)
    }

    class AnimalViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(animal: Animal, clickListener: OnItemClickListener) {
            itemView.setOnClickListener {
                clickListener.onItemClick(animal)
            }
            itemView.findViewById<Button>(R.id.deleteItem).setOnClickListener {
                clickListener.onItemDelete(animal)
            }

            val nameTextView = itemView.findViewById<TextView>(R.id.animalName)
            val continentTextView = itemView.findViewById<TextView>(R.id.animalContinent)

            nameTextView.text = animal.name
            continentTextView.text = animal.continent
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_animal, parent, false)
        return AnimalViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        holder.bind(animals[position], itemClickListener)
    }

    override fun getItemCount() = animals.size

    fun updateData(newAnimals: List<Animal>) {
        animals = newAnimals
        notifyDataSetChanged()
    }
}
