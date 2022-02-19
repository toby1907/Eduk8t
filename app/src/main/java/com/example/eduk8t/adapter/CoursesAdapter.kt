package com.example.eduk8t.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.eduk8t.databinding.CourseListItemBinding
import com.example.eduk8t.domain.Course

class CoursesAdapter(): ListAdapter<Course,CoursesAdapter.CourseViewHolder>(DiffCallback) {

    class CourseViewHolder(private var binding: CourseListItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind (courseItem: Course){
            binding.courseTitle.text = courseItem.title
            binding.courseDescription.text = courseItem.description
            binding.priceId.text = "Price: {courseItem.price}"
        }
    }

 companion object DiffCallback : DiffUtil.ItemCallback<Course>() {
     override fun areItemsTheSame(oldItem: Course, newItem: Course): Boolean {
         return oldItem == newItem
     }

     override fun areContentsTheSame(oldItem: Course, newItem: Course): Boolean {
         return oldItem.id == newItem.id
     }
 }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val inflater = LayoutInflater.from (parent.context)
        val binding = CourseListItemBinding.inflate(inflater, parent,false)
    return CourseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
       val courseItem = getItem(position)
        holder.bind(courseItem)
        holder.itemView.setOnClickListener {
            onItemClickListener?.let{
                it(courseItem)
            }

        }
    }
    private var onItemClickListener: ((Course) -> Unit)? = null
    fun setOnItemClickListener (listener: (Course)-> Unit) {
        onItemClickListener = listener
    }

}