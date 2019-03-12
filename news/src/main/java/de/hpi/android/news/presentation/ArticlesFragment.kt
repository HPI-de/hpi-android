package de.hpi.android.news.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import de.hpi.android.core.presentation.base.BaseFragment
import de.hpi.android.news.databinding.FragmentArticlesBinding

class ArticlesFragment : BaseFragment<FragmentArticlesBinding, ArticlesViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ArticlesViewModel::class.java)
    }

    override fun onCreateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentArticlesBinding {
        return FragmentArticlesBinding.inflate(inflater, container, false).also {
            it.viewModel = viewModel
        }
    }
}
