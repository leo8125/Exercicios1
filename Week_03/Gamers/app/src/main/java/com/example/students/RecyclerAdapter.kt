package com.example.students
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_layout.view.*

 class RecyclerAdapter (private val names : List<User>):
        RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){

            var toastGlobal: Toast? = null
            inner class     ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

                val itemName: TextView = itemView.tv_names
                val itemPoints: TextView = itemView.tv_points

                init {
                    itemView.setOnClickListener {
                        toastGlobal?.cancel()
                        val userPosition = names[adapterPosition]
                        val classified: String = itemView.context.getString(R.string.classified, userPosition.name)
                        val declassified: String = itemView.context.getString(R.string.declassified, userPosition.name)
                        val validationText = if (userPosition.points >= 50) {
                            classified
                        }else{
                            declassified
                        }
                        toastGlobal = Toast.makeText(itemView.context, validationText, Toast.LENGTH_SHORT)
                        toastGlobal?.show()
                    }
                }
            }
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
              val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
                return ViewHolder(view)
            }




            @SuppressLint("StringFormatMatches")
            override fun onBindViewHolder(holder: ViewHolder, position: Int) {
               val currentItem = names[position]
                val pointString: String = holder.itemView.context.getString(R.string.points, currentItem.points)

                holder.itemName.text = currentItem.name
                holder.itemPoints.text = pointString

            }

     override fun getItemCount() = names.size

        }

