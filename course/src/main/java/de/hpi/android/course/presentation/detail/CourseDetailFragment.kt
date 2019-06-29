package de.hpi.android.course.presentation.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import de.hpi.android.core.presentation.base.BaseFragment
import de.hpi.android.course.R
import de.hpi.android.course.databinding.FragmentCourseDetailBinding
import kotlinx.android.synthetic.main.fragment_course_detail.*

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
            it.onTeleTaskClicked = {
                val uri = viewModel.courseDetail.value?.teleTask
                if (uri != null) {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri.toString()))
                    startActivity(intent)
                }
            }
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
