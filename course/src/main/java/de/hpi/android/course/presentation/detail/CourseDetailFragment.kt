package de.hpi.android.course.presentation.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import de.hpi.android.core.presentation.base.BaseFragment
import de.hpi.android.course.R
import de.hpi.android.course.databinding.FragmentCourseDetailBinding
import de.hpi.android.course.domain.Course

class CourseDetailFragment : BaseFragment<FragmentCourseDetailBinding, CourseDetailViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CourseDetailViewModel::class.java)

        viewModel.course.observe(this, Observer { course ->
            viewModel.generalInformation.value = getString(
                R.string.course_courseDetails_details,
                getString(
                    if (course?.series?.mandatory == true) R.string.course_courseSeries_mandatory_true
                    else R.string.course_courseSeries_mandatory_false
                ),
                course?.series?.ects,
                course?.series?.hoursPerWeek,
                course?.type?.joinToString(separator = getString(R.string.course_courseSeries_type_seperator)) {
                    getString(
                        when (it) {
                            Course.Type.LECTURE -> R.string.course_courseSeries_type_lecture
                            Course.Type.BLOCK_SEMINAR -> R.string.course_courseSeries_type_blockSeminar
                            Course.Type.EXERCISE -> R.string.course_courseSeries_type_exercise
                            Course.Type.SEMINAR -> R.string.course_courseSeries_type_seminar
                        }
                    )
                }
            )
        })
    }

    override fun onCreateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentCourseDetailBinding {
        return FragmentCourseDetailBinding.inflate(inflater, container, false).also {
            it.viewModel = viewModel
            it.onTeleTaskClicked = {
                val uri = viewModel.courseDetail.value?.teleTask
                if (uri != null) {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri.toString()))
                    startActivity(intent)
                }
            }
        }
    }
}
