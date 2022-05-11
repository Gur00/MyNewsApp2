package com.example.mynewsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class horizontalAdapter extends RecyclerView.Adapter<horizontalAdapter.horizontalViewHolder>{
    private List<horizontal> hlist;
    private Context context;

    public horizontalAdapter(List<horizontal> hlist, Context context)
    {
        this.hlist = hlist;
        this.context = context;
    }
    @NonNull
    @Override
    public horizontalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View selectview = LayoutInflater.from(context).inflate(R.layout.layout1, parent,  false);
        return new horizontalViewHolder(selectview);
    }

    @Override
    public void onBindViewHolder(@NonNull horizontalAdapter.horizontalViewHolder holder, int position) {
        holder.imageHorizontal.setImageResource(hlist.get(position).getImage());


    }

    @Override
    public int getItemCount() {
        return hlist.size();
    }

    public class horizontalViewHolder extends RecyclerView.ViewHolder {
        ImageView imageHorizontal;
        public horizontalViewHolder(@NonNull View itemView) {
            super(itemView);
            imageHorizontal = itemView.findViewById(R.id.imageHorizontal);
        }
    }
}
