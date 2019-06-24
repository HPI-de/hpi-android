package de.hpi.android.course.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import de.hpi.android.core.presentation.base.BaseFragment
import de.hpi.android.course.R
import de.hpi.android.course.databinding.FragmentCourseDetailBinding

class CourseDetailFragment : BaseFragment<FragmentCourseDetailBinding, CourseDetailViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CourseDetailViewModel::class.java)
    }

    override fun onCreateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentCourseDetailBinding {
        return FragmentCourseDetailBinding.inflate(inflater, container, false).also {
            it.viewModel = viewModel
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        baseActivity.setSupportActionBar(view.findViewById(R.id.toolbar))

        viewModel.courseDetail.observe(this, Observer {
            // update UI
        })
    }
}
