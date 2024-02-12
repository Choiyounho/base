package com.soten.base.adapter

import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.soten.base.adapter.listener.ItemClickListener

open class BaseAdapter(
    @LayoutRes private val layoutResId: Int,
    private val itemClickListener: ItemClickListener? = null,
) : RecyclerView.Adapter<BaseViewHolder>() {

    protected val items = mutableListOf<Any>()

    open fun replaceAll(items: List<Any>?) {
        items ?: return
        this.items.run {
            clear()
            addAll(items)
        }

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        BaseViewHolder.create(layoutResId, parent)

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(items[position], itemClickListener)
    }

    override fun getItemCount(): Int = items.size
}
