package de.hpi.android.course.presentation.list

import android.view.LayoutInflater
import android.view.ViewGroup
import de.hpi.android.core.presentation.base.BaseViewHolder
import de.hpi.android.core.presentation.base.BaseAdapter
import de.hpi.android.course.data.Course
import de.hpi.android.course.databinding.ItemCourseBinding

class CourseAdapter : BaseAdapter<Course, CourseAdapter.ViewHolder, ItemCourseBinding>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val  binding = ItemCourseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun areItemsTheSame(old: Course, new: Course) = old.id == new.id

    override fun areContentsTheSame(old: Course, new: Course) = old.series == new.series

    class ViewHolder(binding: ItemCourseBinding) : BaseViewHolder<Course, ItemCourseBinding>(binding) {
        override fun onItemSet() {
            binding.course = item
            binding.series = item.series
        }
    }
}