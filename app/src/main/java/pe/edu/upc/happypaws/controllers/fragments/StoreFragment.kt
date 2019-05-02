package pe.edu.upc.happypaws.controllers.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_store.view.*

import pe.edu.upc.happypaws.R
import pe.edu.upc.happypaws.adapters.PromosAdapter
import pe.edu.upc.happypaws.models.Promo


class StoreFragment : Fragment() {

    lateinit var serviceRecycler: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_store, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        serviceRecycler = view.services_recycler
        serviceRecycler.apply {
            layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
            adapter = PromosAdapter(listOf(
                Promo("https://images.pexels.com/photos/1931393/pexels-photo-1931393.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"),
                Promo("https://images.pexels.com/photos/2202610/pexels-photo-2202610.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500")
            ))
        }
    }


}
