package com.example.orderbangjago;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Mahasiswa> movieItems;

    public CustomListAdapter(Activity activity, List<Mahasiswa> movieItems) {
        this.activity = activity;
        this.movieItems = movieItems;
    }
    @Override
    public int getCount() {
        return movieItems.size();
    }

    @Override
    public Object getItem(int location) {
        return  movieItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list, null);
        TextView nama = (TextView) convertView.findViewById(R.id.text_nama);
        TextView kelas = (TextView) convertView.findViewById(R.id.text_kelas);
        TextView jumlah = (TextView) convertView.findViewById(R.id.text_jumlah);
        Mahasiswa m = movieItems.get(position);
        nama.setText("Nama Pemesan : "+ m.get_nama());
        kelas.setText("Menu Pesanan : "+ m.get_kelas());
        jumlah.setText("Jumlah Pesanan : "+ m.get_jumlah());
        return convertView;
    }
}