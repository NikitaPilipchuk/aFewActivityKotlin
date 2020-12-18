package com.example.booksappkotlin

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val list = mutableListOf<Books>()
    lateinit var recyclerView: RecyclerView;
    lateinit var inte: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView= findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = BooksAdapter(list)
    }

    fun onButtinClick(v: View?) {
        val book_name = findViewById<View>(R.id.editName) as EditText
        val book_author = findViewById<View>(R.id.editAuthor) as EditText
        val book_year = findViewById<View>(R.id.editYear) as EditText
        val book_genre = findViewById<View>(R.id.editGenre) as EditText
        list.add(
            Books(
                book_name.text.toString(),
                book_author.text.toString(),
                book_year.text.toString().toInt(),
                book_genre.text.toString()
            )
        )
        recyclerView.adapter?.notifyDataSetChanged();
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        when (item.itemId) {
            R.id.about -> {
                inte = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(inte)
            }
            R.id.close -> finishAffinity()
        }
        return true
    }


}