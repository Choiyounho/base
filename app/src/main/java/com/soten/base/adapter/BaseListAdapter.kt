package com.soten.base.adapter

import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.soten.base.adapter.listener.ItemClickListener

open class BaseListAdapter<T>(
    diffUtil: DiffUtil.ItemCallback<T>,
    @LayoutRes private val layoutRes: Int,
    private val itemClickListener: ItemClickListener? = null,
) : ListAdapter<T, BaseViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        BaseViewHolder.create(layoutRes, parent)

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(getItem(position), itemClickListener)
    }
}