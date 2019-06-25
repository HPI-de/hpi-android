package de.hpi.android.news.presentation.detail

import android.os.Bundle
import android.text.Spannable
import android.text.style.ImageSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.toSpannable
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import de.hpi.android.core.presentation.base.BaseFragment
import de.hpi.android.core.presentation.utils.formatDateTimeRelative
import de.hpi.android.core.presentation.utils.viewModel
import de.hpi.android.news.R
import de.hpi.android.news.databinding.FragmentArticleDetailBinding
import kotlinx.android.synthetic.main.news_fragment_article_detail.*

class ArticleDetailFragment : BaseFragment<FragmentArticleDetailBinding, ArticleDetailViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args by navArgs<ArticleDetailFragmentArgs>()
        viewModel = viewModel { ArticleDetailViewModel(args.id) }
    }

    override fun onCreateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentArticleDetailBinding {
        return FragmentArticleDetailBinding.inflate(inflater, container, false).also {
            it.vm = viewModel
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.article.observe(this, Observer { article ->
            if (article == null) {
                meta.text = null
                return@Observer
            }

            val date = context!!.formatDateTimeRelative(article.date)
            meta.text = if (article.viewCount != null) getString(
                R.string.news_detail_meta_viewCount,
                article.source.title,
                date,
                article.viewCount
            ).toSpannable().apply {
                val index = indexOf('@')
                setSpan(
                    ImageSpan(context!!.getDrawable(R.drawable.news_ic_outline_remove_red_eye_24px)!!.apply {
                        setBounds(0, 0, meta.lineHeight, meta.lineHeight)
                        setTint(meta.currentTextColor)
                    }),
                    index,
                    index + 1,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
            }
            else getString(R.string.news_detail_meta, article.source.title, date)
        })
    }
}
