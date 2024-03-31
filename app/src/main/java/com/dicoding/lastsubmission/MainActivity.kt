package com.dicoding.lastsubmission

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvKeyboard: RecyclerView
    private val list = ArrayList<Keyboard>()

    companion object {
        const val KEY_KEYBOARD = "key_keyboard"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvKeyboard = findViewById(R.id.rv_keyboard)
        rvKeyboard.setHasFixedSize(true)

        list.addAll(listKeyboard)
        showRecyclerList()
    }


    private val listKeyboard: ArrayList<Keyboard>
        get() {
            val dataName = resources.getStringArray(R.array.data_name)
            val dataDescription = resources.getStringArray(R.array.data_description)
            val dataPrice = resources.getStringArray(R.array.data_price)
            val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
            val listKeyboard = ArrayList<Keyboard>()
            for (i in dataName.indices) {
                val keyboard = Keyboard(dataName[i], dataDescription[i], dataPrice[i],dataPhoto.getResourceId(i,-1))
                listKeyboard.add(keyboard)
            }
            return listKeyboard
        }

    private fun moveToAboutPage () {
        val movePage = Intent(this@MainActivity, AboutMe::class.java)
        startActivity(movePage)
    }
    private fun showRecyclerList() {
        rvKeyboard.layoutManager = LinearLayoutManager(this)
        val listKeyboardAdapter = ListKeyboardAdapter(list)
        rvKeyboard.adapter = listKeyboardAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.about_page -> {
                moveToAboutPage()
            }
        }

        return super.onOptionsItemSelected(item)
    }

    

}