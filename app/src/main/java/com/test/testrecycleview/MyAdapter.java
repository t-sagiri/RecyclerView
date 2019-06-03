package com.test.testrecycleview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    /*
     * 一覧のデータ
     */
    private List<AppInfo> mAppInfoList;

    /**
     * コンストラクタ
     *
     * @param myDataset 一覧するデータ内容を配列で受け取り、プロパティとして保持する
     */
    MyAdapter(List<AppInfo> myDataset) {
        mAppInfoList = myDataset;
    }

    /**
     * 各データ項目のビューへの参照を提供します
     * 複雑なデータアイテムでは、アイテムごとに複数のビューが必要になる場合があります。
     * ビューホルダー内のデータアイテムのすべてのビューにアクセスできるようにします。
     */
    static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        TextView textView1;
        TextView textView2;

        MyViewHolder(View v1) {
            super(v1);
            textView1 = v1.findViewById(R.id.textView1);
            textView2 = v1.findViewById(R.id.textView2);
        }
    }

    /**
     * View生成
     * {@inheritDoc}
     */
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_item, parent, false);
        return new MyViewHolder(v);
    }

    /**
     * Viewの内容を置き換える
     * {@inheritDoc}
     */
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // この位置にあるデータセットから要素を取得します
        // ビューの内容をその要素に置き換えます
        AppInfo appInfo = mAppInfoList.get(position);
        holder.textView1.setText(appInfo.getName());
        holder.textView2.setText(appInfo.getPackageName());
    }

    /**
     * データ・セット総数を返す
     * {@inheritDoc}
     */
    @Override
    public int getItemCount() {
        return mAppInfoList.size();
    }
}