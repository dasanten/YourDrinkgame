package de.dasanten.yourdrinkgame.menuCardSets;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import de.dasanten.yourdrinkgame.FullscreenActivity;
import de.dasanten.yourdrinkgame.R;
import de.dasanten.yourdrinkgame.localDataBase.CardSetViewModel;
import de.dasanten.yourdrinkgame.localDataBase.entitys.CardSetEntity;


public class CreateNewCardSet extends Fragment {

    private EditText inputCardSetName;
    private EditText inputCardSetDescription;
    private Button confirmCreateCardSet;
    private Button abortCreateCardSet;
    private CardSetViewModel cardSetViewModel;

    public NavController navController;


    public CreateNewCardSet() {
        // Required empty public constructor
    }

    public static CreateNewCardSet newInstance(String param1, String param2) {
        CreateNewCardSet fragment = new CreateNewCardSet();
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
        View view = inflater.inflate(R.layout.fragment_create_new_card_set, container, false);
        inputCardSetName = view.findViewById(R.id.card_set_name_input);
        inputCardSetDescription = view.findViewById(R.id.card_set_description_input);
        cardSetViewModel = new ViewModelProvider(this).get(CardSetViewModel.class);
        abortCreateCardSet = view.findViewById(R.id.abort_create_card_set);
        confirmCreateCardSet = view.findViewById(R.id.confirm_create_card_set);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);

        abortCreateCardSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_createNewCardSet_to_cardSetList);
            }
        });

        confirmCreateCardSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createCardSet(v);
            }
        });
    }

    private void createCardSet(View view){
        String name = inputCardSetName.getText().toString();
        String description = inputCardSetDescription.getText().toString();
        if (name.trim().isEmpty() || description.trim().isEmpty()){
            Toast.makeText(getContext(), "Bitte alle Felder ausfüllen", Toast.LENGTH_SHORT).show();
        } else {
            CardSetEntity cardSetEntity = new CardSetEntity(name, description, "asd", 1, "asd", "asda", true, true, true);
            cardSetViewModel.insertCardSet(cardSetEntity);
            Toast.makeText(getContext(), "Kartenset hinzugefügt", Toast.LENGTH_SHORT).show();
            navController = Navigation.findNavController(view);
            navController.navigate(R.id.action_createNewCardSet_to_cardSetList);
        }
    }
}
