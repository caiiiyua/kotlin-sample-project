package com.caiiiyua.myapplication.ui.main

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.caiiiyua.myapplication.R
import com.caiiiyua.myapplication.data.remote.model.Ribot
import com.caiiiyua.myapplication.ui.main.RibotsAdapter.RibotViewHolder
import javax.inject.Inject

/**
 * Created by pp on 22/02/18.
 */
class RibotsAdapter
@Inject
constructor() : RecyclerView.Adapter<RibotViewHolder>() {

    var ribots = emptyList<Ribot>()

    override fun onBindViewHolder(holder: RibotViewHolder, position: Int) {
        val ribot = ribots[position]

        holder.hexColorView.setBackgroundColor(Color.parseColor(ribot.profile.hexColor))
        holder.nameTextView.text = "%s %s".format(ribot.profile.name.first, ribot.profile.name.last)
        holder.emailTextView.text = ribot.profile.email
    }

    override fun getItemCount(): Int = ribots.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RibotViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_ribots, parent, false)
        return RibotViewHolder(itemView)
    }


    inner class RibotViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @BindView(R.id.view_hex_color)
        lateinit var hexColorView: View

        @BindView(R.id.text_name)
        lateinit var nameTextView: TextView

        @BindView(R.id.text_email)
        lateinit var emailTextView: TextView

        init {
            ButterKnife.bind(this, itemView)
        }
    }
}
