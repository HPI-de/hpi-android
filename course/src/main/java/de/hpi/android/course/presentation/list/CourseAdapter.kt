package de.hpi.android.course.presentation.list

import android.view.LayoutInflater
import android.view.ViewGroup
import de.hpi.android.core.presentation.base.BaseAdapter
import de.hpi.android.core.presentation.base.BaseViewHolder
import de.hpi.android.course.databinding.CourseItemCourseBinding
import de.hpi.android.course.domain.Course

class CourseAdapter : BaseAdapter<Course, CourseAdapter.ViewHolder, CourseItemCourseBinding>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CourseItemCourseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun areItemsTheSame(old: Course, new: Course) = old.id == new.id

    override fun areContentsTheSame(old: Course, new: Course) =
        old.series.title == new.series.title && old.lecturer == new.lecturer

    class ViewHolder(binding: CourseItemCourseBinding) : BaseViewHolder<Course, CourseItemCourseBinding>(binding) {
        override fun onItemSet() {
            binding.course = item
        }
    }
}
