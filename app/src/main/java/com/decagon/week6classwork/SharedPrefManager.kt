package com.decagon.week6classwork

import com.google.gson.Gson

class SharedPrefManager(val sharedPrefs: HashMap<String, String>) {
   var gson: Gson = Gson()

    fun clearData() {
        sharedPrefs.clear()
    }

    fun <T> saveData(user: T?, key: String): ArrayList<String> {
        val result:ArrayList<String>
        val userJson = gson.toJson(user)
        result = arrayListOf(userJson)
        sharedPrefs[key] = userJson
        return result
    }

    fun <T> keepData(user: T?, key: String) {
        val userJson = gson.toJson(user)
        sharedPrefs[key] = userJson
    }

    fun getUserData(user:String): User? {
        return gson.fromJson(user, User::class.java)
    }


    fun checkUser(key: String): User? {
        return getUserData("")
    }


    fun <T> clearByKey(key: String): Boolean {
        val data = sharedPrefs.contains(key)
        if (data){
            sharedPrefs.remove(key)
            return data
        }
        return false
    }
}