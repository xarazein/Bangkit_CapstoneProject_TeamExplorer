package capstone.project.majorid.pager

import android.content.Context
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import capstone.project.majorid.R
import capstone.project.majorid.fragment.Science
import capstone.project.majorid.fragment.Social

class SectionPager(private val context: Context, fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    private val title = intArrayOf(
        R.string.science,
        R.string.social
    )

    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        var frag : Fragment? = null
        when (position) {
            0-> frag = Science()
            1-> frag = Social()
        }
        return frag as Fragment
    }

    @Nullable
    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(title[position])
    }
}