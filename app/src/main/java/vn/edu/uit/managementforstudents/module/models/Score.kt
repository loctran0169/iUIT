package vn.edu.uit.managementforstudents.module.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ScoreTerm(
    @Expose
    @SerializedName("idTerm")
    var idTerm : Int?,
    @Expose
    @SerializedName("nameTerm")
    var nameTerm : String?,
    @SerializedName("list")
    var scores : List<Score>
)

data class Score(
    @Expose
    @SerializedName("MaMH")
    val MaMH: String?,
    @Expose
    @SerializedName("TenMH")
    val TenMH: String?,
    @Expose
    @SerializedName("TC")
    val TC: String?,
    @Expose
    @SerializedName("QT")
    val QT: String?,
    @Expose
    @SerializedName("TH")
    val TH: String?,
    @Expose
    @SerializedName("GK")
    val GK: String?,
    @Expose
    @SerializedName("CK")
    val CK: String?,
    @Expose
    @SerializedName("TB")
    val TB: String?
)