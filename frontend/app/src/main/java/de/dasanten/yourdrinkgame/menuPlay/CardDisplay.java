package de.dasanten.yourdrinkgame.menuPlay;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import de.dasanten.yourdrinkgame.R;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CardDisplay#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CardDisplay extends Fragment implements View.OnClickListener{


    TextView displayedString;
    public ArrayList<String> player = new ArrayList<>();
    Cards cards;
    public NavController navController = null;

    public CardDisplay() {
        // Required empty public constructor
    }


    public static CardDisplay newInstance(String param1, String param2) {
        CardDisplay fragment = new CardDisplay();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        player = getArguments().getStringArrayList("player");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_card_display, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        view.findViewById(R.id.card_display_fragment).setOnClickListener(this);
        displayedString = view.findViewById(R.id.string_display);
        cards = new Cards();
        onClick(view);
    }

    @Override
    public void onClick(View v) {
        String settedCard = "";
        if (cards.getCards().size() != 0) {
            do {
                if (cards.getCards().size() != 0) {
                    double rdm = (Math.random()) * cards.getCards().size();
                    settedCard = cards.getStringForCardDisplay((cards.getCards().get((int) rdm)), player);
                    cards.getCards().remove((int) rdm);
                } else {
                    navController.navigate(R.id.action_cardDisplay_to_menu);
                }
            }while (settedCard == null);
            displayedString.setText(settedCard);
        } else {
            navController.navigate(R.id.action_cardDisplay_to_menu);
        }
    }
}
