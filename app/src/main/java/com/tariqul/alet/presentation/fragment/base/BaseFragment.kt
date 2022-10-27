package com.tariqul.alet.presentation.fragment.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VM : BaseViewModel, VB : ViewBinding>(
    @LayoutRes contentLayoutId: Int
) : Fragment(contentLayoutId) {

    private var _binding: VB? = null
    protected val binding: VB
        get() = _binding!!

    protected abstract val viewModel: VM

    companion object {
        const val TAG = "BaseFragment"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = initializeViewBinding(view)

//        view.findViewById<ShapeableImageView>(R.id.ivBack)?.setOnClickListener {
////            findNavController().navigateUp()
//            requireActivity().onBackPressed()
//        }
//
//        viewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
//            isLoading ?: return@observe
//            if (isLoading) {
//                view.findViewById<LinearProgressIndicator>(R.id.piLoading)?.show()
//            } else {
//                view.findViewById<LinearProgressIndicator>(R.id.piLoading)?.hide()
//            }
//        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    protected abstract fun initializeViewBinding(view: View): VB


}