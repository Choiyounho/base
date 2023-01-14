package com.soten.base.example

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
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

class HomeFragment : Fragment(), BaseItemClickListener {

    // onCreatedView를 했다고 가정
    private var _binding: FragmentHomeBinding? = null
    private val binding = _binding!!

    private val itemAdapter = BaseListAdapter(BaseItemDiffUtil(), R.layout.fragment_home, this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.baseRecyclerView.adapter = itemAdapter

        val sampleItems = listOf(BaseItem("최윤호"))

        itemAdapter.submitList(sampleItems)
    }

    override fun onClickItem(item: BaseItem) {
        // 클릭 이벤트
    }
}