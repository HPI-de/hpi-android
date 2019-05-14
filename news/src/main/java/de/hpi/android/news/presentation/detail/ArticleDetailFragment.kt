package de.hpi.android.news.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import de.hpi.android.core.presentation.base.BaseFragment
import de.hpi.android.core.utils.get
import de.hpi.android.news.databinding.FragmentArticleDetailBinding

class ArticleDetailFragment : BaseFragment<FragmentArticleDetailBinding, ArticleDetailViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get()
    }

    override fun onCreateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentArticleDetailBinding {
        return FragmentArticleDetailBinding.inflate(inflater, container, false).also {
            it.viewModel = viewModel
        }
    }
}
