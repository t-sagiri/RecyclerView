package com.test.testrecycleview;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * メイン画面
 *
 * @ref {https://developer.android.com/guide/topics/ui/layout/recyclerview}
 * @ref {https://github.com/googlesamples/android-RecyclerView}
 */
public class MainActivity extends AppCompatActivity {
    // private static final String TAG = "MainActivity";

    /**
     * listに表示する要素数
     */
    private static final int DATASET_COUNT = 60;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    /**
     * listに表示する内容
     */
    protected List<ApplicationInfo> mAppInfoList;

    /**
     * 画面表示
     *
     * @param savedInstanceState bundle
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 画面全体用xmlリソース
        setContentView(R.layout.activity_main);

        // 画面全体用のリソースから一覧になるViewを特定し、設定を行う
        recyclerView = findViewById(R.id.main_list_view);
        recyclerView.setHasFixedSize(true);

        // ListViewと同様の機能を得るためにLinearLayoutManagerをRecyclerViewに設定
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // listに表示する内容を生成、アダプタにセット
        initDataset();
        mAdapter = new MyAdapter(mAppInfoList);
        recyclerView.setAdapter(mAdapter);
    }

    /**
     * DATASET_COUNTの分だけデータを生成して、mDatasetにセットする
     */
    private void initDataset() {
        PackageManager pm = getPackageManager();
        mAppInfoList = pm.getInstalledApplications(PackageManager.GET_META_DATA);

/*        mDataset = new String[DATASET_COUNT];
        for (int i = 0; i < DATASET_COUNT; i++) {
            mDataset[i] = "This is element #" + i;
        } */
    }
}
