package capstone.project.majorid.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import capstone.project.majorid.R
import capstone.project.majorid.data.ChatModel
import kotlinx.android.synthetic.main.list_chat.view.*
import java.util.ArrayList

class AdapterChat : RecyclerView.Adapter<AdapterChat.MyViewHolder> (){
    private val list = ArrayList<ChatModel>()
    inner class MyViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(LayoutInflater.from(parent.context). inflate(R.layout.list_chat, parent,false)) {
        fun bind(chat: ChatModel) = with(itemView){
            if(!chat.isBot) {
                list_tv1.setTextColor(Color.BLACK)
                list_tv1.text = chat.chat
            }else{
                list_tv1.setBackgroundColor(Color.LTGRAY)
                list_tv1.setTextColor(Color.BLACK)
                list_tv1.text = chat.chat
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(parent)

    override fun onBindViewHolder(holder: AdapterChat.MyViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size
    fun addChatToList(chat: ChatModel) {
        list.add(chat)
        notifyDataSetChanged()

    }
}