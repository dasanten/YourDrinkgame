package de.dasanten.yourdrinkgame.menuCardSets;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import de.dasanten.yourdrinkgame.R;
import de.dasanten.yourdrinkgame.localDataBase.entitys.CardEntity;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {


    class CardViewHolder extends RecyclerView.ViewHolder {

        private final TextView cardItemView;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            cardItemView = itemView.findViewById(R.id.card_textView);
        }

    }

    private List<CardEntity> cardEntityList;

    public CardAdapter(ArrayList<CardEntity> cardEntityList){
        this.cardEntityList = cardEntityList;
    }

    public void setCardEntityList(List<CardEntity> cardEntityList) {
        this.cardEntityList = cardEntityList;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_card_item, parent, false);
        return new CardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
            CardEntity cardEntity = cardEntityList.get(position);
            holder.cardItemView.setText(cardEntity.getContent());
    }

    @Override
    public int getItemCount() {
        return cardEntityList.size();
    }
}
