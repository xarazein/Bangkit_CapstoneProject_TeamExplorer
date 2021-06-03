package capstone.project.majorid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import capstone.project.majorid.R
import capstone.project.majorid.data.Click
import capstone.project.majorid.data.Major
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.list_major.view.*

class AdapterMajor(private val click: Click) : RecyclerView.Adapter<AdapterMajor.ListViewHolder>() {
    private val listMajor = ArrayList<Major>()

    fun setData(major:List<Major>?){
        if(major==null)
            return listMajor.clear()
        listMajor.addAll(major)
    }
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(major: Major){
            with(itemView){
                Glide.with(itemView.context)
                list_txt1.text = major.title
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_major, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listMajor[position])
    }

    override fun getItemCount(): Int = listMajor.size
}