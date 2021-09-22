package com.usama.retrofitblogger.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.usama.retrofitblogger.Model.ModelApiResponse
import com.usama.retrofitblogger.R

class NewsAdapter(private var newsList: List<ModelApiResponse>) :
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row_item_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: NewsAdapter.ViewHolder, position: Int) {
        val apiResponse: ModelApiResponse = newsList.get(position)

        val textViewSource = holder.sourceName
        textViewSource.text = apiResponse.getTitle()

        val textViewDescription = holder.sourceDescription
        textViewDescription.text = apiResponse.getDescription()

        val image = holder.mImage
        Picasso.get().load(apiResponse.getUrlToImage()).into(image)

    }

    override fun getItemCount(): Int {
        return newsList.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mImage = itemView.findViewById(R.id.mImage) as ImageView
        val sourceName = itemView.findViewById(R.id.sourceName) as TextView
        val sourceDescription = itemView.findViewById(R.id.sourceDescription) as TextView

    }
}