package com.tremoloo.boost


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.tremoloo.R
import kotlinx.android.synthetic.main.fragment_all_people.*


/**
 * A simple [Fragment] subclass.
 * Use the [AllPeopleFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class AllPeopleFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_people, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data = ArrayList<BoostItem>()
        data.add(BoostItem(R.drawable.ic_sport_car, "Ahmed Mahmoud", "+201012182381"))
        data.add(BoostItem(R.drawable.ic_sport_car, "Eslam Hussein", "+201012182381"))
        data.add(BoostItem(R.drawable.ic_sport_car, "Abeer El-Sayed", "+201012182381"))
        data.add(BoostItem(R.drawable.ic_sport_car, "Hussein Gaber", "+201012182381"))
        data.add(BoostItem(R.drawable.ic_sport_car, "Mohamed Khalifa", "+201012182381"))
        data.add(BoostItem(R.drawable.ic_sport_car, "Ahmed Mahmoud", "+201012182381"))
        data.add(BoostItem(R.drawable.ic_sport_car, "Eslam Hussein", "+201012182381"))
        data.add(BoostItem(R.drawable.ic_sport_car, "Abeer El-Sayed", "+201012182381"))
        data.add(BoostItem(R.drawable.ic_sport_car, "Hussein Gaber", "+201012182381"))
        data.add(BoostItem(R.drawable.ic_sport_car, "Mohamed Khalifa", "+201012182381"))


        boostsRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = AllPeopleAdapter("INVITE", context, data) {


            }
        }
    }


    companion object {
        @JvmStatic
        fun newInstance() =
            AllPeopleFragment()
    }
}
