package be.bxl.will.demoandroid.models

data class Media(
    var type : String,
    var title : String,
    var description : String,
    var duree : Long,
    var id : Int?
) : java.io.Serializable
