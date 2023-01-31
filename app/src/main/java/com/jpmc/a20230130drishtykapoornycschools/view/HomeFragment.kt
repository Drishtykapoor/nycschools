package com.jpmc.a20230130drishtykapoornycschools.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.PopupMenu
import androidx.recyclerview.widget.LinearLayoutManager
import com.jpmc.a20230130drishtykapoornycschools.R
import com.jpmc.a20230130drishtykapoornycschools.adapter.VerticalMarginDecorator
import com.jpmc.a20230130drishtykapoornycschools.databinding.HomeFragmentBinding
import com.jpmc.a20230130drishtykapoornycschools.presenter.HomePresenter
import com.jpmc.a20230130drishtykapoornycschools.presenter.SortOrder
import dagger.android.support.DaggerFragment
import javax.inject.Inject


class HomeFragment : DaggerFragment(), HomeFragmentViewInterface,
    PopupMenu.OnMenuItemClickListener {

    private lateinit var binding: HomeFragmentBinding

    @Inject
    lateinit var presenter: HomePresenter


    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HomeFragmentBinding.inflate(inflater, container, false)
        binding.recyclerview.layoutManager = LinearLayoutManager(context)
        binding.recyclerview.adapter = presenter.getSchoolListAdapter()
        binding.recyclerview.addItemDecoration(
            VerticalMarginDecorator(resources.getDimensionPixelSize(R.dimen.margin_small))
        )
        binding.sort.setOnClickListener { showPopup(it) }
        return binding.root
    }


    override fun onResume() {
        super.onResume()
        presenter.getData(this)
    }

    private fun showPopup(v: View) {
        context?.let {
            val popup = PopupMenu(it, v)
            val inflater: MenuInflater = popup.menuInflater
            inflater.inflate(R.menu.sort_menu, popup.menu)
            popup.setOnMenuItemClickListener(this)
            popup.show()
        }
    }

    override fun onMenuItemClick(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.ascending -> {
                presenter.sortData(SortOrder.Ascending)
                true
            }
            R.id.descending -> {
                presenter.sortData(SortOrder.Descending)
                true
            }
            else -> false
        }
    }

    override fun setError(data: String) {
        TODO("Not yet implemented")
    }
}