package com.arca.bottomsheetdemo

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.content_bottom_sheet.*
import kotlinx.android.synthetic.main.fragment_first.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private lateinit var sheetBehavior: BottomSheetBehavior<View>

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sheetBehavior = BottomSheetBehavior.from(comments_sheet)

        sheetBehavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(sheet: View, slideOffset: Float) {

            }

            @SuppressLint("LogNotTimber")
            override fun onStateChanged(sheet: View, newState: Int) {
                when (newState) {
                    BottomSheetBehavior.STATE_EXPANDED -> {
                        Log.e(TAG, "Bottom sheet expanded")
                    }
                    BottomSheetBehavior.STATE_HIDDEN -> {
                        Log.e(TAG, "Bottom sheet hidden")
                    }
                    BottomSheetBehavior.STATE_COLLAPSED -> {
                        Log.e(TAG, "Bottom sheet collapsed")
                    }
                    BottomSheetBehavior.STATE_DRAGGING -> {
                        Log.e(TAG, "Bottom sheet is being dragged")
                    }
                    BottomSheetBehavior.STATE_HALF_EXPANDED -> {
                        Log.e(TAG, "Bottom sheet is half expanded")
                    }
                    BottomSheetBehavior.STATE_SETTLING -> {
                        Log.e(TAG, "Bottom sheet is settling")
                    }
                }
            }

        })
        hideBottomSheet()
        button_first.setOnClickListener {
            //findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            showBottomSheet()
        }
        close_btn.setOnClickListener {
            hideBottomSheet()
        }
    }

    private fun showBottomSheet() {
        //TODO (Andy): Run initial setup here
        with(sheetBehavior){
            isHideable = false
            state = BottomSheetBehavior.STATE_COLLAPSED
        }
    }

    private fun hideBottomSheet() {
        if(!sheetBehavior.isHideable) {
            //TODO (Andy): Handle whatever clean ups necessary
        }
        with(sheetBehavior) {
            isHideable = true;
            state = BottomSheetBehavior.STATE_HIDDEN
        }
    }

    companion object {
        private val TAG: String = FirstFragment::class.java.simpleName
    }
}