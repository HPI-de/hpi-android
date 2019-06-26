package de.hpi.android.course.presentation.courseseries.list

import android.view.LayoutInflater
import android.view.ViewGroup
import de.hpi.android.core.presentation.base.BaseAdapter
import de.hpi.android.core.presentation.base.BaseViewHolder
import de.hpi.android.course.R
import de.hpi.android.course.databinding.ItemCourseSeriesBinding
import de.hpi.android.course.domain.CourseSeries

class CourseSeriesAdapter : BaseAdapter<CourseSeries, CourseSeriesAdapter.ViewHolder, ItemCourseSeriesBinding>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCourseSeriesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun areItemsTheSame(old: CourseSeries, new: CourseSeries) = old.id == new.id

    override fun areContentsTheSame(old: CourseSeries, new: CourseSeries): Boolean {
        return old.title == new.title && old.ects == new.ects && old.mandatory == new.mandatory && old.type == new.type
    }

    class ViewHolder(binding: ItemCourseSeriesBinding) :
        BaseViewHolder<CourseSeries, ItemCourseSeriesBinding>(binding) {
        override fun onItemSet() {
            binding.series = item
            binding.details.text = context.getString(R.string.course_courseSeries_details, item.ects,
                context.getString(
                    if (item.mandatory) R.string.course_courseSeries_mandatory_true
                    else R.string.course_courseSeries_mandatory_false
                ),
                item.type.joinToString(context.getString(R.string.course_courseSeries_type_seperator)) {
                    context.getString(
                        when (it) {
                            CourseSeries.Type.LECTURE -> R.string.course_courseSeries_type_lecture
                            CourseSeries.Type.BLOCK_SEMINAR -> R.string.course_courseSeries_type_blockSeminar
                            CourseSeries.Type.EXERCISE -> R.string.course_courseSeries_type_exercise
                            CourseSeries.Type.SEMINAR -> R.string.course_courseSeries_type_seminar
                        }
                    )
                }
            )
        }
    }
}
