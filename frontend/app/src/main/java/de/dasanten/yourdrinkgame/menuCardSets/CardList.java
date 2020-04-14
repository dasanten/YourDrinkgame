package de.dasanten.yourdrinkgame.menuCardSets;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import de.dasanten.yourdrinkgame.R;
import de.dasanten.yourdrinkgame.localDataBase.entitys.CardEntity;


public class CardList extends Fragment {

    public ArrayList<CardEntity> cardEntities;

    public CardList() {
        // Required empty public constructor
    }
    
    public static CardList newInstance(String param1, String param2) {
        CardList fragment = new CardList();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_card_list, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.card_textView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        CardAdapter cardAdapter = new CardAdapter(cardEntities);
        recyclerView.setAdapter(cardAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        return view;
    }
}
