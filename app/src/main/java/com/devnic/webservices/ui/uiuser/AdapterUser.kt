package com.devnic.webservices.ui.uiuser

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devnic.webservices.R
import com.devnic.webservices.databinding.CardUserItemBinding
import com.devnic.webservices.model.Users.User
import com.squareup.picasso.Picasso

class AdapterUser : ListAdapter<User, AdapterUser.ViewholderU>(ModelComparator()) {

    class ViewholderU(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = CardUserItemBinding.bind(view)

        @SuppressLint("SetTextI18n")
        fun bind(model: User) {
            Picasso.get().load(model.avatar).into(binding.userimage)
            binding.username.text = "${model.first_name}  ${model.last_name}"
            binding.correo.text = model.email
            binding.iduser.text = model.id

        }


        companion object {
            fun create(parent: ViewGroup): ViewholderU {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.card_user_item, parent, false)
                return ViewholderU(view)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewholderU {
        return ViewholderU.create(parent)
    }

    override fun onBindViewHolder(holder: ViewholderU, position: Int) {
        holder.bind(getItem(position))
    }


}

private class ModelComparator : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean =
        oldItem.id == newItem.id


    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean =
        oldItem == newItem

}
