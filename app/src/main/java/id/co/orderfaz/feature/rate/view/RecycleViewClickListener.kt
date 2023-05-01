package id.co.orderfaz.feature.rate.view

import android.view.View
import id.co.orderfaz.feature.rate.model.Location

interface RecycleViewClickListener {
    fun onItemClick(view: View, location:Location)
}