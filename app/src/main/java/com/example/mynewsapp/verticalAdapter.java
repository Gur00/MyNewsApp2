package com.example.mynewsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;
import java.util.List;

public class verticalAdapter<OnRowClickListener> extends RecyclerView.Adapter<verticalAdapter.verticaleviewholder> {

    private List<vertical> vList;
    private Context context;
    private OnRowClickListener OnRowClickListener ;

    public interface OnRowClickListner{
        void onItemClick (int position);

    }

    public verticalAdapter(List<com.example.mynewsapp.vertical> vlist, Context context, OnRowClickListner listner )
    {
        this.vList = vList;
        this.context = context;
        this.OnRowClickListener = OnRowClickListener;

    }


    @NonNull
    @Override
    public verticalAdapter.verticaleviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View iview = LayoutInflater.from(context).inflate(R.layout.vertical, parent, false);
        return new verticaleviewholder(iview, OnRowClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull verticalAdapter.verticaleviewholder holder, int position) {
        holder.vimage.setImageResource(vList.get(position).getImage());
        holder.name.setText(vList.get(position).getPlace_name());
        holder.descrp.setText(vList.get(position).getPlace_descrip());

    }

    @Override
    public int getItemCount() {
        return vList.size();
    }

    public class verticaleviewholder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView vimage;
        public TextView name, descrp;
        public OnRowClickListner OnRowClickListener;


        public verticaleviewholder(@NonNull View itemView, OnRowClickListener listener) {
            super(itemView);
            vimage = itemView.findViewById(R.id.ivertical);
            name = itemView.findViewById(R.id.iname);
            descrp = itemView.findViewById(R.id.despvert);
            this.OnRowClickListener = OnRowClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            OnRowClickListener.onItemClick(getAdapterPosition());
            
        }
    }
}
