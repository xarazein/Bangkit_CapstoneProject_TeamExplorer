package capstone.project.majorid

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface APIService {
    @FormUrlEncoded
    @POST("/api")
    fun chatWithTheBot(@Field("chatInput") chatText : String): Call<ChatResponse>
}

data class ChatResponse(val chatBotReply:String)