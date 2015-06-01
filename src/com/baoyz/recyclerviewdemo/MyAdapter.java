package com.baoyz.recyclerviewdemo;

import java.util.List;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

	private Context mContext;
	private List<RecyclerViewItem> mlistDataVertical;
	private List<RecyclerViewItem> mlistDataHorizontal;

	public MyAdapter(Context context, List<RecyclerViewItem> listDataVertical,
			List<RecyclerViewItem> listDataHorizontal) {
		super();
		this.mContext = context;
		this.mlistDataVertical = listDataVertical;
		this.mlistDataHorizontal = listDataHorizontal;
	}

	@Override
	public int getItemViewType(int position) {
		if (position == 0 || position == 10|| position == 11|| position == 12) {
			return 0;
		} else {
			return 1;
		}
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
		switch (viewType) {
		case 0:
			View view0 = View.inflate(viewGroup.getContext(),
					R.layout.recyclerview_item_layout, null);
			ViewHolder holder0 = new ViewHolder(view0, viewType);
			return holder0;
		case 1:
		default:
			View view1 = View.inflate(viewGroup.getContext(),
					android.R.layout.simple_list_item_1, null);
			ViewHolder holder1 = new ViewHolder(view1, viewType);
			return holder1;
		}
	}

	@Override
	public void onBindViewHolder(ViewHolder viewHolder, int position) {
		int viewType = getItemViewType(position);
		switch (viewType) {
		case 0:
			if (viewHolder != null && viewHolder.mRecyclerView != null) {
				RecyclerViewAdapter adapter = (RecyclerViewAdapter) viewHolder.mRecyclerView
						.getAdapter();
				adapter.setData(mlistDataHorizontal);
			}
			break;
		case 1:
		default:
			if (viewHolder != null && viewHolder.mTextView != null) {
				if (position < 10) {
					viewHolder.mTextView.setText(mlistDataVertical.get(
							position - 1).getName());
				} else {
					viewHolder.mTextView.setText(mlistDataVertical.get(
							position - 4).getName());
				}
			}
			break;
		}
	}

	@Override
	public int getItemCount() {
		return mlistDataVertical.size() + 4;
	}

	public class ViewHolder extends RecyclerView.ViewHolder {

		public TextView mTextView;
		public RecyclerView mRecyclerView;

		public ViewHolder(View itemView, int viewType) {
			super(itemView);
			switch (viewType) {
			case 0:
				mRecyclerView = (RecyclerView) itemView
						.findViewById(R.id.recyclerview_horizontal);
				LinearLayoutManager layoutManager = new LinearLayoutManager(
						mContext);
				layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
				mRecyclerView.setLayoutManager(layoutManager);
				RecyclerViewAdapter adapter = new RecyclerViewAdapter();
				mRecyclerView.setAdapter(adapter);
				break;
			case 1:
			default:
				mTextView = (TextView) itemView;
				break;
			}
		}
	}
}
