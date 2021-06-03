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
import kotlinx.android.synthetic.main.fragment_science.*

class Science : Fragment(), Click{
    private lateinit var mm : MajorView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_science, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.let {
            mm = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[MajorView::class.java]
        }
        val listdatascience = mm.getScience()
        setScience(listdatascience)
    }

    private fun setScience(major: List<Major>) {
        science_rv.apply {
            layoutManager = LinearLayoutManager(context,
                LinearLayoutManager.VERTICAL, false)
            adapter = AdapterMajor(this@Science)
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