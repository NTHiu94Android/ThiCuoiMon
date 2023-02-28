package com.example.thicuoimon.Service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thicuoimon.Adapter.XeMayAdapter;
import com.example.thicuoimon.DAO.XeMayDAO;
import com.example.thicuoimon.Model.XeMay;

import java.util.ArrayList;

public class XeMayService extends Service {
    private XeMayDAO xeMayDAO;
    private ArrayList<XeMay> list = new ArrayList<>();
    private XeMayAdapter adapter;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        adapter = new XeMayAdapter();
        Toast.makeText(this, "Service đã được khởi tạo", Toast.LENGTH_SHORT).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        RecyclerView rcv = intent.getParcelableExtra("rcv");
        Context context = intent.getParcelableExtra("context");
        getListXeMay(context, rcv);
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service đã dừng", Toast.LENGTH_SHORT).show();
    }

    private void getListXeMay(Context context, RecyclerView rcv){
        list.clear();
        list = xeMayDAO.getAllXM();
        adapter.getData(context, list);

        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(RecyclerView.VERTICAL);

        rcv.setLayoutManager(layoutManager);
        rcv.setAdapter(adapter);
    }

    private void addNewXeMay(Intent intent){
        Bundle bundle = intent.getExtras();
        String strHangXe = bundle.getString("hangXe");
        String strTenXe = bundle.getString("tenXe");
        float strGiaXe = bundle.getFloat("giaXe");

        XeMay xeMay = new XeMay(strTenXe, strGiaXe, strHangXe);

        xeMayDAO.insertXM(xeMay);
        //getListXeMay();
        //Toast.makeText(context, "Thêm mới thành công!", Toast.LENGTH_SHORT).show();
    }

}
