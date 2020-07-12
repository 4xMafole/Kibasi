package com.tancorp.kibasi.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.tancorp.kibasi.R;
import com.tancorp.kibasi.models.Bus;

public class BusAdapter extends RecyclerView.Adapter<BusAdapter.ViewHolder>
{
    private Bus[] _busListData;

    public BusAdapter(Bus[] busListData)
    {
        this._busListData = busListData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater _layoutInflater = LayoutInflater.from(parent.getContext());
        View _busListItem = _layoutInflater.inflate(R.layout.bus_selector_item, parent, false);
        return new ViewHolder(_busListItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        final String _busProfile = _busListData[position].getBusName();
        holder._busName.setText(_busListData[position].getBusName());
//        holder._busImage.setImageResource();
        holder._busJourneyTimeText.setText(_busListData[position].getBusJourneyTime());
        holder._busTicketPrice.setText(_busListData[position].getBusTicket());
        holder._busArrivalTime.setText(_busListData[position].getBusArrivalTime());
        holder._busDepartTime.setText(_busListData[position].getBusDepartTime());

        holder._layoutContainer.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(v.getContext(), _busProfile + " selected!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount()
    {
        return _busListData.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        public ImageView _busImage;
        public TextView _busJourneyTimeText;
        public TextView _busName;
        public TextView _busTicketPrice;
        public TextView _busDepartTime;
        public TextView _busArrivalTime;
        public ConstraintLayout _layoutContainer;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
//            this._busImage = itemView.findViewById(R.id.bus_image);
            this._busName = itemView.findViewById(R.id.bss_bus_name);
            this._busJourneyTimeText = itemView.findViewById(R.id.bss_bus_journey_time);
            this._busTicketPrice = itemView.findViewById(R.id.bss_bus_ticket_price);
            this._layoutContainer = itemView.findViewById(R.id.bus_item_card_container);
            this._busDepartTime = itemView.findViewById(R.id.bss_bus_depart_time);
            this._busArrivalTime = itemView.findViewById(R.id.bss_bus_arrival_time);
        }
    }
}