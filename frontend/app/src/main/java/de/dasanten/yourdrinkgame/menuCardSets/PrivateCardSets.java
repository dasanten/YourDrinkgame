package de.dasanten.yourdrinkgame.menuCardSets;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import de.dasanten.yourdrinkgame.FullscreenActivity;
import de.dasanten.yourdrinkgame.R;
import de.dasanten.yourdrinkgame.localDataBase.CardSetViewModel;
import de.dasanten.yourdrinkgame.localDataBase.entitys.CardSetEntity;


public class PrivateCardSets extends Fragment {

    public NavController navController;

    private CardSetViewModel cardSetViewModel;
    private ArrayList<CardSetEntity> cardSetEntities = new ArrayList<>();

    public static final int NEW_CARD_SET_ACTIVITY_REQUEST_CODE = 1;

    public PrivateCardSets() {
        // Required empty public constructor
    }

    public static PrivateCardSets newInstance(String param1, String param2) {
        PrivateCardSets fragment = new PrivateCardSets();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == NEW_CARD_SET_ACTIVITY_REQUEST_CODE && resultCode == 1){
//            CardSetEntity cardSetEntity = new CardSetEntity(data.getStringExtra())
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //cardSetViewModel = new ViewModelProvider(this).get(CardSetViewModel.class);
        //cardSetEntities = cardSetViewModel.getSavedCardSets();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_private_card_sets, container, false);



        cardSetViewModel = new ViewModelProvider(this).get(CardSetViewModel.class);
        cardSetViewModel.getAllCardSets().observe(getViewLifecycleOwner(), new Observer<List<CardSetEntity>>() {
            @Override
            public void onChanged(List<CardSetEntity> cardSetEntities) {
                Toast.makeText(getActivity(), "onChanged", Toast.LENGTH_SHORT).show();
            }
        });

        RecyclerView recyclerView = view.findViewById(R.id.list_of_private_cardSets);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        CardSetAdapter cardSetAdapter = new CardSetAdapter(cardSetEntities);
        recyclerView.setAdapter(cardSetAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());






        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        view.findViewById(R.id.create_new_card_set).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_cardSetList_to_createNewCardSet);
            }
        });
    }



}
