package pe.edu.upc.happypaws.controllers.fragments


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import kotlinx.android.synthetic.main.fragment_store.*
import kotlinx.android.synthetic.main.fragment_store.view.*

import pe.edu.upc.happypaws.R
import pe.edu.upc.happypaws.adapters.PromosAdapter
import pe.edu.upc.happypaws.models.Promo
import pe.edu.upc.happypaws.networking.AdsResponse
import pe.edu.upc.happypaws.networking.HappyPawsApi


class StoreFragment : Fragment() {

    val TAG = "StoreTag"
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
        getAdds()

    }

    fun getAdds() {
        AndroidNetworking.get(HappyPawsApi.adsUrl()).addHeaders("Content-Type", "application/json")
            .addHeaders("authorization", HappyPawsApi.API_KEY).setTag(TAG).setPriority(Priority.LOW)
            .build().getAsObject(AdsResponse::class.java, object: ParsedRequestListener<AdsResponse> {
                override fun onResponse(response: AdsResponse?) {
                    response?.apply {
                        success.apply {
                            Log.d(TAG, "Success: ${success}")
                        }

                        advertisements.apply {
                            for (ad in advertisements) {
                                Log.d(TAG, ad.description)
                            }
                            serviceRecycler = services_recycler
                            serviceRecycler.apply {
                                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                                adapter = PromosAdapter(advertisements)
                            }
                        }
                    }
                }

                override fun onError(anError: ANError?) {
                    Log.e(TAG, anError?.message.toString())
                }

            })
    }


}
