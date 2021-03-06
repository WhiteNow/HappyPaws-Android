package pe.edu.upc.happypaws.controllers.fragments



import android.content.Intent
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
import com.azoft.carousellayoutmanager.CarouselLayoutManager
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.fragment_menu.*
import kotlinx.android.synthetic.main.fragment_menu.view.*
import kotlinx.android.synthetic.main.fragment_store.*

import kotlinx.android.synthetic.main.fragment_menu.*


import pe.edu.upc.happypaws.R

import pe.edu.upc.happypaws.adapters.MenuAdapter
import pe.edu.upc.happypaws.adapters.TaskAdapter
import pe.edu.upc.happypaws.controllers.activities.AddTaskActivity
import pe.edu.upc.happypaws.models.Pet
import pe.edu.upc.happypaws.networking.HappyPawsApi
import pe.edu.upc.happypaws.networking.PetsResponse

import pe.edu.upc.happypaws.controllers.activities.NewPetActivity
import pe.edu.upc.happypaws.models.PetTask
import java.util.*
import kotlin.collections.ArrayList


class MenuFragment : Fragment() {

    val TAG = "Pets_request"
    var pets = ArrayList<Pet>()

    lateinit var petRecycler: RecyclerView
    lateinit var taskRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getPets()
        button_task.setOnClickListener {
            val intent = Intent(activity, AddTaskActivity::class.java)
            startActivity(intent)
        }

        taskRecyclerView = taks_recycler
        taskRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = TaskAdapter(listOf(PetTask("1","Bañar a pelusa","Recomandable cada semana",false,"1",Date()),
                PetTask("1","Sacar a pasear pelusa","Hacerlo cada noche",false,"1",Date())))
        }
    }

    fun getPets() {
        AndroidNetworking.get(HappyPawsApi.petsUrl())
            .addHeaders("Content-Type","application/json")
            .addHeaders("authorization",HappyPawsApi.API_KEY)
            .setPriority(Priority.LOW)
            .setTag(TAG)
            .build()
            .getAsObject(
                PetsResponse::class.java,
                object: ParsedRequestListener<PetsResponse> {
                    override fun onResponse(response: PetsResponse?) {
                        response?.apply {
                            success.apply {
                                Log.i(TAG, "Total results: ${success}")
                            }
                            pets.apply {
                                petRecycler = view!!.pets_recycler
                                petRecycler.apply {
                                    layoutManager = LinearLayoutManager(view!!.context, LinearLayoutManager.HORIZONTAL, false)
                                    adapter = MenuAdapter(pets)
                                }
                                Log.i(TAG,pets[1].toString())
                            }
                        }
                    }
                    override fun onError(anError: ANError?) {
                        Log.i(TAG, anError?.message)
                    }

                })


        newPetFloatingActionButton.setOnClickListener {
            startActivity(Intent(this@MenuFragment.context,NewPetActivity::class.java))

        }

    }

}
