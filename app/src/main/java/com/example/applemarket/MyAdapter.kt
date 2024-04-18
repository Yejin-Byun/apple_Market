package com.example.applemarket

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.applemarket.databinding.ItemRecyclerviewBinding
import java.text.DecimalFormat

class MyAdapter(private val list: ArrayList<ItemInfo>) : RecyclerView.Adapter<MyAdapter.Holder>() {

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

    var itemClick : ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.Holder {
        val binding = ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: MyAdapter.Holder, position: Int) {
        holder.itemView.setOnClickListener {
            itemClick?.onClick(it, position)
        }

        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class Holder(private val binding: ItemRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                itemClick?.onClick(it, adapterPosition)
            }
        }

        fun bind (itemInfo: ItemInfo) {
            binding.apply {
                itemImg.setImageResource(itemInfo.img)
                itemName.text = itemInfo.name

                val dec = DecimalFormat("#,###원")
                itemPrice.text = dec.format(itemInfo.price)

                itemLoacte.text = itemInfo.locate
                itemHeart.text = itemInfo.heart.toString()
                itemChat.text = itemInfo.chat.toString()
                // itemInfoText.text = itemInfo.info
                // itemSeller.text = itemInfo.seller
            }
        }
    }
}