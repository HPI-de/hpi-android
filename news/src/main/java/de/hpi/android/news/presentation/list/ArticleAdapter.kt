package de.hpi.android.news.presentation.list

import android.view.LayoutInflater
import android.view.ViewGroup
import de.hpi.android.core.presentation.base.BaseAdapter
import de.hpi.android.core.presentation.base.BaseViewHolder
import de.hpi.android.news.databinding.ItemArticleBinding
import de.hpi.android.news.domain.Article

class ArticleAdapter(val onArticleSelected: (Article) -> Unit) :
    BaseAdapter<Article, ArticleAdapter.ViewHolder, ItemArticleBinding>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun areItemsTheSame(old: Article, new: Article) = old.id == new.id

    override fun areContentsTheSame(old: Article, new: Article) = old.title == new.title


    inner class ViewHolder(binding: ItemArticleBinding) : BaseViewHolder<Article, ItemArticleBinding>(binding) {
        override fun onItemSet() {
            binding.article = item
            binding.root.setOnClickListener {
                onArticleSelected(item)
            }
        }
    }
}
