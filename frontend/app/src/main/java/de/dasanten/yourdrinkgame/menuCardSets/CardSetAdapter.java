package de.dasanten.yourdrinkgame.menuCardSets;

import android.content.Context;
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

public class CardSetAdapter extends RecyclerView.Adapter<CardSetAdapter.CardSetHolder> {

    class CardSetHolder extends RecyclerView.ViewHolder {
        private final TextView cardSetItemView;

        public CardSetHolder(@NonNull View itemView) {
            super(itemView);
            cardSetItemView = itemView.findViewById(R.id.textView);
        }
    }

    private final LayoutInflater inflater;
    private List<CardSetEntity> cardSetEntityList;

    CardSetAdapter(Context context) {inflater  = LayoutInflater.from(context);}

    @NonNull
    @Override
    public CardSetHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.recyclerview_item, parent, false);
        return new CardSetHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CardSetHolder holder, int position) {
        if (cardSetEntityList != null) {
            CardSetEntity cardSetEntity = cardSetEntityList.get(position);
            holder.cardSetItemView.setText(cardSetEntity.getName());
        } else {
            holder.cardSetItemView.setText("Keine Sets erstellt");
        }
    }

    void setCardSetEntityList(ArrayList<CardSetEntity> setCardSetEntityList){
        cardSetEntityList = setCardSetEntityList;
    }


    @Override
    public int getItemCount() {
        if (cardSetEntityList != null){
            return cardSetEntityList.size();
        }
        else return 0;
    }
}
