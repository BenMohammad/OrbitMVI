package com.benmohammad.orbitmvi.presentation.ui

import com.benmohammad.orbitmvi.R
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item

class LogoItem: Item() {

    override fun bind(viewHolder: GroupieViewHolder, position: Int) = Unit

    override fun getLayout(): Int = R.layout.logo_item
}