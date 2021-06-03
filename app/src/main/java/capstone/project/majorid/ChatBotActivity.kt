package capstone.project.majorid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import capstone.project.majorid.adapter.AdapterChat
import capstone.project.majorid.data.ChatModel
import kotlinx.android.synthetic.main.activity_chat_bot.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ChatBotActivity : AppCompatActivity() {
    private val adapterChat = AdapterChat()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_bot)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://explorer-chatbot-jeru2aubpa-et.a.run.app/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(APIService::class.java)
        chat_rv.layoutManager = LinearLayoutManager(this)
        chat_rv.adapter = adapterChat

        chat_btn.setOnClickListener{
            if (chat_et.text.isNullOrEmpty()){
                Toast.makeText(this@ChatBotActivity, "Please enter a text!", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            adapterChat.addChatToList(ChatModel(chat_et.text.toString()))
            apiService.chatWithTheBot(chat_et.text.toString()).enqueue(callBack)
            chat_et.text.clear()
        }

    }

    private val callBack = object : Callback<ChatResponse>{
        override fun onResponse(call: Call<ChatResponse>, response: Response<ChatResponse>) {
            if (response.isSuccessful && response.body()!= null){
                adapterChat.addChatToList(ChatModel(response.body()!!.chatBotReply, true))
            }else{
                Toast.makeText(this@ChatBotActivity, "Something went wrong", Toast.LENGTH_LONG).show()
            }
        }

        override fun onFailure(call: Call<ChatResponse>, t: Throwable) {

        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.email, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.email -> {
                val mIntent = Intent(this, EmailActivity::class.java)
                startActivity(mIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}