package pe.edu.upc.happypaws.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.androidnetworking.widget.ANImageView
import kotlinx.android.synthetic.main.layout_task_item.view.*
import pe.edu.upc.happypaws.R
import pe.edu.upc.happypaws.models.PetTask

class TaskAdapter(private var tasks: List<PetTask>): RecyclerView.Adapter<TaskAdapter.ViewHolder>() {


    class ViewHolder(taskView: View): RecyclerView.ViewHolder(taskView) {
        var taskImageView: ImageView
        var taskTitle: TextView
        var taskDescription: TextView
        init {
            taskImageView = taskView.imageView_task
            taskTitle = taskView.text_title_task
            taskDescription = taskView.text_description_task
        }
        fun bindTo(item: PetTask) {
            taskTitle.text = item.title
            taskDescription.text = item.description
        }
    }


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskAdapter.ViewHolder {
            return TaskAdapter.ViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.layout_task_item, parent, false)
            )
        }

        override fun getItemCount(): Int {
            return tasks.size
        }

        override fun onBindViewHolder(holder: TaskAdapter.ViewHolder, position: Int) {
            holder.bindTo(tasks[position])
        }

}