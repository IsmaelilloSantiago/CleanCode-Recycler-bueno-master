package es.ulpgc.eite.cleancode.visitcanary.categories;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.eite.cleancode.visitcanary.R;
import es.ulpgc.eite.cleancode.visitcanary.data.CategoryItem;

public class CategoryListAdapter
    extends RecyclerView.Adapter<CategoryListAdapter.ViewHolder> {

  private List<CategoryItem> itemList;
  private final View.OnClickListener clickListener;


  public CategoryListAdapter(View.OnClickListener listener) {

    itemList = new ArrayList();
    clickListener = listener;
  }

  public void addItem(CategoryItem item){
    itemList.add(item);
    notifyDataSetChanged();
  }

  public void addItems(List<CategoryItem> items){
    itemList.addAll(items);
    notifyDataSetChanged();
  }

  public void setItems(List<CategoryItem> items){
    itemList = items;
    notifyDataSetChanged();
  }


  @Override
  public int getItemCount() {
    return itemList.size();
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.category_list_content, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(final ViewHolder holder, int position) {

    holder.itemView.setTag(itemList.get(position));
    holder.itemView.setOnClickListener(clickListener);

    //holder.contentView.setText(itemList.get(position).content);
    String url = itemList.get(position).content;
    //loadImageFromURL(holder.contentView,url);
    Uri uri = Uri.parse(url);
    holder.contentView.setImageURI(uri);
    loadImageFromURL(holder.contentView,url);
    //loadImageFromURL(holder.contentView,itemList.get(position).content);

  }

  private void loadImageFromURL(ImageView imageView, String imageUrl){
    RequestManager reqManager = Glide.with(imageView.getContext());
    RequestBuilder reqBuilder = reqManager.load(imageUrl);
    RequestOptions reqOptions = new RequestOptions();
    reqOptions.diskCacheStrategy(DiskCacheStrategy.ALL);
    reqBuilder.apply(reqOptions);
    reqBuilder.into(imageView);
  }


  class ViewHolder extends RecyclerView.ViewHolder {
    final ImageView contentView;

    ViewHolder(View view) {
      super(view);
      contentView = view.findViewById(R.id.imagen);
    }
  }
}
