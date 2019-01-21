package com.tremoloo.target

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TargetItem(val name: String, val image: Int, val price: Float, val savedAmount: Float):Parcelable
