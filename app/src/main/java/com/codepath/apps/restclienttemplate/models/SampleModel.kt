package com.codepath.apps.restclienttemplate.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.json.JSONException
import org.json.JSONObject

/*
* This is a temporary, sample model that demonstrates the basic structure
* of a SQLite persisted Model object. Check out the Room guide for more details:
* https://github.com/codepath/android_guides/wiki/Room-Guide
*
*/
@Entity
class SampleModel(jsonObject: JSONObject? = null) {
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null

    // Define table fields
    @ColumnInfo
    var name: String? = null

    init {
        // Parse model from JSON
        try {
            name = jsonObject?.getString("title")
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }
}