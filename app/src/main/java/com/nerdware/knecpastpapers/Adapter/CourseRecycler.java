package com.nerdware.knecpastpapers.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.nerdware.knecpastpapers.R;
import com.nerdware.knecpastpapers.model.CourseModel;
import java.util.ArrayList;

public class CourseRecycler extends RecyclerView.Adapter<CourseRecycler.ViewHolder> {
    private Activity activity;
    private ArrayList<CourseModel> courseModels;
    int Counter = 0;
    private CourseRecycler.OnItemClickListener onItemClickListener;

    public CourseRecycler(Activity activity, ArrayList<CourseModel> courseModels) {
        this.activity = activity;
        this.courseModels = courseModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.course_items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (courseModels != null && position < courseModels.size()) {
            CourseModel courseModel = courseModels.get(position);

            if (courseModel != null) {
                holder.imageView.setImageResource(courseModel.getImages_course());

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (onItemClickListener != null){
                            onItemClickListener.onItemClick(position);
                        }
                    }
                });
            }
        }
    }

    @Override
    public int getItemCount() {
        return courseModels != null ? courseModels.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.course_image);

        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    // Method to set the item click listener
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }
}
