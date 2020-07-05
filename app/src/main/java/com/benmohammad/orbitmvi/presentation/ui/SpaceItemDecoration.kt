package com.benmohammad.orbitmvi.presentation.ui

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class SpaceItemDecoration(
    private val horizontalSpacing: Int = 0,
    private val verticalSpacing: Int = 0,
    private val isHorizontal: Boolean = false
): RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)
        val size =   parent.adapter?.itemCount

        val isFirstItem = position == 0
        val isLastItem = position + 1 == size

        if(position == -1) return

        assignItemOffsets(outRect, isFirstItem, isLastItem)
    }

    private fun assignItemOffsets(outRect: Rect, isFirstItem: Boolean, isLastITem: Boolean) {
        outRect.left = if(!isHorizontal || isFirstItem) horizontalSpacing else horizontalSpacing / 2
        outRect.right = if(!isHorizontal || isLastITem) horizontalSpacing else horizontalSpacing / 2
        outRect.top = if(isHorizontal || isFirstItem) verticalSpacing else verticalSpacing / 2
        outRect.bottom = if(isHorizontal || isLastITem) verticalSpacing else verticalSpacing / 2
    }
}