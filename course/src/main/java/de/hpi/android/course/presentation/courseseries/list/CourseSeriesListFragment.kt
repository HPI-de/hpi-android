package de.hpi.android.course.presentation.courseseries.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import de.hpi.android.core.presentation.base.BaseFragment
import de.hpi.android.course.R
import de.hpi.android.course.databinding.CourseFragmentCourseSeriesListBinding
import kotlinx.android.synthetic.main.course_fragment_course_list.*

class CourseSeriesListFragment : BaseFragment<CourseFragmentCourseSeriesListBinding, CourseSeriesListViewModel>() {
    private val adapter by lazy { CourseSeriesAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CourseSeriesListViewModel::class.java)
    }

    override fun onCreateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): CourseFragmentCourseSeriesListBinding {
        return CourseFragmentCourseSeriesListBinding.inflate(inflater, container, false).also {
            it.viewModel = viewModel
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        baseActivity.setSupportActionBar(view.findViewById(R.id.toolbar))

        recyclerView.also {
            it.adapter = adapter
            it.layoutManager = LinearLayoutManager(context)
        }

        viewModel.courseSeries.observe(this, Observer {courses ->
            adapter.items = courses ?: emptyList()
        })
    }
}
