package com.example.contactlistviewer

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

class ContactViewHOlder(val root: View) : RecyclerView.ViewHolder(root) {
    val ContactFirstName: TextView = root.contact_name
    val ContactLastName: TextView = root.contact_phone_number
}