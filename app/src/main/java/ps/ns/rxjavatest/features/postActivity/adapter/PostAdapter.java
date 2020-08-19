package ps.ns.rxjavatest.features.postActivity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ps.ns.rxjavatest.R;
import ps.ns.rxjavatest.network.asp.model.RestaurantModel;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    Context context;
    List<RestaurantModel> list;

    public PostAdapter(Context context, List<RestaurantModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public PostAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.post_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.ViewHolder holder, int position) {
        final RestaurantModel post = list.get(position);
        holder.user_id.setText(post.getId());
        holder.post_id.setText(post.getId());
        holder.title_post.setText(post.getTitle());
        holder.body_post.setText(post.getBody());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView user_id, post_id, title_post, body_post;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            user_id = itemView.findViewById(R.id.tv_id_user);
            post_id = itemView.findViewById(R.id.tv_id_post);
            title_post = itemView.findViewById(R.id.tv_title_post);
            body_post = itemView.findViewById(R.id.tv_body_post);
        }
    }
}
