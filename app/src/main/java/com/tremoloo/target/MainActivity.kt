package com.tremoloo.target

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.payfort.fort.android.sdk.base.callbacks.FortCallBackManager
import com.tremoloo.R
import com.tremoloo.payfort.IPaymentRequestCallBack
import com.tremoloo.payfort.PayFortData
import com.tremoloo.payfort.PayFortPayment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.include_empty_targets.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(mainToolbar)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setIcon(R.drawable.oval)

        title = ""
        val data = ArrayList<TargetItem>()
        repeat(5) {
            data.add(TargetItem("mini copper", R.drawable.ic_sport_car, 2000F, 300F))
        }

        targedsRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = TargetsAdapter(this@MainActivity, data)
        }

//        targedsRecyclerView.visibility = View.GONE
        emptyTargetsInclude.visibility = View.GONE

        targedSeekBar.isEnabled = false
        targedSeekBar.setProgress(2000F)
        addTargetButton.setOnClickListener {
            //            requestForPayfortPayment()
            startActivity(Intent(this@MainActivity, AddTargetActivity::class.java))
        }
    }






    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.getItemId()


        if (id == R.id.action_add) {
            startActivity(Intent(this@MainActivity, AddTargetActivity::class.java))
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}
