package com.example.fragment_test2.Adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fragment_test2.R
import com.example.fragment_test2.RecyclerView.Beer

// 하단 리사이클러뷰
class RecyclerAdapter_2(val context: Context, val beerList: ArrayList<Beer>) : RecyclerView.Adapter<RecyclerAdapter_2.ViewHolder>(){




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var v : View
        v = LayoutInflater.from(context).inflate(R.layout.alcohol_rv_item , parent, false)
        var holder = ViewHolder(v)

        return holder
    }

    override fun getItemCount(): Int {

        return beerList.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder?.bind(beerList[position])

    }



    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){


        var name = itemView.findViewById<TextView>(R.id.alcohol_name)
        var img = itemView.findViewById<ImageView>(R.id.alcohol_img)

        fun bind(beer : Beer) {
            Log.d("beer " , beer.alcohol_img)
            if (beer.alcohol_img != "") {
                val resourcId = context.resources.getIdentifier(beer.alcohol_img, "drawable",context.packageName)
                img?.setImageResource(resourcId)
            } else {
                img?.setImageResource(R.mipmap.ic_launcher)
            }

            name?.text = "${beer.alcohol_name}"


        }


    }

}


