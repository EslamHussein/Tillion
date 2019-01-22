package com.tremoloo.payfort

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.tremoloo.R
import com.tremoloo.offer.OfferItem
import kotlinx.android.synthetic.main.fragment_payment.*


interface PayOnClick {
    fun onCash()
    fun onInstalments()
}

class PaymentDialogFragment : DialogFragment() {


    private var onClick: PayOnClick? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_payment, container)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        onClick = context as PayOnClick

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setStyle(STYLE_NO_FRAME, android.R.style.Theme_Holo_Light);

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val offer = arguments?.getParcelable<OfferItem>("offer")

        dialog?.setTitle("MINI Coper")

        discountPerTextView.text = "${offer?.discount} OFF"
        offerImageView.setImageResource(offer?.image ?: com.tremoloo.R.drawable.mini_cooper_1)
        sellerTextView.text = offer?.seller
        offerPriceTextView.text = offer?.price.toString()


        cashButton.setOnClickListener {
            onClick?.onCash()
        }

        instalmentsButton.setOnClickListener {
            onClick?.onInstalments()

        }

    }

    companion object {

        fun newInstance(offer: OfferItem): PaymentDialogFragment {
            val frag = PaymentDialogFragment()
            val args = Bundle()
            args.putParcelable("offer", offer)
            frag.arguments = args
            return frag
        }
    }
}// Empty constructor is required for DialogFragment
// Make sure not to add arguments to the constructor
// Use `newInstance` instead as shown below