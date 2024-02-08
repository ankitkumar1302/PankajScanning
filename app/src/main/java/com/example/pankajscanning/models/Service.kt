package com.example.pankajscanning.models

import com.example.pankajscanning.R

data class Service(
    val title: String,
    val image: Int
)

val servicesList = listOf(
    Service("Pathology", R.drawable.pathology),
    Service("Radiology", R.drawable.radiology),
//    Service("Cardiology", R.drawable.cardiology),
    Service("Pulmonary", R.drawable.pulmonary),
    Service("Neurological Investigation", R.drawable.nerological)
)