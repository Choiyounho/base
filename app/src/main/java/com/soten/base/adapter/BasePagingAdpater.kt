package com.soten.base.adapter

import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.soten.base.adapter.listener.ItemClickListener

open class BasePagingAdapter<T : Any>(
    @LayoutRes private val layoutResId: Int,
    diffCallback: DiffUtil.ItemCallback<T>,
    private val itemClickListener: ItemClickListener? = null,
) : PagingDataAdapter<T, BaseViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        BaseViewHolder.create(layoutResId, parent)

    override fun onBindViewHolder(viewHolder: BaseViewHolder, position: Int) {
        getItem(position)?.let { viewHolder.bind(it, itemClickListener) }
    }
}