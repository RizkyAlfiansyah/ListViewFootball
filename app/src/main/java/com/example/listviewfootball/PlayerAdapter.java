package com.example.listviewfootball;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

class PlayerAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Player> players;


    public PlayerAdapter(Context context) {
        this.context = context;
        players = new ArrayList<>();
    }

    public void setPlayer (ArrayList<Player> players) {
        this.players = players;
    }

    @Override
    public int getCount() {
        return players.size();
    }

    @Override
    public Object getItem(int i) {
        return players.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null) {
            view = LayoutInflater.from(context).
                    inflate(R.layout.item_player,viewGroup,false);
        }
        ViewHolder viewHolder = new ViewHolder(view);
        Player player = (Player) getItem(i);
        viewHolder.bind(player);
        return view;
    }

    private class ViewHolder {
        private TextView txtName;
        private TextView txtDescription;
        private ImageView imgPhoto;

        ViewHolder (View view){
            txtName = view.findViewById(R.id.txt_name);
            txtDescription = view.findViewById(R.id.txt_description);
            imgPhoto = view.findViewById(R.id.img_photo);
        }

        void bind(Player player){
            txtName.setText(player.getName());
            txtDescription.setText(player.getDescription());
            imgPhoto.setImageResource(player.getPhoto());
        }

    }

}
