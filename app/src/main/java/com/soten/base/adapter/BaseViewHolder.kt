package com.soten.base.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import com.soten.base.adapter.listener.ItemClickListener

open class BaseViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

    open fun <T> bind(item: T?, itemClickListener: ItemClickListener? = null) {
        binding.setVariable(BR.item, item)
        itemClickListener?.let { binding.setVariable(BR.callback, itemClickListener) }
        binding.executePendingBindings()
    }

    companion object {
        fun create(
            viewType: Int,
            parent: ViewGroup
        ) = BaseViewHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context), viewType, parent, false
                )
            )

    }
}

