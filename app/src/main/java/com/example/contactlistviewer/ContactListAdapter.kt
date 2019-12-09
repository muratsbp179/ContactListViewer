package com.example.contactlistviewer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

//class ContactListAdapter(
//    private val  contacts: List<Contact>,
//    val onClick: (Contact) -> Unit
//) : RecyclerView.Adapter<ContactViewHOlder>() {
//
//    //when need new viewHolder
////    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHOlder {
////        return ContactViewHOlder(
////            LayoutInflater.from(parent.context).inflate(
////                R.layout.list_item,
////                parent,
////                false
////            )
////        ).apply {
////            root.setOnClickListener {
////                    onClick(contacts[adapterPosition])
////            }
////        }
////    }
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHOlder {
//        return ContactViewHOlder(
//            LayoutInflater.from(parent.context).inflate(
//                R.layout.list_item,
//                parent,
//                false
//            )
//        ).apply {
//            root.setOnClickListener {
//                onClick(contacts[adapterPosition])
//            }
//        }
//    }
//
//    //when new data && do new ItemView
//    override fun onBindViewHolder(holder: ContactViewHOlder, position: Int) {
//        holder.ContactFirstName.text = contacts[position].name
//        holder.ContactSecondName.text = contacts[position].phoneNumber
//    }
//
//    //count
//    override fun getItemCount(): Int = contacts.size
//}

class ContactListAdapter(
    private val contacts: List<Contact>,
    val onClick: (Contact) -> Unit
) : RecyclerView.Adapter<ContactViewHOlder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHOlder {
         val holder = ContactViewHOlder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_item,
                parent,
                false
            )
        )
        holder.root.setOnClickListener {
                onClick(contacts[holder.adapterPosition])
        }
        return holder
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(holder: ContactViewHOlder, position: Int) {
        holder.ContactFirstName.text = contacts[position].name
        holder.ContactLastName.text = contacts[position].phoneNumber
    }

}