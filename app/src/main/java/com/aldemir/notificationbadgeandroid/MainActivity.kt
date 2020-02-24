package com.aldemir.notificationbadgeandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.MenuItemCompat

class MainActivity : AppCompatActivity() {

    private lateinit var sms_action: MenuItem
    private lateinit var textCartItemCount: TextView
    private lateinit var icon_sms: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.home, menu)

        sms_action = menu.findItem(R.id.action_sms)

        val actionView: View = MenuItemCompat.getActionView(sms_action)
        textCartItemCount =  actionView.findViewById(R.id.cart_badge) as TextView
        icon_sms =  actionView.findViewById(R.id.icon_sync) as ImageView

        actionView.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                Log.w("testeBadgeSync", "clicou em sincronizar")
            }

        })

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_sms)
            item.icon = getDrawable(R.drawable.ic_sms_black_24dp)
        return super.onOptionsItemSelected(item)
    }
}
