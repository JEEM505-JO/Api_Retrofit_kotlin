package com.devnic.webservices
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devnic.webservices.databinding.CardItemRickmortyBinding
import com.devnic.webservices.model.rickmorty.Characters
import com.squareup.picasso.Picasso

class AdapterRM() :
    ListAdapter<Characters, AdapterRM.ViewholderRM>(ModelComparator()) {

    class ViewholderRM(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = CardItemRickmortyBinding.bind(view)

        fun bind(model: Characters) {
            Picasso.get().load(model.image).into(binding.tvimage)
            binding.tvespecie.text = model.species
            binding.tvnombre.text = model.name
            binding.tvorigen.text = model.origin.name
            binding.idcharacter.text = model.id.toString()
        }


        companion object {
            fun create(parent: ViewGroup): ViewholderRM {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.card_item_rickmorty, parent, false)
                return ViewholderRM(view)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewholderRM {
        return ViewholderRM.create(parent)
    }

    override fun onBindViewHolder(holder: ViewholderRM, position: Int) {
        holder.bind(getItem(position))
    }


}

private class ModelComparator : DiffUtil.ItemCallback<Characters>() {
    override fun areItemsTheSame(oldItem: Characters, newItem: Characters): Boolean =
        oldItem.id == newItem.id


    override fun areContentsTheSame(oldItem: Characters, newItem: Characters): Boolean =
        oldItem == newItem

}
