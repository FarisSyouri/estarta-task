package com.estarta.task.presentation.details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.estarta.task.R
import com.estarta.task.databinding.FragmentItemListBinding
import com.estarta.task.presentation.utils.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import androidx.databinding.library.baseAdapters.BR;
import androidx.navigation.fragment.navArgs
import com.estarta.task.databinding.FragmentItemDetailsBinding
import com.estarta.task.domain.model.Item
import com.estarta.task.presentation.adapter.ItemsListAdapter
import com.estarta.task.presentation.list.MainListViewModel
import com.estarta.task.presentation.utils.OnItemClickCallback

@AndroidEntryPoint
class ItemDetailsFragment : BaseFragment<ItemDetailsViewModel>() {


    override val layoutResId = R.layout.fragment_item_details
    override val dataBindingEnabled = true
    override val mViewModel: ItemDetailsViewModel by viewModels()
    private val args: ItemDetailsFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleViews()
    }

    private fun handleViews() {
        bind<FragmentItemDetailsBinding> {
            setVariable(BR.item, args.item)
        }
    }


}