package com.test.testrecycleview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    /*
     * データ
     */
    private String[] mDataset;

    /**
     * コンストラクタ
     *
     * @param myDataset 一覧するデータ内容を配列で受け取り、プロパティとして保持する
     */
    public MyAdapter(String[] myDataset) {
        mDataset = myDataset;
    }

    /**
     * 各データ項目のビューへの参照を提供します
     * 複雑なデータアイテムでは、アイテムごとに複数のビューが必要になる場合があります。
     * ビューホルダー内のデータアイテムのすべてのビューにアクセスできるようにします。
     */
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textView;

        public MyViewHolder(View v1) {
            super(v1);
            textView = v1.findViewById(R.id.textView1);
        }
    }

    /**
     * View生成
     *
     * @param parent
     * @param viewType
     * @return
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
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // この位置にあるデータセットから要素を取得します
        // ビューの内容をその要素に置き換えます
        holder.textView.setText(mDataset[position]);
    }

    /**
     * データ・セット総数を返す
     *
     * @return int
     */
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}