package de.dasanten.yourdrinkgame.menuCardSets;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import de.dasanten.yourdrinkgame.R;
import de.dasanten.yourdrinkgame.localDataBase.CardSetViewModel;
import de.dasanten.yourdrinkgame.localDataBase.entitys.CardEntity;
import de.dasanten.yourdrinkgame.localDataBase.entitys.CardSetEntity;

public class PrivateCardList extends Fragment {

    private int cardSetId;

    private CardSetViewModel cardSetViewModel;
    private ArrayList<CardEntity> cardEntities = new ArrayList<>();
    RecyclerView recyclerView;
    CardAdapter cardAdapter;


    public PrivateCardList() {
        // Required empty public constructor
    }

    public static PrivateCardList newInstance(String param1, String param2) {
        PrivateCardList fragment = new PrivateCardList();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cardSetId = getArguments().getInt("CardSetId");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_private_card_list, container, false);

        recyclerView = view.findViewById(R.id.list_of_private_cardSets);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        cardAdapter = new CardAdapter();
        recyclerView.setAdapter(cardAdapter);

        cardSetViewModel = new ViewModelProvider(this).get(CardSetViewModel.class);
//
//        CardEntity cardEntity = new CardEntity();
//        cardEntity.setContent("sauisdazsuidsgzsadlugdsoi");
//        cardEntity.setCardSetId(cardSetId);
//        cardSetViewModel.insertCard(cardEntity);
        cardSetViewModel.getCardsByCardSetId(cardSetId).observe(getViewLifecycleOwner(), new Observer<List<CardEntity>>() {
            @Override
            public void onChanged(List<CardEntity> cardEntityList) {
                System.out.println(cardEntityList.get(0).getContent());
                cardAdapter.setCardEntityList(cardEntityList);
//                ArrayList<CardEntity> cardEntityList = new ArrayList<>();
//                CardEntity cardEntity = new CardEntity(null, "exen", "nice", cardSetId, true);
//                cardSetViewModel.insertCard(cardEntity);
//                cardEntityList.add(cardEntity);
//                cardAdapter.setCardEntityList(cardEntityList);
            }
        });

        return view;
    }
}
