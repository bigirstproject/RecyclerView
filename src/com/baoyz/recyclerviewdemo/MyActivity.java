package com.baoyz.recyclerviewdemo;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MyActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my);
		initVertical();
	}

	public void initVertical() {
		RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview_vertical);

		// 创建一个线性布局管理器
		LinearLayoutManager layoutManager = new LinearLayoutManager(this);
		// 默认是Vertical，可以不写
		layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
		// 设置布局管理器
		recyclerView.setLayoutManager(layoutManager);

		// 创建数据集
		List<RecyclerViewItem> listDataVertical = new ArrayList<RecyclerViewItem>();
		for (int i = 0; i < 50; i++) {
			RecyclerViewItem item = new RecyclerViewItem();
			item.setId(i);
			item.setType(RecyclerViewItem.FIRST);
			item.setName("item" + i);
			listDataVertical.add(item);
		}
		List<RecyclerViewItem> listDataHorizontal = new ArrayList<RecyclerViewItem>();
		for (int i = 0; i < 50; i++) {
			RecyclerViewItem item = new RecyclerViewItem();
			item.setId(i);
			item.setType(RecyclerViewItem.SECOND);
			item.setName("item" + i);
			listDataHorizontal.add(item);
		}
		// 创建Adapter，并指定数据集
		MyAdapter adapter = new MyAdapter(this,listDataVertical,listDataHorizontal);
		// 设置Adapter
		recyclerView.setAdapter(adapter);
	}

}
