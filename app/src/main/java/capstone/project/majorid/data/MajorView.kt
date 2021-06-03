package capstone.project.majorid.data

import androidx.lifecycle.ViewModel

class MajorView: ViewModel() {
    fun getScience(): List<Major> = MajorData.listDataScience()
    fun getSocial(): List<Major> = MajorData.listDataSocial()
}