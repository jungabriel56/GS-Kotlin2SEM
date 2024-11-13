package br.com.github.jungabriel56.ecodicas.viewmodel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import br.com.github.jungabriel56.ecodicas.model.Tip
import carreiras.com.github.kotlin_android_lista_de_compras.R

class TipsAdapter(private val onTipRemoved: (Tip) -> Unit) :
    RecyclerView.Adapter<TipsAdapter.TipViewHolder>() {

    private var tips = listOf<Tip>()


    inner class TipViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val textView = view.findViewById<TextView>(R.id.textViewTip)
        val button = view.findViewById<ImageButton>(R.id.imageButton)

        fun bind(tip: Tip) {
            textView.text = tip.title
            button.setOnClickListener {
                onTipRemoved(tip)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.tip_layout, parent, false)
        return TipViewHolder(view)
    }

    override fun getItemCount(): Int = tips.size

    override fun onBindViewHolder(holder: TipViewHolder, position: Int) {
        val item = tips[position]
        //holder.bind(tips)
    }

    fun updateItems(newItems: List<Tip>) {
        tips = newItems
        notifyDataSetChanged()
    }
}
