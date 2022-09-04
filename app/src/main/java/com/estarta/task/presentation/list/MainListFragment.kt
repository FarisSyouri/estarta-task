package com.estarta.task.presentation.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.estarta.task.R
import androidx.databinding.library.baseAdapters.BR
import com.estarta.task.databinding.FragmentItemListBinding
import com.estarta.task.presentation.utils.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import com.estarta.task.domain.model.Item
import com.estarta.task.presentation.adapter.ItemsListAdapter
import com.estarta.task.presentation.utils.OnItemClickCallback

@AndroidEntryPoint
class MainListFragment : BaseFragment<MainListViewModel>() {


    override val layoutResId = R.layout.fragment_item_list
    override val dataBindingEnabled = true
    override val mViewModel: MainListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel.getItems()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleObservers()

    }
    private fun handleObservers() {
        mViewModel.itemsList.observe(viewLifecycleOwner) {
            handleViews(it)
        }
    }
    private fun handleViews(items : List<Item>){
        bind<FragmentItemListBinding> {
            setVariable(BR.viewModel,mViewModel)
            viewDataBinding = this
            list.adapter = ItemsListAdapter(items,object: OnItemClickCallback{
                override fun onItemClicked(view: View, listableItem: Any, position: Int) {

                    navigateToFragment(
                        MainListFragmentDirections.actionMainListFragmentToItemDetailsFragment(
                            listableItem as Item
                        )
                    )

                }
            })
        }
    }


}