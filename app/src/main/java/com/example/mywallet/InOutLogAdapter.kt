package com.example.mywallet

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat

class InOutLogAdapter internal constructor(context:Context): RecyclerView.Adapter<InOutLogAdapter.InOutLogViewHolder>() {

    //Declare local variable for the Adapter
    private val inflater= LayoutInflater.from(context)
    private var inOutLogList = emptyList<InOutLog>()

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): InOutLogViewHolder {

        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)

        return InOutLogViewHolder(itemView)


    }

    override fun getItemCount(): Int {
        return inOutLogList.size

    }

    override fun onBindViewHolder(holder: InOutLogViewHolder, position: Int) {
        val inOutLog = inOutLogList.get(position)

        if(inOutLog.type == 1){ // Income
            holder.textViewType.text = "Income"
        }else {
            holder.textViewType.text = "Expense"
        }

        holder.textViewAmount.text = inOutLog.amount.toString()
        holder.textViewDate.text = SimpleDateFormat("yyyy.MM.dd.HH:MM")
        .format(inOutLog.created_at)


    }


    fun setInOutLogList(inoutLogList: List<InOutLog>){
        this.inOutLogList = inoutLogList
        notifyDataSetChanged()

    }

    inner class InOutLogViewHolder(itemView: View)
            : RecyclerView.ViewHolder (itemView){

            val textViewType: TextView = itemView.findViewById(R.id.textViewType)
            val textViewAmount: TextView = itemView.findViewById(R.id.textViewAmount)
            val textViewDate: TextView = itemView.findViewById(R.id.textViewDate)

        }

}