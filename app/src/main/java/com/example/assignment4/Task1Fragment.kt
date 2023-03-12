package com.example.assignment4

import MovieData
import MovieList
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter
import jp.wasabeef.recyclerview.animators.SlideInRightAnimator


class Task1Fragment : AppCompatActivity(), MovieAdapter.ClickListener {
    private lateinit var adapter:MovieAdapter
    @SuppressLint("NotifyDataSetChanged")
    val movies = MovieList().getMovieData().toMutableList()
    private val images = MovieList().getImageData()

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_task1)
        val toolbar = findViewById<Toolbar>(R.id.include)
        toolbar.title = "TASK 1"
        setSupportActionBar(toolbar)
        adapter = MovieAdapter(movies,images)
        adapter.setClickListener(this)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.itemAnimator = SlideInRightAnimator()
        recyclerView.adapter = ScaleInAnimationAdapter(adapter)
        recyclerView.setHasFixedSize(false)

        val selectAll = findViewById<Button>(R.id.select_all)
        val deleteButton = findViewById<Button>(R.id.delete)
        val clearAll = findViewById<Button>(R.id.clear_all)

        selectAll.setOnClickListener {
            adapter.setSelectAll()
            adapter.notifyDataSetChanged()
            recyclerView.swapAdapter(adapter,true)
            recyclerView.scrollBy(0, 0)
        }

        clearAll.setOnClickListener {
            adapter.setClearAll()
            adapter.notifyDataSetChanged()
            recyclerView.swapAdapter(adapter,true)
            recyclerView.scrollBy(0, 0)
        }

        deleteButton.setOnClickListener {
            var cnt = 0
            for(i in 0 until movies.size)
                if(movies[i].checked!!)
                    cnt += 1
            for(i in 0 until cnt) {
                for (j in movies.indices) {
                    if (movies[j].checked == true) {
                        movies.removeAt(j)
                        adapter.notifyItemRemoved(j)
                        break
                    }
                }
            }
        }

        val button = findViewById<Button>(R.id.goBackToTitleMovie)
        button.setOnClickListener {
            if (supportFragmentManager.findFragmentByTag("movie") != null &&
                supportFragmentManager.findFragmentByTag("movie")!!.isVisible){
                val intent = Intent(this,Task1Fragment::class.java)
                startActivity(intent)
            }else{
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }

        }
    }

    override fun onItemClicked(movie: MovieData) {
        supportFragmentManager.beginTransaction().replace(R.id.page,MovieFragment(movie),"movie").commit()
    }

    override fun onLongClick(movie: MovieData, position: Int) {
        movies.add(position+1,movie)
        adapter.notifyItemInserted(position+1)
    }

}