package de.dasanten.yourdrinkgame.menuCardSets;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import de.dasanten.yourdrinkgame.R;
import de.dasanten.yourdrinkgame.localDataBase.CardSetViewModel;
import de.dasanten.yourdrinkgame.localDataBase.entitys.CardSetEntity;

public class CardSetAdapter extends RecyclerView.Adapter<CardSetAdapter.CardSetViewHolder> {

    private OnItemClickListener listener;

    class CardSetViewHolder extends RecyclerView.ViewHolder {

        private final TextView cardSetTitleItemView;
        private final TextView cardSetDescriptionItemView;
        private final Switch cardSetSetStatusSwitch;


        public CardSetViewHolder(@NonNull View itemView) {
            super(itemView);
            cardSetTitleItemView = itemView.findViewById(R.id.card_set_title);
            cardSetDescriptionItemView = itemView.findViewById(R.id.card_set_description);
            cardSetSetStatusSwitch = itemView.findViewById(R.id.card_set_set_status_switch);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION){
                        listener.onItemClick(cardSetEntityList.get(position));
                    }
                }
            });

//            cardSetSetStatusSwitch.setOnCheckedChangeListener();
        }

    }



    private List<CardSetEntity> cardSetEntityList = new ArrayList<>();

    public CardSetAdapter(ArrayList<CardSetEntity> cardSetEntityList) {
        this.cardSetEntityList = cardSetEntityList;
    }

    public CardSetAdapter(){

    }

    public void setCardSetEntityList(List<CardSetEntity> cardSetEntityList){
        this.cardSetEntityList = cardSetEntityList;
        notifyDataSetChanged();
    }

    public CardSetEntity getCardSetAt(int position){
        return cardSetEntityList.get(position);
    }


    @NonNull
    @Override
    public CardSetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_card_set_item, parent, false);
        return new CardSetViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CardSetViewHolder holder, int position) {
            final CardSetEntity cardSetEntity = cardSetEntityList.get(position);
            holder.cardSetTitleItemView.setText(cardSetEntity.getName());
            holder.cardSetDescriptionItemView.setText(cardSetEntity.getDescription());
    }

    @Override
    public int getItemCount() {
        return cardSetEntityList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(CardSetEntity cardSetEntity);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.listener = onItemClickListener;

    }

}
