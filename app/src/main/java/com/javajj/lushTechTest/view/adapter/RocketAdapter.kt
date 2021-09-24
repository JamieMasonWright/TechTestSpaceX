package com.javajj.lushTechTest.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.javajj.lushTechTest.databinding.RowRocketItemBinding
import com.javajj.lushTechTest.model.rocket.Rocket

/**
 * Provides rocket data for use in the recyclerview
 */
class RocketAdapter : RecyclerView.Adapter<RocketViewHolder>(){

    var rocketDataList = emptyList<Rocket>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    /**
     * Function inflates the row_rocket_item.xml layout and instantiates the ViewHolder
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RocketViewHolder {
        val view = RowRocketItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return RocketViewHolder(view)
    }

    /**
     * Binds data in the rocketDataList
     */
    override fun onBindViewHolder(holder: RocketViewHolder, position: Int) {
        holder.binding.also {
            it.rocket = rocketDataList[position]
        }
    }

    override fun getItemCount(): Int {
       return rocketDataList.size
    }
}

/**
 * Used to instantiate the Viewholder to populate the adapter
 */
class RocketViewHolder(val binding: RowRocketItemBinding) : RecyclerView.ViewHolder(binding.root)