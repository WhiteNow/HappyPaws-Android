package pe.edu.upc.happypaws.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.androidnetworking.widget.ANImageView
import kotlinx.android.synthetic.main.layout_promo_item.view.*
import pe.edu.upc.happypaws.R
import pe.edu.upc.happypaws.models.Promo

class PromosAdapter(private var promos: List<Promo>):
        RecyclerView.Adapter<PromosAdapter.ViewHolder>() {

    class ViewHolder(promoView: View): RecyclerView.ViewHolder(promoView) {
        var imageView : ANImageView
        init {
            imageView = promoView.promo_imageview
        }
        fun bindTo(item: Promo) {
            imageView.setImageUrl(item.photo_url)
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