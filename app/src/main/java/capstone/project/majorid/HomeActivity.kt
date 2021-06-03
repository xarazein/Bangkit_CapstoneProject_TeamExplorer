package capstone.project.majorid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import capstone.project.majorid.pager.SectionPager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val sectionPager = SectionPager(this, supportFragmentManager)
        home_pager1.adapter = sectionPager
        home_tabs.setupWithViewPager(home_pager1)

        val fab = findViewById<FloatingActionButton>(R.id.home_fab)
        fab.setOnClickListener {
            val intent = Intent(this, ChatBotActivity::class.java)
            startActivity(intent)
        }
    }
}