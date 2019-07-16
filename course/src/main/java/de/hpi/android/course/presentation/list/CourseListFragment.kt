package de.hpi.android.course.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import de.hpi.android.core.presentation.base.BaseFragment
import de.hpi.android.core.presentation.utils.viewModel
import de.hpi.android.course.R
import de.hpi.android.course.databinding.CourseFragmentCourseListBinding
import kotlinx.android.synthetic.main.course_fragment_course_list.*

class CourseListFragment : BaseFragment<CourseFragmentCourseListBinding, CourseListViewModel>() {
    private val adapter by lazy { CourseAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = viewModel()
    }

    override fun onCreateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): CourseFragmentCourseListBinding {
        return CourseFragmentCourseListBinding.inflate(inflater, container, false).also {
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

        viewModel.courses.observe(this, Observer { courses ->
            adapter.items = courses ?: emptyList()
        })
    }
}
