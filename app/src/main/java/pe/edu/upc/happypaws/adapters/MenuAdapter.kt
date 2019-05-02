package pe.edu.upc.happypaws.adapters

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.androidnetworking.widget.ANImageView
import kotlinx.android.synthetic.main.pet_item_layout.view.*
import pe.edu.upc.happypaws.R
import pe.edu.upc.happypaws.controllers.activities.PetProfileActivity
import pe.edu.upc.happypaws.models.Pet

class MenuAdapter(private var pets: List<Pet>):
        RecyclerView.Adapter<MenuAdapter.ViewHolder>() {

    class ViewHolder(petView: View): RecyclerView.ViewHolder(petView) {
        var petImageView: ANImageView

        init {
            petImageView = petView.pet_image
        }

        fun bindTo(item: Pet) {
            petImageView.setImageUrl("https://images.pexels.com/photos/1663421/pexels-photo-1663421.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260")
            petImageView.setOnClickListener {
                val bundle = Bundle()
                bundle.apply {
                    putParcelable("pet", item)
                }
                val intent = Intent(it.context, PetProfileActivity::class.java)
                intent.putExtras(bundle)
                it.context.startActivity(intent)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.pet_item_layout, parent, false ))
    }

    override fun getItemCount(): Int {
        return pets.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindTo(pets[position])
    }

}