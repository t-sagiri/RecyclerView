package com.test.testrecycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static final int DATASET_COUNT = 60;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    protected String[] mDataset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.main_list_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // アダプター
        initDataset();
        mAdapter = new MyAdapter(mDataset);
        recyclerView.setAdapter(mAdapter);
    }

    private void initDataset() {
        mDataset = new String[DATASET_COUNT];
        int i;
        for (i = 0; i < DATASET_COUNT; i++) {
            mDataset[i] = "This is element #" + i;
        }
    }
}
