package com.sample.arch.forbidden.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.sample.arch.forbidden.R;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private String[] mLocalDataSet;
    private static View.OnClickListener mOnClickListener;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public ViewHolder(View view) {
            super(view);
            textView = (TextView) view.findViewById(R.id.textView);
            textView.setClickable(true);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mOnClickListener!=null) {
                        mOnClickListener.onClick(v);
                    }
                }
            });
        }

        public TextView getTextView() {
            return textView;
        }
    }

    public ListAdapter(String[] dataSet) {
        mLocalDataSet = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.text_row_item, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        viewHolder.getTextView().setText(mLocalDataSet[position]);
    }

    @Override
    public int getItemCount() {
        return mLocalDataSet.length;
    }

    public void setOnClickListener(View.OnClickListener listener){
        mOnClickListener = listener;
    }
}
