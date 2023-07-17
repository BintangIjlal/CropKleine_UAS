package com.pnj.cropexchange.user

import java.util.UUID

data class User(
    val name: String = "",
    val email: String = "",
    val password: String = "",
    var imagePath: String= ""
){
    constructor(): this("","","","")
}
