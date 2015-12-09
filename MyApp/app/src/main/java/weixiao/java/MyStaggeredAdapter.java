package weixiao.java;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.demo.myapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/12/8.
 */
public class MyStaggeredAdapter extends RecyclerView.Adapter<MyStaggeredAdapter.MyStaggeredViewHolder> {

    private List<String> mData;
    private LayoutInflater mInflater;
    Context context;
    private List<Integer> mHeight;
    public MyStaggeredAdapter(Context context, List<String> mData) {
        this.context = context;
        this.mData = mData;
        mInflater = LayoutInflater.from(context);
        mHeight = new ArrayList<>();
        for(int i=0;i<mData.size();i++){
            mHeight.add((int) (100+Math.random()*300));
        }
    }

    @Override
    public MyStaggeredViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_recycle_stagger, parent, false);
        MyStaggeredViewHolder myViewHolder = new MyStaggeredViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyStaggeredViewHolder holder, int position) {
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        layoutParams.height = mHeight.get(position);
        holder.itemView.setLayoutParams(layoutParams);
        holder.tvItem.setText(mData.get(position));

    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

    static class MyStaggeredViewHolder extends RecyclerView.ViewHolder {
        TextView tvItem;

        public MyStaggeredViewHolder(View itemView) {
            super(itemView);
            tvItem = (TextView) itemView.findViewById(R.id.tv_recycle_staggered_item);


        }
    }
}
