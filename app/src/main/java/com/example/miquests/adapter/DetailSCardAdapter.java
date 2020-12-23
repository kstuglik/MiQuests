package com.example.miquests.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.example.miquests.R;

import java.util.ArrayList;
import java.util.List;

public class DetailSCardAdapter extends ArrayAdapter<String> {

    Context myContext;
    ArrayList<String> arr;
    int currentPrize;

    public DetailSCardAdapter(@NonNull Context context, int resource, @NonNull List<String> objects) {
        super(context, resource, objects);
        myContext = context;
        arr = new ArrayList<>(objects);
    }

    public void setCurrentPrize(int currentPrize) {
        this.currentPrize = currentPrize;
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.details_card, null);
        }
        if (arr.size() > 0) {
            TextView txvDetails = convertView.findViewById(R.id.txvDetails);
            if (position % 5 == 0) {
                txvDetails.setTextColor(Color.parseColor("#FFC422"));
            }else{
                txvDetails.setTextColor(Color.parseColor("#eeeeee"));
            }
            int no_question = arr.size() - position;
            String txt = no_question + "\t$"+arr.get(position);
            txvDetails.setText(txt);

            if(no_question == currentPrize){
                txvDetails.setBackgroundColor(Color.parseColor("#000000"));
                txvDetails.setTextColor(Color.parseColor("#FF0000"));
            }
        }
        return convertView;
    }
}
