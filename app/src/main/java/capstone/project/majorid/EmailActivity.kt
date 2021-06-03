package capstone.project.majorid

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_email.*
import java.lang.Exception

class EmailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email)

        email_btn1.setOnClickListener{
            val recipient = email_et1.text.toString().trim()
            val subject = email_et2.text.toString().trim()
            val message = email_et3.text.toString().trim()

            sendEmail(recipient, subject, message)
        }
    }

    private fun sendEmail(recipient: String, subject: String, message: String) {
        val mIntent = Intent(Intent.ACTION_SEND)
        mIntent.data = Uri.parse("mailto: ")
        mIntent.type = "text/plain"

        mIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
        mIntent.putExtra(Intent.EXTRA_SUBJECT, arrayOf(subject))
        mIntent.putExtra(Intent.EXTRA_TEXT, arrayOf(message))

        try {
            startActivity(Intent.createChooser(mIntent, "Choose Email Client..."))
        }
        catch(e:Exception){
            Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
        }
    }
}