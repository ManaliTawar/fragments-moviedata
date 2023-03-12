package com.example.assignment4

import MovieData
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter(
    private val movieData: MutableList<MovieData>,
    private val imagesData: MutableMap<String, Int>
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private var myListener: ClickListener? = null

    interface ClickListener{
        fun onItemClicked(movie:MovieData)
        fun onLongClick(movie: MovieData,position: Int)
    }

    fun setClickListener (listener: Task1Fragment){
        this.myListener = listener
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setClearAll() {
        for (i in movieData.indices) {
            movieData[i].checked = false
        }
            notifyDataSetChanged()
    }
    @SuppressLint("NotifyDataSetChanged")
    fun setSelectAll() {
            for( i in movieData.indices){
                movieData[i].checked = true
            }
            notifyDataSetChanged()
    }

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val movieTitle: TextView = itemView.findViewById(R.id.type1_movieTitle)
        val movieDesc: TextView = itemView.findViewById(R.id.type1_movieDesc)
        val movieImage: ImageView = itemView.findViewById(R.id.movieImage)
        val rating: TextView = itemView.findViewById(R.id.rating)
        val checkBox : CheckBox = itemView.findViewById(R.id.checkBox)

        init {
            itemView.setOnClickListener {
                if (myListener != null){
                    myListener!!.onItemClicked(movieData[adapterPosition])
                }
            }
            itemView.setOnLongClickListener {
                if (myListener != null){
                    myListener!!.onLongClick(movieData[adapterPosition],adapterPosition)
                }
                true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):MovieViewHolder {

        val movieHolder : MovieViewHolder = if(viewType > 6){
            MovieViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_type_1,parent,false))
        } else{
            MovieViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_type_2,parent,false))

        }
        return movieHolder
    }

    override fun getItemViewType(position: Int): Int {
        return movieData[position].vote_average!!.toInt()
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

        val item = movieData[position]
        holder.movieTitle.text = item.title
        var length = item.overview!!.length
        length = if (length>70) 70 else length
        holder.movieDesc.text = item.overview.substring(0,length-1)+"..."
        holder.rating.text = """Rating: ${item.vote_average.toString()}"""
        holder.movieImage.setImageResource(imagesData[item.title]!!)
        holder.checkBox.isChecked = item.checked!!

        holder.checkBox.setOnClickListener {
            item.checked = holder.checkBox.isChecked
        }

    }

    override fun getItemCount(): Int {
       return movieData.size
    }

}








