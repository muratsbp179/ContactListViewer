package com.example.contactlistviewer

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

const val MY_PERMISSIONS_REQUEST_READ_CONTACTS: Int = 1

val PERMISSIONS_CONTACT = arrayOf(Manifest.permission.READ_CONTACTS)

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getSupportActionBar()?.hide()

        fun AppCompatActivity.isPermissionGranted(permission: String) =
            ActivityCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED

        //if no
        if (!isPermissionGranted(Manifest.permission.READ_CONTACTS)) {
            ActivityCompat.requestPermissions(this@MainActivity, // Контекст
                arrayOf(Manifest.permission.READ_CONTACTS), // Что спрашиваем
                MY_PERMISSIONS_REQUEST_READ_CONTACTS)

        } //if yes
        else {
            showContactsList()
        }
    }


    fun showContactsList(){
        val contactss: List<Contact> = fetchAllContacts()
        my_recycler_view.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = ContactListAdapter(contactss) {
                startActivity(Intent(Intent.ACTION_DIAL).apply {
                    data = Uri.parse("tel:${it.phoneNumber}")
                })
            }
            Toast
                .makeText(
                    this@MainActivity,
                    getString(R.string.count, contactss.size),
                    Toast.LENGTH_SHORT
                ).show()

        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode){
            MY_PERMISSIONS_REQUEST_READ_CONTACTS -> {
                //give permission
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    showContactsList()
                } else {
                    Toast
                        .makeText(
                            this@MainActivity,
                            getString(R.string.count1),
                            Toast.LENGTH_SHORT
                        ).show()
                }
                return
            }
            else -> {
                super.onRequestPermissionsResult(requestCode, permissions, grantResults)
            }
        }

    }


}

