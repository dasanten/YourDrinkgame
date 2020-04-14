package de.dasanten.yourdrinkgame.menuCardSets;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import de.dasanten.yourdrinkgame.R;


public class CreateNewCardSet extends Fragment {

    private EditText inputCardSetName;

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

        final Button confirmCreateCardSet = view.findViewById(R.id.confirm_create_card_set);
        confirmCreateCardSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return view;
    }
}
