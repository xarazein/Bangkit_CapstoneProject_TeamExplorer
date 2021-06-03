package capstone.project.majorid.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import capstone.project.majorid.R
import capstone.project.majorid.adapter.AdapterMajor
import capstone.project.majorid.data.Click
import capstone.project.majorid.data.Major
import capstone.project.majorid.data.MajorView
import kotlinx.android.synthetic.main.fragment_social.*

class Social : Fragment(),Click {
    private lateinit var mm : MajorView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_social, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.let {
            mm = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[MajorView::class.java]
        }
        val listdatasocial = mm.getSocial()
        setSocial(listdatasocial)
    }

    private fun setSocial(major: List<Major>) {
        social_rv.apply {
            layoutManager = LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL,false)
            adapter = AdapterMajor(this@Social)
        }.also {
            it.adapter.let { adapter ->
                when (adapter){
                    is AdapterMajor -> {
                        adapter.setData(major)
                    }
                }
            }
        }
    }

    override fun clickMajor(major: Major) {
    }


}