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
import androidx.recyclerview.widget.ItemTouchHelper;
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
import de.dasanten.yourdrinkgame.localDataBase.entitys.CardEntity;
import de.dasanten.yourdrinkgame.localDataBase.entitys.CardSetEntity;


public class PrivateCardSets extends Fragment {

    public NavController navController;

    private CardSetViewModel cardSetViewModel;
    private ArrayList<CardSetEntity> cardSetEntities = new ArrayList<>();
    RecyclerView recyclerView;
    CardSetAdapter cardSetAdapter;


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

        recyclerView = view.findViewById(R.id.list_of_private_cardSets);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        cardSetAdapter = new CardSetAdapter();
        recyclerView.setAdapter(cardSetAdapter);

        cardSetViewModel = new ViewModelProvider(this).get(CardSetViewModel.class);



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

        cardSetViewModel.getAllCardSets().observe(getViewLifecycleOwner(), new Observer<List<CardSetEntity>>() {

            @Override
            public void onChanged(List<CardSetEntity> cardSetEntities) {
                cardSetAdapter.setCardSetEntityList(cardSetEntities);
            }
        });

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
//                cardSetViewModel.deleteCardSet(cardSetAdapter.getCardSetAt(viewHolder.getAdapterPosition()));
                ArrayList<CardEntity> cardEntityList = new ArrayList<>();
                CardEntity cardEntity = new CardEntity(null, "exen", "nice", cardSetAdapter.getCardSetAt(viewHolder.getAdapterPosition()).getLocalCardSetId(), true);
                cardSetViewModel.insertCard(cardEntity);
                cardEntityList.add(cardEntity);
            }


        }).attachToRecyclerView(recyclerView);
        cardSetAdapter.setOnItemClickListener(new CardSetAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(CardSetEntity cardSetEntity) {
                Bundle cardSetId = new Bundle();
                cardSetId.putInt("cardSetId", cardSetEntity.getLocalCardSetId());
                navController.navigate(R.id.action_cardSetList_to_privateCardList, cardSetId);
            }
        });


    }




}
