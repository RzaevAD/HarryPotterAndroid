package com.loftblog.hogwardtslibrary.ui.students.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.loftblog.hogwardtslibrary.R

class StudentsAdapter: RecyclerView.Adapter<StudentsAdapter.StudentViewHolder>() {

    private val mDataList = ArrayList<StudentCellModel>()
    private val mDisplayList = ArrayList<StudentCellModel>()

    fun setData(newData: List<StudentCellModel>) {
        mDataList.clear()
        mDataList.addAll(newData)
        filter(query = "")
    }

    fun filter(query: String) {
        mDisplayList.clear()

        if (query.isEmpty()) {
            mDisplayList.addAll(mDataList)
            return
        }

        mDisplayList.addAll(mDataList.filter {
            it.name.contains(query, true) ||
            it.facultyName.contains(query, true)
        })

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return StudentViewHolder(itemView = inflater.inflate(R.layout.cell_student, parent, false))
    }

    override fun getItemCount(): Int = mDisplayList.count()

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bind(cellModel = mDisplayList[position])
    }

    class StudentViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val textName: TextView = itemView.findViewById(R.id.textStudentName)
        private val textFaculty: TextView = itemView.findViewById(R.id.textStudentFaculty)

        fun bind(cellModel: StudentCellModel) {
            textName.text = cellModel.name
            textFaculty.text = cellModel.facultyName
        }
    }
}