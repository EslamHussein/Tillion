package com.tremoloo.offer

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class OfferItem(val image: Int, val seller: String, val price: Float, val discount: Float) : Parcelable