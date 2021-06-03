package capstone.project.majorid.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Major(
    var id : String,
    var title: String
): Parcelable
