package com.tremoloo.boost


import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.tremoloo.R
import kotlinx.android.synthetic.main.activity_boost.*
import kotlinx.android.synthetic.main.fragment_boost.view.*

class BoostActivity : AppCompatActivity() {

    /**
     * The [androidx.viewpager.widget.PagerAdapter] that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * androidx.fragment.app.FragmentStatePagerAdapter.
     */
    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_boost)
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        setSupportActionBar(boostToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        supportActionBar?.setDisplayShowHomeEnabled(true);

        title = getString(R.string.boost_from_people)

        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)

        // Set up the ViewPager with the sections adapter.
        container.adapter = mSectionsPagerAdapter
        sliding_tabs.setupWithViewPager(container)


    }


    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return when (position) {
                0 -> {
                    OnBillionFragment.newInstance()
                }
                else -> {
                    AllPeopleFragment.newInstance()
                }
            }
        }

        override fun getCount(): Int {
            // Show 3 total pages.
            return 2
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return when (position) {
                0 -> return "Friends On Tillion"
                else -> return "All"
            }

        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    class PlaceholderFragment : Fragment() {

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            val rootView = inflater.inflate(R.layout.fragment_boost, container, false)
            rootView.section_label.text = getString(R.string.section_format, arguments?.getInt(ARG_SECTION_NUMBER))
            return rootView
        }

        companion object {
            /**
             * The fragment argument representing the section number for this
             * fragment.
             */
            private val ARG_SECTION_NUMBER = "section_number"

            /**
             * Returns a new instance of this fragment for the given section
             * number.
             */
            fun newInstance(sectionNumber: Int): PlaceholderFragment {
                val fragment = PlaceholderFragment()
                val args = Bundle()
                args.putInt(ARG_SECTION_NUMBER, sectionNumber)
                fragment.arguments = args
                return fragment
            }
        }
    }
}
