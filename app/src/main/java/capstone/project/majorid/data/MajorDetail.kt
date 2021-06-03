package capstone.project.majorid.data

import androidx.lifecycle.ViewModel

class MajorDetail: ViewModel() {
    private lateinit var social: String
    private lateinit var science: String

    fun setScience(id:String){
        this.science = id
    }

    fun setSocial(id:String){
        this.social = id
    }

    private fun getScience() : ArrayList<Major> =
        MajorData.listDataScience() as ArrayList<Major>
    private fun getSocial() : ArrayList<Major> =
        MajorData.listDataSocial() as ArrayList<Major>

    fun getSciencebyID(): Major {
        lateinit var res: Major
        val listScience = getScience()
        for (major in listScience){
            if (major.id == science) {
                res = major
                break
            }
        }
        return res
    }

    fun getSocialbyID(): Major {
        lateinit var res: Major
        val listSocial = getSocial()
        for (major in listSocial){
            if (major.id == social){
                res = major
                break
            }
        }
        return res
    }
}