package de.hpi.android.news.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import de.hpi.android.core.presentation.base.BaseFragment
import de.hpi.android.core.presentation.utils.viewModel
import de.hpi.android.news.R
import de.hpi.android.news.databinding.NewsFragmentArticleListBinding
import kotlinx.android.synthetic.main.news_fragment_article_list.*

class ArticleListFragment : BaseFragment<NewsFragmentArticleListBinding, ArticleListViewModel>() {
    private val adapter by lazy {
        ArticleAdapter {
            findNavController().navigate(
                ArticleListFragmentDirections.newsActionArticleListToArticleDetail(it.id.value)
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = viewModel()
    }

    override fun onCreateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): NewsFragmentArticleListBinding {
        return NewsFragmentArticleListBinding.inflate(inflater, container, false).also {
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
        viewModel.articles.observe(this, Observer { articles ->
            adapter.items = articles ?: emptyList()
        })
    }
}
