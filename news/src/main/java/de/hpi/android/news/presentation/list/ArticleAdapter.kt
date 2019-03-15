package de.hpi.android.news.presentation.list

import android.view.LayoutInflater
import android.view.ViewGroup
import de.hpi.android.core.presentation.base.BaseAdapter
import de.hpi.android.core.presentation.base.BaseViewHolder
import de.hpi.android.news.data.ArticleEntity
import de.hpi.android.news.databinding.ItemArticleBinding

class ArticleAdapter : BaseAdapter<ArticleEntity, ArticleAdapter.ViewHolder, ItemArticleBinding>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun areItemsTheSame(old: ArticleEntity, new: ArticleEntity) = old.id == new.id

    override fun areContentsTheSame(old: ArticleEntity, new: ArticleEntity) = old.title == new.title


    class ViewHolder(binding: ItemArticleBinding) : BaseViewHolder<ArticleEntity, ItemArticleBinding>(binding) {
        override fun onItemSet() {
            binding.article = item
        }
    }
}
