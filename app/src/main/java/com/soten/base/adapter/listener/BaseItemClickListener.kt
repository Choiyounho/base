package com.soten.base.adapter.listener

import com.soten.base.BaseItem

interface BaseItemClickListener : ItemClickListener {

    fun onClickItem(item: BaseItem)
}