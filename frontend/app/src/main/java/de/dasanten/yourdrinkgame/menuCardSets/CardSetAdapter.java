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
import de.dasanten.yourdrinkgame.localDataBase.entitys.CardSetEntity;

public class CardSetAdapter extends RecyclerView.Adapter<CardSetAdapter.CardSetViewHolder> {


    class CardSetViewHolder extends RecyclerView.ViewHolder {

        private final TextView cardSetItemView;


        public CardSetViewHolder(@NonNull View itemView) {
            super(itemView);
            cardSetItemView = itemView.findViewById(R.id.card_set_textView);
        }

    }



    private List<CardSetEntity> cardSetEntityList;

    public CardSetAdapter(ArrayList<CardSetEntity> cardSetEntityList) {
        this.cardSetEntityList = cardSetEntityList;
    }

    public void setCardSetEntityList(ArrayList<CardSetEntity> cardSetEntityList){
        this.cardSetEntityList = cardSetEntityList;
    }

    @NonNull
    @Override
    public CardSetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_card_set_item, parent, false);
        return new CardSetViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CardSetViewHolder holder, int position) {
            CardSetEntity cardSetEntity = cardSetEntityList.get(position);
            holder.cardSetItemView.setText(cardSetEntity.getName());
    }

    @Override
    public int getItemCount() {
        return cardSetEntityList.size();
    }
}
