package pe.edu.upc.happypaws.adapters

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.androidnetworking.widget.ANImageView
import kotlinx.android.synthetic.main.layout_promo_item.view.*
import pe.edu.upc.happypaws.R
import pe.edu.upc.happypaws.controllers.activities.PromoActivity
import pe.edu.upc.happypaws.models.Promo
import java.text.SimpleDateFormat

class PromosAdapter(private var promos: List<Promo>):
        RecyclerView.Adapter<PromosAdapter.ViewHolder>() {

    class ViewHolder(promoView: View): RecyclerView.ViewHolder(promoView) {
        var imageView : ANImageView
        init {
            imageView = promoView.promo_imageview
        }
        fun bindTo(item: Promo) {
            imageView.setDefaultImageResId(R.drawable.camera)
            imageView.setImageUrl(item.picture)

            imageView.setOnClickListener {
                Log.d("Bryam", "presionando")
                Log.d("Bryam", item.picture)

                val format = SimpleDateFormat("dd/MM/yyy")

                val bundle = Bundle()
                bundle.apply {
                    putString("url", item.picture)
                    putString("title", item.title)
                    putString("description", item.description)
                    putString("date", format.format(item.expirate_date))
                    putString("price", item.price.toString())
                }
                val intent = Intent(it.context, PromoActivity::class.java)
                intent.putExtras(bundle)
                it.context.startActivity(intent)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PromosAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_promo_item, parent, false ))
    }

    override fun getItemCount(): Int {
        return promos.size
    }

    override fun onBindViewHolder(holder: PromosAdapter.ViewHolder, position: Int) {
        holder.bindTo(promos[position])
    }

}