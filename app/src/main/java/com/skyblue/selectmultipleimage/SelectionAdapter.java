package com.skyblue.selectmultipleimage;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.skyblue.selectmultipleimage.databinding.ModelImageBinding;
import java.util.List;

public class SelectionAdapter extends RecyclerView.Adapter<SelectionAdapter.ViewHolder> {
    private final Context context;
    private List<String> imageList;

    public SelectionAdapter(List<String> imageList, Context context){
        this.imageList = imageList;
        this.context = context;
    }

    @NonNull
    @Override
    public SelectionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ModelImageBinding binding = ModelImageBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SelectionAdapter.ViewHolder holder, int position) {
        Log.e("LOG_TAG", "image :" + imageList.get(position));

        holder.binding.thumbnail.setImageURI(Uri.parse(imageList.get(position)));

//        Glide.with(context)
//                .load(Uri.parse(imageList.get(position)))
//                .error(R.drawable.ic_launcher_background)
//                .into(holder.binding.thumbnail);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final ModelImageBinding binding;

        public ViewHolder(ModelImageBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
