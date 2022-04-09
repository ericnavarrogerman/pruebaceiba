package com.example.pruebaceiba.feature.post.ui.adapters

import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebaceiba.feature.post.ui.models.ItemPost

class PostAdapter(var list: List<ItemPost> = ArrayList()): RecyclerView.Adapter<PostAdapter.ViewHolder>() {



    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var title: TextView = v.findViewWithTag("title")
        var body: TextView = v.findViewWithTag("body")

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ViewHolder(LinearLayout(parent.context).apply {
        orientation = LinearLayout.VERTICAL
        layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        addView(TextView(context).apply {
            tag = "title"
            setTextColor(Color.MAGENTA)
            textSize = 18f
        })
        addView(TextView(context).apply {
            tag = "body"
            setTextColor(Color.BLACK)
        })
        addView(View(context).apply {
            setBackgroundColor(Color.DKGRAY)
            layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1)
        })
    })

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.title.text = list[position].title
        holder.body.text = list[position].body

    }

    override fun getItemCount() = list.size


}