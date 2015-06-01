package com.baoyz.recyclerviewdemo;

import java.util.List;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RecyclerViewAdapter extends
		RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

	private List<RecyclerViewItem> mlistDataHorizontal;

	public RecyclerViewAdapter() {
		super();
	}

	public void setData(List<RecyclerViewItem> mlistDataHorizontal) {
		this.mlistDataHorizontal = mlistDataHorizontal;
		notifyDataSetChanged();
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
		View view = View.inflate(viewGroup.getContext(),
				android.R.layout.simple_list_item_1, null);
		ViewHolder holder = new ViewHolder(view);
		return holder;
	}

	@Override
	public void onBindViewHolder(ViewHolder viewHolder, int position) {
		if (mlistDataHorizontal != null) {
			viewHolder.mTextView.setText(mlistDataHorizontal.get(position)
					.getName());
		}
	}

	@Override
	public int getItemCount() {
		return mlistDataHorizontal == null ? 0 : mlistDataHorizontal.size();
	}

	public static class ViewHolder extends RecyclerView.ViewHolder {

		public TextView mTextView;

		public ViewHolder(View itemView) {
			super(itemView);
			mTextView = (TextView) itemView;
		}
	}
}
