package be.bxl.will.demoandroid.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import be.bxl.will.demoandroid.R
import be.bxl.will.demoandroid.interfaces.MediaListener
import be.bxl.will.demoandroid.models.Media

class MediaAdapter(private val medias : List<Media>, private val onItemClick : (media : Media) -> Unit) : RecyclerView.Adapter<MediaAdapter.ViewHolder>() {
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val tvTitle : TextView = view.findViewById(R.id.tv_title_item_media)
        val tvType : TextView = view.findViewById(R.id.tv_type_item_media)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_media_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentMedia = medias[position]
        holder.tvTitle.text = currentMedia.title
        holder.tvType.text = currentMedia.type

        holder.itemView.setOnClickListener {
            onItemClick(currentMedia)
        }
    }

    override fun getItemCount(): Int {
        return medias.size
    }
}