package com.soten.base.example

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.soten.base.BaseFragment
import com.soten.base.BaseItem
import com.soten.base.BaseItemDiffUtil
import com.soten.base.R
import com.soten.base.adapter.BaseListAdapter
import com.soten.base.adapter.listener.BaseItemClickListener
import com.soten.base.databinding.FragmentHomeBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home),
    BaseItemClickListener {

    private val itemAdapter = BaseListAdapter(BaseItemDiffUtil(), R.layout.item_base, this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.baseRecyclerView.adapter = itemAdapter

        val sampleItems = listOf(BaseItem("최윤호"))

        itemAdapter.submitList(sampleItems)
    }

    override fun onClickItem(item: BaseItem) {
        // 클릭 이벤트
        Toast.makeText(requireContext(), "${item.content}", Toast.LENGTH_SHORT).show()
    }
}