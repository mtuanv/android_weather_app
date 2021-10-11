package com.demo.ss7.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.demo.ss7.R;
import com.demo.ss7.model.DailyForecasts;
import com.demo.ss7.model.FiveDay;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DayAdapter extends RecyclerView.Adapter {

    private Activity activity;
    private FiveDay fiveDay;

    public DayAdapter(Activity activity, FiveDay fiveDay) {
        this.activity = activity;
        this.fiveDay = fiveDay;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View itemView = inflater.inflate(R.layout.item_day, parent, false);
        DayAdapter.DayHolder holder = new DayAdapter.DayHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        DayAdapter.DayHolder vh = (DayAdapter.DayHolder) holder;
        DailyForecasts weather = fiveDay.getDailyForecasts().get(position);
        vh.tvTime.setText(convertTime(weather.getDate()));
        vh.tvTemMax.setText(weather.getTemperature().getMaximum().getValue()+"");
        vh.tvTemMin.setText(weather.getTemperature().getMinimum().getValue()+"");
        String url = "";
        if(weather.getDay().getIcon() < 10){
            url = "http://developer.accuweather.com/sites/default/files/0" + weather.getDay().getIcon() + "-s.png";
        }else {
            url = "http://developer.accuweather.com/sites/default/files/" + weather.getDay().getIcon() + "-s.png";
        }
        Glide.with(activity).load(url).into(vh.icon);
    }

    @Override
    public int getItemCount() {
        return fiveDay.getDailyForecasts().size();
    }

    public static class DayHolder extends RecyclerView.ViewHolder {

        private TextView tvTime, tvTemMax, tvTemMin;
        private ImageView icon;

        public DayHolder(View itemView){
            super(itemView);
            tvTime = (TextView) itemView.findViewById(R.id.tvTime);
            icon = (ImageView) itemView.findViewById(R.id.icon);
            tvTemMax = (TextView) itemView.findViewById(R.id.tvTemMax);
            tvTemMin = (TextView) itemView.findViewById(R.id.tvTemMin);
        }

    }

    public String convertTime(String inputTime){
        SimpleDateFormat inFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date = null;
        try {
            date = inFormat.parse(inputTime);
        }catch (ParseException e){
            e.printStackTrace();
        }
        SimpleDateFormat outFormat = new SimpleDateFormat("EEEE");
        String goal = outFormat.format(date);
        return goal;
    }
}
