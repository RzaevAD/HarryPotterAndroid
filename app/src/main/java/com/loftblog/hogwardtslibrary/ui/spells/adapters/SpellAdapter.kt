package com.loftblog.hogwardtslibrary.ui.spells.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.loftblog.hogwardtslibrary.R

class SpellAdapter: RecyclerView.Adapter<SpellAdapter.SpellViewHolder>() {

    private val mDataList = ArrayList<SpellCellModel>()

    fun setData(newData: List<SpellCellModel>) {
        mDataList.clear()
        mDataList.addAll(newData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpellViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return SpellViewHolder(itemView = inflater.inflate(R.layout.cell_spell, parent, false))
    }

    override fun getItemCount(): Int = mDataList.count()

    override fun onBindViewHolder(holder: SpellViewHolder, position: Int) {
        holder.bind(cellModel = mDataList[position])
    }

    class SpellViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val textName: TextView = itemView.findViewById(R.id.textSpellName)
        private val textType: TextView = itemView.findViewById(R.id.textSpellType)

        fun bind(cellModel: SpellCellModel) {
            textName.text = cellModel.name
            textType.text = cellModel.type
        }
    }
}