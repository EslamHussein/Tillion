package com.tremoloo.target

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.payfort.fort.android.sdk.base.callbacks.FortCallBackManager
import com.tremoloo.R
import com.tremoloo.offer.OfferItem
import com.tremoloo.offer.OffersAdapter
import com.tremoloo.payfort.IPaymentRequestCallBack
import com.tremoloo.payfort.PayFortData
import com.tremoloo.payfort.PayFortPayment
import com.tremoloo.payfort.PayOnClick
import kotlinx.android.synthetic.main.activity_targed_details.*

class TargetDetailsActivity : AppCompatActivity(), PayOnClick, IPaymentRequestCallBack {

    private var fortCallback: FortCallBackManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_targed_details)
        setSupportActionBar(targetDetailsToolbar)


        val data = intent.getParcelableExtra<TargetItem>("target")
        title = data.name

        fortCallback = FortCallBackManager.Factory.create()


        targetImageView.setImageResource(data.image)
        val percentage = ((data.savedAmount / data.price) * 100).toInt()

        targetNameTextView.text = data.name
        savedPeresantageTextView.text = "$percentage %"

        targetProgress.progress = percentage
        remainingTextView.text = (data.price - data.savedAmount).toString()
        targetPriceTextView.text = data.price.toString()
        remainingPersantageTextView.text = "${100 - percentage} to go!"

        val offers = ArrayList<OfferItem>()
        repeat(5) {

            offers.add(OfferItem(R.drawable.mini_cooper_1, "Ghabour Auto", 1000000F, 15F))
            offers.add(OfferItem(R.drawable.mini_cooper_2, "El-Tarek", 1120000F, 0F))

        }

        offersRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@TargetDetailsActivity)
            adapter = OffersAdapter(this@TargetDetailsActivity, offers)
        }

    }

    override fun onCash() {
        requestForPayfortPayment()
    }

    override fun onInstalments() {
        requestForPayfortPayment()
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PayFortPayment.RESPONSE_PURCHASE) {
            fortCallback?.onActivityResult(requestCode, resultCode, data);
        }
    }

    private fun requestForPayfortPayment() {
        val payFortData = PayFortData()
        payFortData.amount = (1.2 * 100).toInt()
            .toString()// Multiplying with 100, bcz amount should not be in decimal format
        payFortData.command = PayFortPayment.PURCHASE
        payFortData.currency = PayFortPayment.CURRENCY_TYPE
        payFortData.customerEmail = "readyandroid@gmail.com"
        payFortData.language = PayFortPayment.LANGUAGE_TYPE
        payFortData.merchantReference = System.currentTimeMillis().toString()
        val payFortPayment = PayFortPayment(this, this.fortCallback, this)
        payFortPayment.requestForPayment(payFortData)
    }

    override fun onPaymentRequestResponse(responseType: Int, responseData: PayFortData?) {

        when (responseType) {
            PayFortPayment.RESPONSE_GET_TOKEN -> {
                Toast.makeText(this, "Token not generated", Toast.LENGTH_SHORT).show();
                Log.e("onPaymentResponse", "Token not generated");
            }
            PayFortPayment.RESPONSE_PURCHASE_CANCEL -> {
                Toast.makeText(this, "Payment cancelled", Toast.LENGTH_SHORT).show();
                Log.e("onPaymentResponse", "Payment cancelled");
            }
            PayFortPayment.RESPONSE_PURCHASE_FAILURE -> {
                Toast.makeText(this, "Payment failed", Toast.LENGTH_SHORT).show();
                Log.e("onPaymentResponse", "Payment failed");
            }
            else -> {
                Toast.makeText(this, "Payment successful", Toast.LENGTH_SHORT).show();
                Log.e("onPaymentResponse", "Payment successful");
            }
        }
    }

}
