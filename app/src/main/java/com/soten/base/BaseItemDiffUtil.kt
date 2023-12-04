package com.soten.base

import androidx.recyclerview.widget.DiffUtil

class BaseItemDiffUtil : DiffUtil.ItemCallback<BaseItem>() {

    override fun areItemsTheSame(oldItem: BaseItem, newItem: BaseItem): Boolean {
        return oldItem.content == newItem.content
    }

    override fun areContentsTheSame(oldItem: BaseItem, newItem: BaseItem): Boolean {
        return oldItem == newItem
    }
}